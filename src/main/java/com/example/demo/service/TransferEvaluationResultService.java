package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.TransferEvaluationResult;

public interface TransferEvaluationResultService{
    TransferEvaluationResult postData4(TransferEvaluation use);
    List<TransferEvaluationResult>getAllData4();
    String  DeleteData4(Long id);
    TransferEvaluationResult getData4(Long id);         
    TransferEvaluationResult updateData4(Long id,TransferEvaluationResult entity);                                                        
}