








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










// package com.example.demo.controller;

// import org.springframework.web.bind.annotation.*;
// import java.util.List;
// import com.example.demo.entity.TransferRule;
// import com.example.demo.service.TransferRuleService;

// @RestController
// @RequestMapping("/transfer-rules")
// public class TransferRuleController {

//     private final TransferRuleService transferRuleService;

//     public TransferRuleController(TransferRuleService transferRuleService) {
//         this.transferRuleService = transferRuleService;
//     }

//     @PostMapping("/create")
//     public TransferRule create(@RequestBody TransferRule rule) {
//         return transferRuleService.createRule(rule);
//     }

//     @GetMapping("/{id}")
//     public TransferRule getById(@PathVariable Long id) {
//         return transferRuleService.getRuleById(id);
//     }

//     @GetMapping("/all")
//     public List<TransferRule> getAll() {
//         return transferRuleService.getAllRules();
//     }
// }
package com.example.demo.controller;

import com.example.demo.entity.TransferRule;
import com.example.demo.service.TransferRuleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transfer-rules")
public class TransferRuleController {

    private final TransferRuleService ser;

    public TransferRuleController(TransferRuleService ser) {
        this.ser = ser;
    }

    @PostMapping
    public TransferRule create(@RequestBody TransferRule rule) {
        return ser.createRule(rule);
    }

    @GetMapping
    public List<TransferRule> getAll() {
        // matches getAllData5()
        return ser.getAllData5();
    }

    @GetMapping("/{id}")
    public TransferRule getById(@PathVariable Long id) {
        return ser.getRuleById(id);
    }

    @PutMapping("/{id}")
    public TransferRule update(@PathVariable Long id, @RequestBody TransferRule rule) {
        return ser.updateRule(id, rule);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        // matches DeleteData5(Long)
        ser.DeleteData5(id);
    }
}
