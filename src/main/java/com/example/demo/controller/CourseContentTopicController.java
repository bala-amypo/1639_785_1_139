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

@RequestMapping("/CourseContentTopic")
@RestController
public class CourseContentTopicController{
    @Autowired  CourseContentTopicService ser;
    @PostMapping("/post")
    public CourseContentTopic sendData(@RequestBody CourseContentTopic topic){
        return ser.createTopic(topic);
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
        return ser.getTopicById(id);
    }
    @PutMapping("/put/{id}")
    public CourseContentTopic putval(@PathVariable Long id,@RequestBody CourseContentTopic topic){
        return ser.updateTopic(id,topic);
    }
}