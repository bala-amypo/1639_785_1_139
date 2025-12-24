package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import com.example.demo.entity.TransferRule;
import com.example.demo.entity.University;
import com.example.demo.repository.TransferRuleRepository;
import com.example.demo.repository.UniversityRepository;
import com.example.demo.service.TransferRuleService;

@Service
public class TransferRuleServiceImpl implements TransferRuleService {

    @Autowired
    TransferRuleRepository repo;

    @Override
    public TransferRule createRule(TransferRule rule) {
        if(repo.save(rule)){
            
        }
    }
    @Override
    public TransferRule updateRule(Long id, TransferRule rule) {
        if (repo.existsById(id)) {
            rule.setId(id);
            return repo.save(rule);
        }
        throw new RuntimeException("not found");
    }

   
    @Override
    public TransferRule getRuleById(Long id) {
    return repo.findById(id)
            .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "TransferRule not found with id " + id)
            );
}
    @Override
    public String DeleteData5(Long id){
        repo.deleteById(id);
        return "Deleted successfully";
    }
    @Override
    public List<TransferRule>getAllData5(){
        return repo.findAll();
    }
}
