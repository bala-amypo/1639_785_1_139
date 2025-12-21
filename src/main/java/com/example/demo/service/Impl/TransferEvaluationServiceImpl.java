package com.example.demo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;   
import com.example.demo.entity.TransferEvaluationResult;
import com.example.demo.repository.TransferEvaluationResultRepository;
// import org.springframework.web.bind.annotation.PathVariable;
import com.example.demo.service.TransferEvaluationService;                

@Service
public class TransferEvaluationServiceImpl implements TransferEvaluationService{

    @Autowired TransferEvaluationRepository used;
    @Override
    public TransferEvaluation postData4(TransferEvaluation use){
        return used.save(use);  
    }
    @Override
    public List<TransferEvaluation>getAllData4(){
        return used.findAll();
    }
    @Override
    public String DeleteData4(Long id){
        used.deleteById(id);
        return "Deleted successfully";
    }
    @Override
    public TransferEvaluation getEvaluationById(Long id){
    return used.findById(id).orElse(null);
    }
    @Override
    public TransferEvaluation updateData4(Long id,TransferEvaluationResult entity){
        if(used.existsById(id)){
            entity.setId(id);
            return used.save(entity);
        } 
        return null;
    }
}