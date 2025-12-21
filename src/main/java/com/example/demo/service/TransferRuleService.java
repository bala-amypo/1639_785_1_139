package com.example.demo.service;

import com.example.demo.entity.TransferRule;
import java.util.List;

public interface TransferRuleService{
    TransferRule createRule(TransferRule rule);
    TransferRule updateRule(Long id,TransferRule rule);
    TransferRule getRuleById(Long id);
    List<TransferRule>getAllData5();
    String  DeleteData5(Long id);    
}