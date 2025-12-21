package com.example.demo.service.impl;

import java.util.List;
import org.springframework.web.server.ResponseStatusException;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;   
import com.example.demo.entity.TransferEvaluationResult;
import com.example.demo.repository.TransferEvaluationResultRepository;
// import org.springframework.web.bind.annotation.PathVariable;
import com.example.demo.service.TransferEvaluationService;                

@Service
public class TransferEvaluationServiceImpl implements TransferEvaluationService{

    @Autowired TransferEvaluationResultRepository used;
    @Override
    public TransferEvaluationResult postData4(TransferEvaluationResult use){
        return used.save(use);  
    }
    @Override
    public List<TransferEvaluationResult>getAllData4(){
        return used.findAll();
    }
    @Override
    public String DeleteData4(Long id){
        used.deleteById(id);
        return "Deleted successfully";
    }
    @Override
    public TransferEvaluationResult getEvaluationById(Long id){
    return used.findById(id).orElse(null);
    }
    // @Override
    // public TransferEvaluationResult updateData4(Long id,TransferEvaluationResult entity){
    //     if(used.existsById(id)){
    //         entity.setId(id);
    //         return used.save(entity);
    //     } 
    //     return null;
    // }
@Override
public TransferRule getRuleById(Long id) {
    return transferRuleRepository.findById(id)
            .orElseThrow(() ->
                new ResponseStatusException(NOT_FOUND, "TransferRule not found with id " + id)
            );
}

}
