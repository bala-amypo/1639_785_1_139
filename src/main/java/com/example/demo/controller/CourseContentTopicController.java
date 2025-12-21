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
import com.example.demo.entity.CourseContentTopic;
import com.example.demo.service.CourseContentTopicService;
import jakarta.validation.Valid;

@RequestMapping("/User")
@RestController
public class CourseContentTopicController{
    @Autowired  CourseContentTopicService ser;
    @PostMapping("/register")
    public CourseContentTopic sendData(@RequestBody CourseContentTopic stu){
        return ser.postData1(stu);
    }
    @PostMapping("/login")
    public CourseContentTopic senddata(@RequestBody CourseContentTopic log){
        return ser.postdata(log);
    }
    @GetMapping("/get")
    public List<User> getval(){
        return ser.getAllData1();
    }
    @DeleteMapping("/delete/{id}")
    public String del(@PathVariable Long id){
        return ser.DeleteData1(id);
    }
    @GetMapping("/find/{id}")
    public User find(@PathVariable Long id){
        return ser.getData1(id);
    }
    @PutMapping("/put/{id}")
    public User putval(@PathVariable Long id,@RequestBody User entity){
        return ser.updateData1(id,entity);
    }
}