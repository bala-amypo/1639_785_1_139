









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

    // existing evaluateTransfer, getEvaluationById, getEvaluationsForCourse stay as before

    @Override
    public TransferEvaluationResult postData4(TransferEvaluationResult result) {
        return resultRepo.save(result);
    }

    @Override
    public java.util.List<TransferEvaluationResult> getAllData4() {
        return resultRepo.findAll();
    }

    @Override
    public void DeleteData4(Long id) {
        resultRepo.deleteById(id);
    }

    @Override
    public TransferEvaluationResult updateData4(Long id, TransferEvaluationResult result) {
        TransferEvaluationResult existing = resultRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("not found"));
        existing.setSourceCourse(result.getSourceCourse());
        existing.setTargetCourse(result.getTargetCourse());
        existing.setOverlapPercentage(result.getOverlapPercentage());
        existing.setIsEligibleForTransfer(result.getIsEligibleForTransfer());
        existing.setNotes(result.getNotes());
        return resultRepo.save(existing);
    }
}
