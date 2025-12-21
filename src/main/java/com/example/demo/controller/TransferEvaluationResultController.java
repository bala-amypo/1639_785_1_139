// package com.example.demo.controller;

// import java.util.*;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import com.example.demo.entity.TransferEvaluationResult;
// import com.example.demo.service.TransferEvaluationService;
// import jakarta.validation.Valid;

// @RequestMapping("/TransferEvaluationResult")
// @RestController
// public class TransferEvaluationResultController{
//     @Autowired  TransferEvaluationService ser;
//     @PostMapping("/post")
//     public TransferEvaluationResult sendData(@RequestBody TransferEvaluationResult stu){
//         return ser.postData4(stu);
//     }
//     @GetMapping("/get")
//     public List<TransferEvaluationResult> getval(){
//         return ser.getAllData4();
//     }
//     @DeleteMapping("/delete/{id}")
//     public String del(@PathVariable Long id){
//         return ser.DeleteData4(id);
//     }
//     @GetMapping("/find/{id}")
//     public TransferEvaluationResult find(@PathVariable Long id){
//         return ser.getEvaluationById(id);
//     }
//     @PutMapping("/put/{id}")
//     public TransferEvaluationResult putval(@PathVariable Long id,@RequestBody TransferEvaluationResult entity){
//         return ser.updateData4(id,entity);
//     }
// }
package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.TransferEvaluationResult;
import com.example.demo.service.TransferEvaluationService;

@RestController
@RequestMapping("/transfer-evaluation")
public class TransferEvaluationResultController {

    @Autowired
    private TransferEvaluationService service;

    @PostMapping("/create")
    public ResponseEntity<TransferEvaluationResult> createResult(@RequestBody TransferEvaluationResult result) {
        TransferEvaluationResult created = service.postData4(result);
        return ResponseEntity.ok(created); // 200 OK
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<TransferEvaluationResult> getResultById(@PathVariable Long id) {
        TransferEvaluationResult result = service.getEvaluationById(id);
        return ResponseEntity.ok(result); // 200 OK
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<TransferEvaluationResult>> getAllResults() {
        List<TransferEvaluationResult> results = service.getAllData4();
        return ResponseEntity.ok(results); // 200 OK
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<TransferEvaluationResult> updateResult(@PathVariable Long id,
                                                                 @RequestBody TransferEvaluationResult entity) {
        TransferEvaluationResult updated = service.updateData4(id, entity);
        return ResponseEntity.ok(updated); // 200 OK
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteResult(@PathVariable Long id) {
        String msg = service.DeleteData4(id);
        return ResponseEntity.ok(msg); // 200 OK
    }
}
