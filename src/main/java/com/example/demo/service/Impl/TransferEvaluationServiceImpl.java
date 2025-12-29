




// package com.example.demo.service.impl;

// import com.example.demo.entity.Course;
// import com.example.demo.entity.CourseContentTopic;
// import com.example.demo.entity.TransferEvaluationResult;
// import com.example.demo.entity.TransferRule;
// import com.example.demo.repository.CourseContentTopicRepository;
// import com.example.demo.repository.CourseRepository;
// import com.example.demo.repository.TransferEvaluationResultRepository;
// import com.example.demo.repository.TransferRuleRepository;
// import com.example.demo.service.TransferEvaluationService;
// import org.springframework.stereotype.Service;

// import java.util.List;

// @Service
// public class TransferEvaluationServiceImpl implements TransferEvaluationService {

//     // field names used by tests via reflection
//     private CourseRepository courseRepo;
//     private CourseContentTopicRepository topicRepo;
//     private TransferRuleRepository ruleRepo;
//     private TransferEvaluationResultRepository resultRepo;

//     @Override
//     public TransferEvaluationResult evaluateTransfer(Long sourceCourseId, Long targetCourseId) {
//         Course src = courseRepo.findById(sourceCourseId)
//                 .orElseThrow(() -> new RuntimeException("not found"));
//         Course tgt = courseRepo.findById(targetCourseId)
//                 .orElseThrow(() -> new RuntimeException("not found"));

//         if (!src.isActive() || !tgt.isActive()) {
//             throw new IllegalArgumentException("active");
//         }

//         List<CourseContentTopic> srcTopics = topicRepo.findByCourseId(sourceCourseId);
//         List<CourseContentTopic> tgtTopics = topicRepo.findByCourseId(targetCourseId);

//         double totalSource = srcTopics.stream()
//                 .mapToDouble(t -> t.getWeightPercentage() == null ? 0.0 : t.getWeightPercentage())
//                 .sum();
//         if (totalSource == 0) {
//             // for tests expecting non-null overlap even when no topics
//             totalSource = 100.0;
//         }

//         double matched = 0.0;
//         for (CourseContentTopic s : srcTopics) {
//             for (CourseContentTopic t : tgtTopics) {
//                 if (s.getTopicName() != null &&
//                         s.getTopicName().equalsIgnoreCase(t.getTopicName())) {
//                     matched += Math.min(
//                             s.getWeightPercentage() == null ? 0.0 : s.getWeightPercentage(),
//                             t.getWeightPercentage() == null ? 0.0 : t.getWeightPercentage());
//                 }
//             }
//         }
//         double overlap = totalSource == 0 ? 0.0 : (matched / totalSource) * 100.0;

//         List<TransferRule> rules =
//                 ruleRepo.findBySourceUniversityIdAndTargetUniversityIdAndActiveTrue(
//                         src.getUniversity().getId(), tgt.getUniversity().getId());

//         boolean eligible;
//         String notes;

//         if (rules.isEmpty()) {
//             eligible = false;
//             notes = "No active transfer rule";
//         } else {
//             eligible = false;
//             notes = "No active rule satisfied";
//             for (TransferRule r : rules) {
//                 int tol = r.getCreditHourTolerance() == null ? 0 : r.getCreditHourTolerance();
//                 boolean creditOk =
//                         Math.abs(src.getCreditHours() - tgt.getCreditHours()) <= tol;
//                 if (creditOk && overlap >= r.getMinimumOverlapPercentage()) {
//                     eligible = true;
//                     notes = "Eligible";
//                     break;
//                 }
//             }
//         }

//         TransferEvaluationResult result = new TransferEvaluationResult();
//         result.setSourceCourse(src);
//         result.setTargetCourse(tgt);
//         result.setOverlapPercentage(overlap);
//         result.setIsEligibleForTransfer(eligible);
//         result.setNotes(notes);

//         return resultRepo.save(result);
//     }

//     @Override
//     public TransferEvaluationResult getEvaluationById(Long id) {
//         return resultRepo.findById(id)
//                 .orElseThrow(() -> new RuntimeException("not found"));
//     }

//     @Override
//     public List<TransferEvaluationResult> getEvaluationsForCourse(Long sourceCourseId) {
//         // used by test41ListEvaluationsForCourse
//         return resultRepo.findBySourceCourseId(sourceCourseId);
//     }

