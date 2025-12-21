// package com.example.demo.service.impl;

// import java.util.List;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;   
// import com.example.demo.entity.TransferEvaluationResult;
// import com.example.demo.repository.TransferEvaluationResultRepository;
// // import org.springframework.web.bind.annotation.PathVariable;
// import com.example.demo.service.TransferEvaluationService;                

// @Service
// public class TransferEvaluationServiceImpl implements TransferEvaluationService{

//     @Autowired TransferEvaluationResultRepository used;
//     @Override
//     public TransferEvaluationResult postData4(TransferEvaluationResult use){
//         return used.save(use);  
//     }
//     @Override
//     public List<TransferEvaluationResult>getAllData4(){
//         return used.findAll();
//     }
//     @Override
//     public String DeleteData4(Long id){
//         used.deleteById(id);
//         return "Deleted successfully";
//     }
//     @Override
//     public TransferEvaluationResult getEvaluationById(Long id){
//     return used.findById(id).orElse(null);
//     }
//     @Override
//     public TransferEvaluationResult updateData4(Long id,TransferEvaluationResult entity){
//         if(used.existsById(id)){
//             entity.setId(id);
//             return used.save(entity);
//         } 
//         return null;
//     }
// }
package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.TransferEvaluationResult;
import com.example.demo.repository.TransferEvaluationResultRepository;
import com.example.demo.service.TransferEvaluationService;

@Service
public class TransferEvaluationServiceImpl implements TransferEvaluationService {

    @Autowired
    private TransferEvaluationResultRepository used;

    @Override
    public TransferEvaluationResult postData4(TransferEvaluationResult use) {
        return used.save(use);
    }

    @Override
    public List<TransferEvaluationResult> getAllData4() {
        return used.findAll();
    }

    @Override
    public String DeleteData4(Long id) {
        if (!used.existsById(id)) {
            throw new RuntimeException("Evaluation not found with id: " + id);
        }
        used.deleteById(id);
        return "Deleted successfully";
    }

    @Override
    public TransferEvaluationResult getEvaluationById(Long id) {
        return used.findById(id)
                .orElseThrow(() -> new RuntimeException("Evaluation not found with id: " + id));
    }

    // ✅ UPDATE USING @Transactional (NO save())
    @Override
    @Transactional
    public TransferEvaluationResult updateData4(Long id, TransferEvaluationResult entity) {

        TransferEvaluationResult existing = used.findById(id)
                .orElseThrow(() -> new RuntimeException("Evaluation not found with id: " + id));

        existing.setSourceCourse(entity.getSourceCourse());
        existing.setTargetCourse(entity.getTargetCourse());
        existing.setOverlapPercentage(entity.getOverlapPercentage());
        existing.setCreditHourDifference(entity.getCreditHourDifference());
        existing.setIsEligibleForTransfer(entity.getIsEligibleForTransfer());
        existing.setEvaluatedAt(entity.getEvaluatedAt());
        existing.setNotes(entity.getNotes());

        // NO save() needed
        return existing;
    }
}
