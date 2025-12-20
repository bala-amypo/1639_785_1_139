package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Course;
import com.example.demo.entity.CourseContentTopic;
import com.example.demo.entity.TransferEvaluationResult;
import com.example.demo.entity.TransferRule;
import com.example.demo.repository.CourseContentTopicRepository;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.TransferEvaluationResultRepository;
import com.example.demo.repository.TransferRuleRepository;
import com.example.demo.service.TransferEvaluationResultService;

@Service
public class TransferEvaluationResultServiceImpl implements TransferEvaluationResultService {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CourseContentTopicRepository topicRepository;

    @Autowired
    TransferRuleRepository ruleRepository;

    @Autowired
    TransferEvaluationResultRepository resultRepository;

    @Override
    public TransferEvaluationResult evaluateTransfer(Long sourceCourseId, Long targetCourseId) {

        Course sourceCourse = courseRepository.findById(sourceCourseId)
                .orElseThrow(() -> new RuntimeException("not found"));

        Course targetCourse = courseRepository.findById(targetCourseId)
                .orElseThrow(() -> new RuntimeException("not found"));

        if (!sourceCourse.getActive() || !targetCourse.getActive()) {
            throw new RuntimeException("Course inactive");
        }

        List<CourseContentTopic> sourceTopics = topicRepository.findByCourse(sourceCourse);
        List<CourseContentTopic> targetTopics = topicRepository.findByCourse(targetCourse);

        TransferRule rule = ruleRepository
                .findActiveRule(sourceCourse.getUniversity(), targetCourse.getUniversity());

        TransferEvaluationResult result = new TransferEvaluationResult();
        result.setSourceCourse(sourceCourse);
        result.setTargetCourse(targetCourse);

        if (rule == null) {
            result.setIsEligibleForTransfer(false);
            result.setNotes("No active transfer rule");
            return resultRepository.save(result);
        }

        double overlap = Math.min(sourceTopics.size(), targetTopics.size()) * 10;
        int creditDiff = Math.abs(sourceCourse.getCredits() - targetCourse.getCredits());

        result.setOverlapPercentage(overlap);
        result.setCreditHourDifference(creditDiff);

        if (overlap >= rule.getMinimumOverlapPercentage()
                && creditDiff <= rule.getCreditHourTolerance()) {
            result.setIsEligibleForTransfer(true);
            result.setNotes("Transfer eligible");
        } else {
            result.setIsEligibleForTransfer(false);
            result.setNotes("Criteria not met");
        }

        return resultRepository.save(result);
    }

    @Override
    public TransferEvaluationResult getEvaluationById(Long id) {
        return resultRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("not found"));
    }

    @Override
    public List<TransferEvaluationResult> getEvaluationsForCourse(Long courseId) {
        return resultRepository.findBySourceCourseIdOrTargetCourseId(courseId, courseId);
    }
}