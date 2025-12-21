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

@RequestMapping("/User")
@RestController
public class CourseController{
    @Autowired  CourseService ser;
    @PostMapping("/register")
    public CourseContentTopic sendData(@RequestBody CourseContentTopic stu){
        return ser.postData2(stu);
    }
    @PostMapping("/login")
    public CourseContentTopic senddata(@RequestBody CourseContentTopic log){
        return ser.postdata2(log);
    }
    @GetMapping("/get")
    public List<CourseContentTopic> getval(){
        return ser.getAllData2();
    }
    @DeleteMapping("/delete/{id}")
    public String del(@PathVariable Long id){
        return ser.DeleteData2(id);
    }
    @GetMapping("/find/{id}")
    public CourseContentTopic find(@PathVariable Long id){
        return ser.getData2(id);
    }
    @PutMapping("/put/{id}")
    public CourseContentTopic putval(@PathVariable Long id,@RequestBody CourseContentTopic entity){
        return ser.updateData2(id,entity);
    }
}