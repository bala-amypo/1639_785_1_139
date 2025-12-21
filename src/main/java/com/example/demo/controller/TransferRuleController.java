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
//     @GetMapping("/find/{id}")
//     public TransferRule find(@PathVariable Long id){
//         return ser.getRuleById(id);
//     }

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
@RequestMapping("/transfer-rule")
public class TransferRuleController {

    @Autowired
    private TransferRuleService service;

    @PostMapping("/create")
    public ResponseEntity<TransferRule> createRule(@RequestBody TransferRule rule) {
        TransferRule created = service.createRule(rule);
        return ResponseEntity.ok(created); // 200 OK
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<TransferRule> getRuleById(@PathVariable Long id) {
        TransferRule rule = service.getRuleById(id);
        return ResponseEntity.ok(rule); // 200 OK
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<TransferRule>> getAllRules() {
        List<TransferRule> rules = service.getAllData5();
        return ResponseEntity.ok(rules); // 200 OK
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<TransferRule> updateRule(@PathVariable Long id, @RequestBody TransferRule rule) {
        TransferRule updated = service.updateRule(id, rule);
        return ResponseEntity.ok(updated); // 200 OK
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteRule(@PathVariable Long id) {
        String msg = service.DeleteData5(id);
        return ResponseEntity.ok(msg); // 200 OK
    }
}
