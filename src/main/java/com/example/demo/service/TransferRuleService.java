
// package com.example.demo.service;

// import com.example.demo.entity.TransferRule;
// import java.util.List;

// public interface TransferRuleService {

//     TransferRule createRule(TransferRule rule);

//     TransferRule getRuleById(Long id);

//     TransferRule updateRule(Long id, TransferRule rule);

//     void deactivateRule(Long id);

//     java.util.List<TransferRule> getRulesForUniversities(Long sourceUniversityId,
//                                                          Long targetUniversityId);

//     // used by TransferRuleController
//     java.util.List<TransferRule> getAllData5();

//     void DeleteData5(Long id);
// }




package com.example.demo.service;

import com.example.demo.entity.TransferRule;
import java.util.List;

public interface TransferRuleService {
    TransferRule createRule(TransferRule rule);
    TransferRule updateRule(Long id, TransferRule rule);
    TransferRule getRuleById(Long id);
    void deactivateRule(Long id);
    List<TransferRule> getRulesForUniversities(Long sourceUniversityId, Long targetUniversityId);
}
