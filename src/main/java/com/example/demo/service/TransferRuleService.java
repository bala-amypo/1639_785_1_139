package com.example.demo.service;

import com.example.demo.TransferRule;
import java.util.List;

public interface TransferRuleService{
    University createRule(University univ);
    University updateRule(Long id,University univ);
    University getRuleById(Long id);
    void deactivateRule(Long id);
}