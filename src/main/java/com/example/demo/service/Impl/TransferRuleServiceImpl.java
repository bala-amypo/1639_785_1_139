package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.TransferRule;
import com.example.demo.entity.University;
import com.example.demo.repository.TransferRuleRepository;
import com.example.demo.repository.UniversityRepository;
import com.example.demo.service.TransferRuleService;

@Service
public class TransferRuleServiceImpl implements TransferRuleService {

    @Autowired
    TransferRuleRepository ruleRepository;

    @Autowired
    UniversityRepository universityRepository;

    @Override
    public TransferRule createRule(TransferRule rule) {
        return ruleRepository.save(rule);
    }

    @Override
    public TransferRule updateRule(Long id, TransferRule rule) {
        if (ruleRepository.existsById(id)) {
            rule.setId(id);
            return ruleRepository.save(rule);
        }
        throw new RuntimeException("not found");
    }

    @Override
    public TransferRule getRuleById(Long id) {
        return ruleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("not found"));
    }
    @Override
    public void deactivateRule(Long id) {
        TransferRule rule = ruleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("not found"));

        rule.setActive(false);
        ruleRepository.save(rule);
    }
}