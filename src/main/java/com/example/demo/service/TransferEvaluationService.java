package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.TransferEvaluation;

public interface TransferEvaluationService{
    TransferEvaluation postData4(TransferEvaluation use);
    List<TransferEvaluation>getAllData4();
    String  DeleteData4(Long id);
    TransferEvaluation getEvaluationById(Long id);         
    TransferEvaluation updateData4(Long id,TransferEvaluation entity);                                                        
}