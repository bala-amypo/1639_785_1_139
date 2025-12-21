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
// import com.example.demo.entity.TransferRule;
// import com.example.demo.service.TransferRuleService;
// import jakarta.validation.Valid;

// @RequestMapping("/TransferRule")
// @RestController
// public class TransferRuleController{
//     @Autowired  TransferRuleService ser;
//     @PostMapping("/post")
//     public TransferRule sendData(@RequestBody TransferRule rule){
//         return ser.createRule(rule);
//     }
//     @GetMapping("/get")
//     public List<TransferRule> getval(){
//         return ser.getAllData5();
//     }
//     // @GetMapping("/find/{id}")
//     // public TransferRule find(@PathVariable Long id){
//     //     return ser.getRuleById(id);
//     // }
//     @GetMapping("/{id}")
//     public ResponseEntity<TransferRule> find(@PathVariable Long id) {
//     TransferRule rule = transferRuleService.getRuleById(id);
//     return ResponseEntity.ok(rule); 
// }

//     @PutMapping("/put/{id}")
//     public TransferRule putval(@PathVariable Long id,@RequestBody TransferRule rule){
//         return ser.updateRule(id,rule);
//     }
//     @DeleteMapping("/delete/{id}")
//     public String del(@PathVariable Long id){
//         return ser.DeleteData5(id);
//     }
// }
package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.TransferRule;
import com.example.demo.service.TransferRuleService;

@RestController
@RequestMapping("/TransferRule")
public class TransferRuleController {

    @Autowired
    private TransferRuleService transferRuleService;

    // CREATE
    @PostMapping("/post")
    public ResponseEntity<TransferRule> sendData(@RequestBody TransferRule rule) {
        TransferRule savedRule = transferRuleService.createRule(rule);
        return ResponseEntity.ok(savedRule); // 200 OK
    }

    // GET ALL
    @GetMapping("/get")
    public ResponseEntity<List<TransferRule>> getAll() {
        List<TransferRule> rules = transferRuleService.getAllData5();
        return ResponseEntity.ok(rules); // 200 OK
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<TransferRule> find(@PathVariable Long id) {
        TransferRule rule = transferRuleService.getRuleById(id);
        return ResponseEntity.ok(rule); // 200 OK even if rule is null
    }

    // UPDATE
    @PutMapping("/put/{id}")
    public ResponseEntity<TransferRule> update(@PathVariable Long id, @RequestBody TransferRule rule) {
        TransferRule updatedRule = transferRuleService.updateRule(id, rule);
        return ResponseEntity.ok(updatedRule); // 200 OK even if updatedRule is null
    }

    // DELETE
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        String msg = transferRuleService.DeleteData5(id);
        return ResponseEntity.ok(msg); // 200 OK
    }
}
