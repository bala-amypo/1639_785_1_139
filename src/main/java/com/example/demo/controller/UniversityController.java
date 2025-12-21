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
import com.example.demo.entity.University;
import com.example.demo.service.UniversityService;
import jakarta.validation.Valid;

@RequestMapping("/University")
@RestController
public class UniversityController{
    @Autowired  UniversityService ser;
    @PostMapping("/register")
    public University sendData(@RequestBody University univ){
        return ser.createUniversity(univ);
    }
    @GetMapping("/get")
    public List<University> getval(){
        return ser.getAllUniversities();
    }
    @GetMapping("/find/{id}")
    public University find(@PathVariable Long id){
        return ser.getUniversityById(id);
    }
    @PutMapping("/put/{id}")
    public University putval(@PathVariable Long id,@RequestBody University univ){
        return ser.updateUniversity(id,univ);
    }
    @PutMapping("/{id}/deactivate")
    public University deactivateUniversity(@PathVariable Long id) {
        ser.deactivateUniversity(id);
        return ser.getUniversityById(id);
    }
    @DeleteMapping("/delete/{id}")
    public String del(@PathVariable Long id){
        return ser.DeleteData1(id);
    }
}