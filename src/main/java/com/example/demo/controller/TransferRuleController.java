
// package com.example.demo.controller;

// import com.example.demo.entity.TransferRule;
// import com.example.demo.service.TransferRuleService;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/api/transfer-rules")
// public class TransferRuleController {

//     private final TransferRuleService ser;

//     public TransferRuleController(TransferRuleService ser) {
//         this.ser = ser;
//     }

//     @PostMapping
//     public TransferRule create(@RequestBody TransferRule rule) {
//         return ser.createRule(rule);
//     }

//     @GetMapping
//     public List<TransferRule> getAll() {
//         // matches getAllData5()
//         return ser.getAllData5();
//     }

//     @GetMapping("/{id}")
//     public TransferRule getById(@PathVariable Long id) {
//         return ser.getRuleById(id);
//     }

//     @PutMapping("/{id}")
//     public TransferRule update(@PathVariable Long id, @RequestBody TransferRule rule) {
//         return ser.updateRule(id, rule);
//     }

//     @DeleteMapping("/{id}")
//     public void delete(@PathVariable Long id) {
//         // matches DeleteData5(Long)
//         ser.DeleteData5(id);
//     }
// }





package com.example.demo.controller;

import com.example.demo.entity.TransferRule;
import com.example.demo.service.TransferRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transfer-rules")
public class TransferRuleController {

    @Autowired
    private TransferRuleService service;

    @PostMapping
    public TransferRule createRule(@RequestBody TransferRule rule) {
        return service.createRule(rule);
    }

    @PutMapping("/{id}")
    public TransferRule updateRule(@PathVariable Long id,
                                   @RequestBody TransferRule rule) {
        return service.updateRule(id, rule);
    }

    @GetMapping("/{id}")
    public TransferRule getRuleById(@PathVariable Long id) {
        return service.getRuleById(id);
    }

    @GetMapping("/pair/{sourceId}/{targetId}")
    public List<TransferRule> getRulesForUniversities(@PathVariable Long sourceId,
                                                      @PathVariable Long targetId) {
        return service.getRulesForUniversities(sourceId, targetId);
    }

    @PutMapping("/{id}/deactivate")
    public void deactivateRule(@PathVariable Long id) {
        service.deactivateRule(id);
    }
}