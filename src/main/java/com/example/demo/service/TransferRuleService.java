package com.example.demo.service;

import com.example.demo.TransferRule;
import java.util.List;

public interface TransferRuleService{
    TransferRule createRule(TransferRule rule);
    TransferRule updateRule(Long id,TransferRule rule);
    TransferRule getRuleById(Long id);
    void deactivateRule(Long id);
}