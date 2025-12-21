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
import com.example.demo.entity.Course;
import com.example.demo.service.CourseService;
import jakarta.validation.Valid;

@RequestMapping("/Course")
@RestController
public class CourseController{
    @Autowired  CourseService ser;
    @PostMapping("/post")
    public Course sendData(@RequestBody Course stu){
        return ser.postData3(stu);
    }
    @GetMapping("/get")
    public List<Course> getval(){
        return ser.getAllData3();
    }
    @DeleteMapping("/delete/{id}")
    public String del(@PathVariable Long id){
        return ser.DeleteData3(id);
    }
    @GetMapping("/find/{id}")
    public Course find(@PathVariable Long id){
        return ser.getData3(id);
    }
    @PutMapping("/put/{id}")
    public Course putval(@PathVariable Long id,@RequestBody Course entity){
        return ser.updateData3(id,entity);
    }
}