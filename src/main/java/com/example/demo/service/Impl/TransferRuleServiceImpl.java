// package com.example.demo.service.impl;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.example.demo.entity.TransferRule;
// import com.example.demo.entity.University;
// import com.example.demo.repository.TransferRuleRepository;
// import com.example.demo.repository.UniversityRepository;
// import com.example.demo.service.TransferRuleService;

// @Service
// public class TransferRuleServiceImpl implements TransferRuleService {

//     @Autowired
//     TransferRuleRepository ruleRepository;

//     @Override
//     public TransferRule createRule(TransferRule rule) {
//         return ruleRepository.save(rule);
//     }

//     @Override
//     public TransferRule updateRule(Long id, TransferRule rule) {
//         if (ruleRepository.existsById(id)) {
//             rule.setId(id);
//             return ruleRepository.save(rule);
//         }
//         throw new RuntimeException("not found");
//     }

//     @Override
//     public TransferRule getRuleById(Long id) {
//         return ruleRepository.findById(id)
//                 .orElseThrow(() -> new RuntimeException("not found"));
//     }
//     @Override
//     public String DeleteData5(Long id){
//         ruleRepository.deleteById(id);
//         return "Deleted successfully";
//     }
//     @Override
//     public List<TransferRule>getAllData5(){
//         return ruleRepository.findAll();
//     }
// }
package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.TransferRule;
import com.example.demo.repository.TransferRuleRepository;
import com.example.demo.service.TransferRuleService;

@Service
public class TransferRuleServiceImpl implements TransferRuleService {

    @Autowired
    private TransferRuleRepository ruleRepository;

    @Override
    public TransferRule createRule(TransferRule rule) {
        return ruleRepository.save(rule);
    }

    @Override
    public TransferRule updateRule(Long id, TransferRule rule) {
        TransferRule existingRule = ruleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TransferRule not found with id: " + id));

        // update fields
        existingRule.setSourceUniversity(rule.getSourceUniversity());
        existingRule.setTargetUniversity(rule.getTargetUniversity());
        existingRule.setMinimumOverlapPercentage(rule.getMinimumOverlapPercentage());
        existingRule.setCreditHourTolerance(rule.getCreditHourTolerance());
        existingRule.setActive(rule.getActive());

        return ruleRepository.save(existingRule);
    }

    @Override
    public TransferRule getRuleById(Long id) {
        return ruleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TransferRule not found with id: " + id));
    }

    @Override
    public String DeleteData5(Long id) {
        if (!ruleRepository.existsById(id)) {
            throw new RuntimeException("TransferRule not found with id: " + id);
        }
        ruleRepository.deleteById(id);
        return "Deleted successfully";
    }

    @Override
    public List<TransferRule> getAllData5() {
        return ruleRepository.findAll();
    }
}
