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

import com.example.demo.entity.TransferEvaluationResult;
import java.util.List;

public interface TransferEvaluationService {

    TransferEvaluationResult evaluateTransfer(Long sourceCourseId, Long targetCourseId);

    TransferEvaluationResult getEvaluationById(Long id);

    java.util.List<TransferEvaluationResult> getEvaluationsForCourse(Long sourceCourseId);

    // used by TransferEvaluationResultController
    TransferEvaluationResult postData4(TransferEvaluationResult result);

    java.util.List<TransferEvaluationResult> getAllData4();

    void DeleteData4(Long id);

    TransferEvaluationResult updateData4(Long id, TransferEvaluationResult result);
}
