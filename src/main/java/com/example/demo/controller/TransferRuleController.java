package com.example.demo.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.demo.entity.TransferRule;
import com.example.demo.service.TransferRuleService;
import jakarta.validation.Valid;

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
@RestController
@RequestMapping("/transfer-rule")
public class TransferRuleController {

    @Autowired
    private TransferRuleService ser;

    @PostMapping("/post")
    public TransferRule sendData(@RequestBody TransferRule rule) {
        return ser.createRule(rule);
    }

    @GetMapping("/get")
    public List<TransferRule> getval() {
        return ser.getAllData5();
    }

    @GetMapping("/find/{id}")
    public TransferRule find(@PathVariable Long id) {
        return ser.getRuleById(id);
    }

    @PutMapping("/put/{id}")
    public TransferRule putval(@PathVariable Long id,
                               @RequestBody TransferRule rule) {
        return ser.updateRule(id, rule);
    }

    @DeleteMapping("/delete/{id}")
    public String del(@PathVariable Long id) {
        return ser.DeleteData5(id);
    }
}
