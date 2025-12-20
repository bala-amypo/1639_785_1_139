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
    public TransferEvaluationResult getEvaluationById(Long id) {
        return resultRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("not found"));
    }
}