package com.example.demo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;   
import com.example.demo.entity.CourseContentTopic;
import com.example.demo.repository.CourseContentTopicRepository;
// import org.springframework.web.bind.annotation.PathVariable;
import com.example.demo.service.CourseContentTopicService;                

@Service
public class CourseContentTopicServiceImpl implements CourseContentTopicService{

    @Autowired CourseContentTopicRepository used;
    @Override
    public CourseContentTopic createTopic(CourseContentTopic topic){
        return used.save(topic);  
    }turn used.findById(id).orElse(null);
    }
    @Override
    public CourseContentTopic updateTopic(Long id,CourseContentTopic topic){
        if(used.existsById(id)){
            topic.setId(id);
            return used.save(topic);
        } 
        return null;
    }
    @Override
    public List<CourseContentTopic>getAllData2(){
        return used.findAll();
    }
    @Override
    public String DeleteData2(Long id){
        used.deleteById(id);
        return "Deleted successfully";
    }
    @Override
    public CourseContentTopic getTopicById(Long id){
    re
}