//     // controller helpers - simple CRUD via repository

//     @Override
//     public TransferEvaluationResult postData4(TransferEvaluationResult result) {
//         return resultRepo.save(result);
//     }

//     @Override
//     public List<TransferEvaluationResult> getAllData4() {
//         return resultRepo.findAll();
//     }

//     @Override
//     public void DeleteData4(Long id) {
//         resultRepo.deleteById(id);
//     }

//     @Override
//     public TransferEvaluationResult updateData4(Long id, TransferEvaluationResult result) {
//         TransferEvaluationResult existing = resultRepo.findById(id)
//                 .orElseThrow(() -> new RuntimeException("not found"));
//         existing.setSourceCourse(result.getSourceCourse());
//         existing.setTargetCourse(result.getTargetCourse());
//         existing.setOverlapPercentage(result.getOverlapPercentage());
//         existing.setIsEligibleForTransfer(result.getIsEligibleForTransfer());
//         existing.setNotes(result.getNotes());
//         return resultRepo.save(existing);
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
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class TransferEvaluationServiceImpl implements TransferEvaluationService {

    @Autowired
    CourseRepository courseRepo;

    @Autowired
    CourseContentTopicRepository topicRepo;

    @Autowired
    TransferRuleRepository ruleRepo;

    @Autowired
    TransferEvaluationResultRepository resultRepo;

    public TransferEvaluationServiceImpl() {
    }

    @Override
    public TransferEvaluationResult evaluateTransfer(Long sourceCourseId, Long targetCourseId) {

        Course src = courseRepo.findById(sourceCourseId)
                .orElseThrow(() -> new RuntimeException("Source course not found"));

        Course tgt = courseRepo.findById(targetCourseId)
                .orElseThrow(() -> new RuntimeException("Target course not found"));

        if (!Boolean.TRUE.equals(src.getActive()) || !Boolean.TRUE.equals(tgt.getActive())) {
            throw new IllegalArgumentException("Course must be active");
        }

        List<CourseContentTopic> srcTopics = topicRepo.findByCourseId(sourceCourseId);
        List<CourseContentTopic> tgtTopics = topicRepo.findByCourseId(targetCourseId);

        double matched = 0;
        double total = srcTopics.stream()
                .mapToDouble(t -> t.getWeightPercentage() == null ? 0 : t.getWeightPercentage())
                .sum();

        if (total == 0) {
            total = 100;
        }

        for (CourseContentTopic s : srcTopics) {
            for (CourseContentTopic t : tgtTopics) {
                if (s.getTopicName().equalsIgnoreCase(t.getTopicName())) {
                    matched += Math.min(
                            s.getWeightPercentage() == null ? 0 : s.getWeightPercentage(),
                            t.getWeightPercentage() == null ? 0 : t.getWeightPercentage()
                    );
                }
            }
        }

        double overlap = (matched / total) * 100;
        int creditDiff = Math.abs(src.getCreditHours() - tgt.getCreditHours());

        List<TransferRule> rules =
                ruleRepo.findBySourceUniversityIdAndTargetUniversityIdAndActiveTrue(
                        src.getUniversity().getId(),
                        tgt.getUniversity().getId()
                );

        boolean eligible = false;
        for (TransferRule r : rules) {
            if (overlap >= r.getMinimumOverlapPercentage()
                    && creditDiff <= (r.getCreditHourTolerance() == null ? 0 : r.getCreditHourTolerance())) {
                eligible = true;
                break;
            }
        }

        TransferEvaluationResult res = new TransferEvaluationResult();
        res.setOverlapPercentage(overlap);
        res.setCreditHourDifference(creditDiff);
        res.setIsEligibleForTransfer(eligible);
        res.setNotes(
                eligible ? "Eligible"
                        : rules.isEmpty() ? "No active transfer rule" : "No active rule satisfied"
        );

        return resultRepo.save(res);
    }

    @Override
    public TransferEvaluationResult getEvaluationById(Long id) {
        return resultRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Evaluation not found"));
    }

    @Override
    public List<TransferEvaluationResult> getEvaluationsForCourse(Long sourceCourseId) {
        return resultRepo.findBySourceCourseId(sourceCourseId);
    }
}