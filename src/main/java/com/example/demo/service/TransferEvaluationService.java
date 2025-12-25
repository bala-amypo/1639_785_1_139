// package com.example.demo.service;

// import java.util.List;
// import com.example.demo.entity.TransferEvaluationResult;

// public interface TransferEvaluationService{
//     TransferEvaluationResult postData4(TransferEvaluationResult use);
//     List<TransferEvaluationResult>getAllData4();
//     String  DeleteData4(Long id);
//     TransferEvaluationResult getEvaluationById(Long id);         
//     TransferEvaluationResult updateData4(Long id,TransferEvaluationResult entity);                                                        
// }
package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.TransferEvaluationResult;

public interface TransferEvaluationService {

    TransferEvaluationResult postData4(TransferEvaluationResult result);

    List<TransferEvaluationResult> getAllData4();

    TransferEvaluationResult getEvaluationById(Long id);

    TransferEvaluationResult updateData4(Long id, TransferEvaluationResult result);

    String DeleteData4(Long id);
}
