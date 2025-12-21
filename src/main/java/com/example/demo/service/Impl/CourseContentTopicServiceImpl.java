package com.example.demo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;   
import com.example.demo.entity.CourseContent;
import com.example.demo.repository.CourseContentTopicRepository;
// import org.springframework.web.bind.annotation.PathVariable;
import com.example.demo.service.CourseContentTopicService;                

@Service
public class CourseContentTopicServiceImpl implements CourseContentTopicService{

    @Autowired CourseContentTopicRepository used;
    @Override
    public CourseContentTopic postData2(CourseContentTopic use){
        return used.save(use);  
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
    public CourseContentTopic getData2(Long id){
    return used.findById(id).orElse(null);
    }
    @Override
    public CourseContentTopic updateData2(Long id,CourseContentTopic entity){
        if(used.existsById(id)){
            entity.setId(id);
            return used.save(entity);
        } 
        return null;
    }
}