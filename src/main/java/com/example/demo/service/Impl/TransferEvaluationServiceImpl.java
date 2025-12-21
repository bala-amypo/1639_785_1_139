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

import com.example.demo.entity.TransferEvaluationResult;
import com.example.demo.repository.TransferEvaluationResultRepository;
import com.example.demo.service.TransferEvaluationService;

@Service
public class TransferEvaluationServiceImpl implements TransferEvaluationService {

    @Autowired
    private TransferEvaluationResultRepository repo;

    @Override
    public TransferEvaluationResult postData4(TransferEvaluationResult use) {
        return repo.save(use);
    }

    @Override
    public List<TransferEvaluationResult> getAllData4() {
        return repo.findAll();
    }

    @Override
    public TransferEvaluationResult getEvaluationById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("TransferEvaluationResult not found with id: " + id));
    }

    @Override
    public TransferEvaluationResult updateData4(Long id, TransferEvaluationResult entity) {
        TransferEvaluationResult existing = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("TransferEvaluationResult not found with id: " + id));

        existing.setSourceCourse(entity.getSourceCourse());
        existing.setTargetCourse(entity.getTargetCourse());
        existing.setOverlapPercentage(entity.getOverlapPercentage());
        existing.setCreditHourDifference(entity.getCreditHourDifference());
        existing.setIsEligibleForTransfer(entity.getIsEligibleForTransfer());
        existing.setNotes(entity.getNotes());

        return repo.save(existing);
    }

    @Override
    public String DeleteData4(Long id) {
        TransferEvaluationResult existing = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("TransferEvaluationResult not found with id: " + id));
        repo.deleteById(id);
        return "Deleted Successfully!";
    }
}
