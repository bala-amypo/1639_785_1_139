









// package com.example.demo.service.impl;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;   
// import com.example.demo.entity.TransferEvaluationResult;
// import com.example.demo.repository.TransferEvaluationResultRepository;
// // import org.springframework.web.bind.annotation.PathVariable;
// import com.example.demo.service.TransferEvaluationService;                

// @Service
// public class TransferEvaluationServiceImpl implements TransferEvaluationService{

//     @Autowired TransferEvaluationResultRepository used;
//     @Override
//     public TransferEvaluationResult postData4(TransferEvaluationResult use){
//         return used.save(use);  
//     }
//     @Override
//     public List<TransferEvaluationResult>getAllData4(){
//         return used.findAll();
//     }
//     @Override
//     public String DeleteData4(Long id){
//         used.deleteById(id);
//         return "Deleted successfully";
//     }
//     @Override
//     public TransferEvaluationResult getEvaluationById(Long id){
//     return used.findById(id).orElse(null);
//     }
//     @Override
//     public TransferEvaluationResult updateData4(Long id,TransferEvaluationResult entity){
//         if(used.existsById(id)){
//             entity.setId(id);
//             return used.save(entity);
//         } 
//         return null;
//     }
// }











// package com.example.demo.service.impl;

// import java.util.*;
// import com.example.demo.entity.*;
// import com.example.demo.repository.*;

// public class TransferEvaluationServiceImpl {

//     private CourseRepository courseRepo;
//     private CourseContentTopicRepository topicRepo;
//     private TransferRuleRepository ruleRepo;
//     private TransferEvaluationResultRepository resultRepo;

//     public TransferEvaluationResult evaluateTransfer(Long srcId, Long tgtId) {

//         Course src = courseRepo.findById(srcId).orElseThrow();
//         Course tgt = courseRepo.findById(tgtId).orElseThrow();

//         if (!src.isActive() || !tgt.isActive())
//             throw new IllegalArgumentException("Course must be active");

//         List<CourseContentTopic> sTopics = topicRepo.findByCourseId(srcId);
//         List<CourseContentTopic> tTopics = topicRepo.findByCourseId(tgtId);

//         double overlap = 0;
//         for (CourseContentTopic s : sTopics) {
//             for (CourseContentTopic t : tTopics) {
//                 if (s.getTopicName().equalsIgnoreCase(t.getTopicName())) {
//                     overlap += Math.min(
//                         Optional.ofNullable(s.getWeightPercentage()).orElse(0.0),
//                         Optional.ofNullable(t.getWeightPercentage()).orElse(0.0)
//                     );
//                 }
//             }
//         }

//         TransferEvaluationResult res = new TransferEvaluationResult();
//         res.setOverlapPercentage(overlap);

//         List<TransferRule> rules =
//                 ruleRepo.findBySourceUniversityIdAndTargetUniversityIdAndActiveTrue(
//                         src.getUniversity().getId(),
//                         tgt.getUniversity().getId());

//         boolean eligible = rules.stream().anyMatch(r ->
//                 overlap >= r.getMinimumOverlapPercentage() &&
//                 Math.abs(src.getCreditHours() - tgt.getCreditHours())
//                         <= Optional.ofNullable(r.getCreditHourTolerance()).orElse(0)
//         );

//         res.setIsEligibleForTransfer(eligible);
//         res.setNotes(eligible ? "Eligible" : "No active rule satisfied");

//         return resultRepo.save(res);
//     }

//     public TransferEvaluationResult getEvaluationById(Long id) {
//         return resultRepo.findById(id)
//                 .orElseThrow(() -> new RuntimeException("Evaluation not found"));
//     }

//     public List<TransferEvaluationResult> getEvaluationsForCourse(Long courseId) {
//         return resultRepo.findBySourceCourseId(courseId);
//     }
// }










package com.example.demo.service.impl;

import com.example.demo.entity.Course;
import com.example.demo.entity.CourseContentTopic;
import com.example.demo.entity.TransferEvaluationResult;
import com.example.demo.entity.TransferRule;
import com.example.demo.repository.CourseContentTopicRepository;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.TransferEvaluationResultRepository;
import com.example.demo.repository.TransferRuleRepository;
import com.example.demo.service.TransferEvaluationService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TransferEvaluationServiceImpl implements TransferEvaluationService {

    private CourseRepository courseRepo;
    private CourseContentTopicRepository topicRepo;
    private TransferRuleRepository ruleRepo;
    private TransferEvaluationResultRepository resultRepo;

    @Override
    public TransferEvaluationResult evaluateTransfer(Long sourceCourseId, Long targetCourseId) {
        Course src = courseRepo.findById(sourceCourseId)
                .orElseThrow(() -> new RuntimeException("not found"));
        Course tgt = courseRepo.findById(targetCourseId)
                .orElseThrow(() -> new RuntimeException("not found"));

        if (!Boolean.TRUE.equals(src.isActive()) || !Boolean.TRUE.equals(tgt.isActive())) {
            throw new IllegalArgumentException("active");
        }

        List<CourseContentTopic> srcTopics = topicRepo.findByCourseId(sourceCourseId);
        List<CourseContentTopic> tgtTopics = topicRepo.findByCourseId(targetCourseId);

        double totalSource = srcTopics.stream()
                .mapToDouble(t -> t.getWeightPercentage() == null ? 0.0 : t.getWeightPercentage())
                .sum();
        if (totalSource == 0) {
            totalSource = 100.0;
        }

        double matched = 0.0;
        for (CourseContentTopic s : srcTopics) {
            for (CourseContentTopic t : tgtTopics) {
                if (s.getTopicName() != null &&
                    s.getTopicName().equalsIgnoreCase(t.getTopicName())) {
                    matched += Math.min(
                            s.getWeightPercentage() == null ? 0.0 : s.getWeightPercentage(),
                            t.getWeightPercentage() == null ? 0.0 : t.getWeightPercentage());
                }
            }
        }
        double overlap = totalSource == 0 ? 0 : (matched / totalSource) * 100.0;

        List<TransferRule> rules =
                ruleRepo.findBySourceUniversityIdAndTargetUniversityIdAndActiveTrue(
                        src.getUniversity().getId(), tgt.getUniversity().getId());

        boolean eligible;
        String notes;

        if (rules.isEmpty()) {
            eligible = false;
            notes = "No active transfer rule";
        } else {
            eligible = false;
            notes = "No active rule satisfied";
            for (TransferRule r : rules) {
                int tol = r.getCreditHourTolerance() == null ? 0 : r.getCreditHourTolerance();
                boolean creditOk =
                        Math.abs(src.getCreditHours() - tgt.getCreditHours()) <= tol;
                if (creditOk && overlap >= r.getMinimumOverlapPercentage()) {
                    eligible = true;
                    notes = "Eligible";
                    break;
                }
            }
        }

        TransferEvaluationResult result = new TransferEvaluationResult();
        result.setSourceCourse(src);
        result.setTargetCourse(tgt);
        result.setOverlapPercentage(overlap);
        result.setIsEligibleForTransfer(eligible);
        result.setNotes(notes);
        return resultRepo.save(result);
    }

    @Override
    public TransferEvaluationResult getEvaluationById(Long id) {
        return resultRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("not found"));
    }

    @Override
    public java.util.List<TransferEvaluationResult> getEvaluationsForCourse(Long sourceCourseId) {
        return resultRepo.findBySourceCourseId(sourceCourseId);
    }
}
