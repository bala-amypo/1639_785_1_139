package com.example.demo.service;

import com.example.demo.entity.TransferRule;
import java.util.List;

public interface TransferRuleService{
    TransferRule createRule(TransferRule rule);
    TransferRule updateRule(Long id,TransferRule rule);
    TransferRule getRuleById(Long id);
    List<TransferRule>getAllData5();
    TransferRule deleteRule5(Long id);
}
public interface UniversityService{
    University createUniversity(University univ);
    University updateUniversity(Long id,University univ);
    University getUniversityById(Long id);
    List<University>getAllData1();
    void deactiveUniversity(Long id); 
}