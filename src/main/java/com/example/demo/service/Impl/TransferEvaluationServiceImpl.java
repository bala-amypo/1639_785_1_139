// // package com.example.demo.service.impl;

// // import java.util.List;

// // import org.springframework.beans.factory.annotation.Autowired;
// // import org.springframework.stereotype.Service;   
// // import com.example.demo.entity.TransferEvaluationResult;
// // import com.example.demo.repository.TransferEvaluationResultRepository;
// // // import org.springframework.web.bind.annotation.PathVariable;
// // import com.example.demo.service.TransferEvaluationService;                

// // @Service
// // public class TransferEvaluationServiceImpl implements TransferEvaluationService{

// //     @Autowired TransferEvaluationResultRepository used;
// //     @Override
// //     public TransferEvaluationResult postData4(TransferEvaluationResult use){
// //         return used.save(use);  
// //     }
// //     @Override
// //     public List<TransferEvaluationResult>getAllData4(){
// //         return used.findAll();
// //     }
// //     @Override
// //     public String DeleteData4(Long id){
// //         used.deleteById(id);
// //         return "Deleted successfully";
// //     }
// //     @Override
// //     public TransferEvaluationResult getEvaluationById(Long id){
// //     return used.findById(id).orElse(null);
// //     }
// //     @Override
// //     public TransferEvaluationResult updateData4(Long id,TransferEvaluationResult entity){
// //         if(used.existsById(id)){
// //             entity.setId(id);
// //             return used.save(entity);
// //         } 
// //         return null;
// //     }


// // }
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

import com.example.demo.entity.*;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.*;
import com.example.demo.service.TransferEvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransferEvaluationServiceImpl implements TransferEvaluationService {

    @Autowired
    private CourseRepository courseRepo;

    @Autowired
    private CourseContentTopicRepository topicRepo;

    @Autowired
    private TransferRuleRepository ruleRepo;

    @Autowired
    private TransferEvaluationResultRepository resultRepo;

    @Override
    public TransferEvaluationResult evaluateTransfer(Long sourceCourseId, Long targetCourseId) {
        Course source = courseRepo.findById(sourceCourseId)
                .orElseThrow(() -> new ResourceNotFoundException("Source course", sourceCourseId));

        Course target = courseRepo.findById(targetCourseId)
                .orElseThrow(() -> new ResourceNotFoundException("Target course", targetCourseId));

        if (!source.isActive() || !target.isActive()) {
            throw new IllegalArgumentException("Both courses must be active");
        }

        List<CourseContentTopic> sourceTopics = topicRepo.findByCourseId(sourceCourseId);
        List<CourseContentTopic> targetTopics = topicRepo.findByCourseId(targetCourseId);

        double overlap = 0.0;
        double totalSourceWeight = sourceTopics.stream()
                .mapToDouble(CourseContentTopic::getWeightPercentage)
                .sum();
        if (totalSourceWeight == 0) totalSourceWeight = 100.0;

        for (CourseContentTopic st : sourceTopics) {
            targetTopics.stream()
                    .filter(tt -> tt.getTopicName().equalsIgnoreCase(st.getTopicName()))
                    .findFirst()
                    .ifPresent(tt -> overlap += Math.min(st.getWeightPercentage(), tt.getWeightPercentage()));
        }

        double overlapPercentage = (overlap / totalSourceWeight) * 100;

        List<TransferRule> rules = ruleRepo.findBySourceUniversityIdAndTargetUniversityIdAndActiveTrue(
                source.getUniversity().getId(), target.getUniversity().getId());

        TransferEvaluationResult result = new TransferEvaluationResult();
        result.setSourceCourse(source);
        result.setTargetCourse(target);
        result.setOverlapPercentage(overlapPercentage);

        boolean eligible = false;
        StringBuilder notes = new StringBuilder();

        if (rules.isEmpty()) {
            notes.append("No active transfer rule found between universities.");
        } else {
            for (TransferRule rule : rules) {
                boolean creditOk = Math.abs(source.getCreditHours() - target.getCreditHours()) <= rule.getCreditHourTolerance();
                boolean overlapOk = overlapPercentage >= rule.getMinimumOverlapPercentage();
                if (creditOk && overlapOk) {
                    eligible = true;
                    break;
                } else {
                    notes.append("Rule not satisfied: requires ")
                            .append(rule.getMinimumOverlapPercentage())
                            .append("% overlap and ±")
                            .append(rule.getCreditHourTolerance())
                            .append(" credit hours. ");
                }
            }
        }

        if (!eligible && notes.length() == 0) {
            notes.append("No active rule satisfied.");
        }

        result.setIsEligibleForTransfer(eligible);
        result.setNotes(notes.toString());

        return resultRepo.save(result);
    }

    @Override
    public TransferEvaluationResult getEvaluationById(Long id) {
        return resultRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Evaluation result", id));
    }

    @Override
    public List<TransferEvaluationResult> getEvaluationsForCourse(Long courseId) {
        return resultRepo.findBySourceCourseId(courseId);
    }
}