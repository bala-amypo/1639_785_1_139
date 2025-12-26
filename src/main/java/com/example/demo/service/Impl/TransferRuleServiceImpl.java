









// package com.example.demo.service.impl;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.example.demo.entity.TransferRule;
// import com.example.demo.exception.ResourceNotFoundException;
// import com.example.demo.repository.TransferRuleRepository;
// import com.example.demo.service.TransferRuleService;

// @Service
// public class TransferRuleServiceImpl implements TransferRuleService {

//     @Autowired
//     private TransferRuleRepository repo;

//     @Override
//     public TransferRule createRule(TransferRule rule){
//         return repo.save(rule);
//     }
    
//     @Override
//     public TransferRule updateRule(Long id, TransferRule rule) {
//         TransferRule existingRule = repo.findById(id)
//                 .orElseThrow(() -> 
//                     new ResourceNotFoundException("TransferRule not found with id " + id)
//                 );

//         rule.setId(existingRule.getId());
//         return repo.save(rule);
//     }

//     @Override
//     public TransferRule getRuleById(Long id) {
//         return repo.findById(id)
//                 .orElseThrow(() -> 
//                     new ResourceNotFoundException("TransferRule not found with id " + id)
//                 );
//     }

//     @Override
//     public String DeleteData5(Long id) {
//         if (!repo.existsById(id)) {
//             throw new ResourceNotFoundException(
//                     "TransferRule not found with id " + id);
//         }
//         repo.deleteById(id);
//         return "Deleted successfully";
//     }

//     @Override
//     public List<TransferRule> getAllData5() {
//         return repo.findAll();
//     }
// }














// package com.example.demo.service.impl;

// import java.util.*;
// import com.example.demo.entity.*;
// import com.example.demo.repository.*;

// public class TransferRuleServiceImpl {

//     private TransferRuleRepository repo;
//     private UniversityRepository univRepo;

//     public TransferRule createRule(TransferRule r) {
//         if (r.getMinimumOverlapPercentage() < 0 || r.getMinimumOverlapPercentage() > 100)
//             throw new IllegalArgumentException("Overlap must be 0-100");

//         if (r.getCreditHourTolerance() != null && r.getCreditHourTolerance() < 0)
//             throw new IllegalArgumentException("Tolerance >= 0");

//         univRepo.findById(r.getSourceUniversity().getId()).orElseThrow();
//         univRepo.findById(r.getTargetUniversity().getId()).orElseThrow();

//         return repo.save(r);
//     }

//     public void deactivateRule(Long id) {
//         TransferRule r = repo.findById(id)
//                 .orElseThrow(() -> new RuntimeException("Rule not found"));
//         r.setActive(false);
//         repo.save(r);
//     }

//     public List<TransferRule> getRulesForUniversities(Long s, Long t) {
//         return repo.findBySourceUniversityIdAndTargetUniversityIdAndActiveTrue(s, t);
//     }

//     public TransferRule getRuleById(Long id) {
//         return repo.findById(id)
//                 .orElseThrow(() -> new RuntimeException("Rule not found"));
//     }

//     public TransferRule updateRule(Long id, TransferRule r) {
//         repo.findById(id).orElseThrow(() -> new RuntimeException("Rule not found"));
//         return repo.save(r);
//     }
// }

package com.example.demo.service.impl;

import com.example.demo.entity.TransferRule;
import com.example.demo.repository.TransferRuleRepository;
import com.example.demo.repository.UniversityRepository;
import com.example.demo.service.TransferRuleService;
import org.springframework.stereotype.Service;

@Service
public class TransferRuleServiceImpl implements TransferRuleService {

    private TransferRuleRepository repo;
    private UniversityRepository univRepo;

    @Override
    public TransferRule createRule(TransferRule rule) {
        if (rule.getMinimumOverlapPercentage() == null ||
            rule.getMinimumOverlapPercentage() < 0 ||
            rule.getMinimumOverlapPercentage() > 100) {
            throw new IllegalArgumentException("0-100");
        }
        if (rule.getCreditHourTolerance() != null &&
            rule.getCreditHourTolerance() < 0) {
            throw new IllegalArgumentException(">= 0");
        }
        if (rule.getSourceUniversity() == null || rule.getTargetUniversity() == null ||
            rule.getSourceUniversity().getId() == null ||
            rule.getTargetUniversity().getId() == null) {
            throw new IllegalArgumentException("Universities required");
        }
        univRepo.findById(rule.getSourceUniversity().getId())
                .orElseThrow(() -> new RuntimeException("not found"));
        univRepo.findById(rule.getTargetUniversity().getId())
                .orElseThrow(() -> new RuntimeException("not found"));
        return repo.save(rule);
    }

    @Override
    public TransferRule getRuleById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("not found"));
    }

    @Override
    public TransferRule updateRule(Long id, TransferRule rule) {
        TransferRule existing = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("not found"));
        existing.setMinimumOverlapPercentage(rule.getMinimumOverlapPercentage());
        existing.setCreditHourTolerance(rule.getCreditHourTolerance());
        return repo.save(existing);
    }

    @Override
    public void deactivateRule(Long id) {
        TransferRule r = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("not found"));
        r.setActive(false);
        repo.save(r);
    }

    @Override
    public java.util.List<TransferRule> getRulesForUniversities(Long sourceUniversityId,
                                                                Long targetUniversityId) {
        return repo.findBySourceUniversityIdAndTargetUniversityIdAndActiveTrue(
                sourceUniversityId, targetUniversityId);
    }
}
