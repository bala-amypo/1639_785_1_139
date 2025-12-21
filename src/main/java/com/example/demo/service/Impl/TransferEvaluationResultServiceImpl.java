package com.example.demo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;   
import com.example.demo.entity.Course;
import com.example.demo.repository.TransferEvaluationResultRepository;
// import org.springframework.web.bind.annotation.PathVariable;
import com.example.demo.service.TransferEvaluationResultService;                

@Service
public class CoServiceImpl implements CourseService{

    @Autowired CourseRepository used;
    @Override
    public Course postData3(Course use){
        return used.save(use);  
    }
    @Override
    public List<Course>getAllData3(){
        return used.findAll();
    }
    @Override
    public String DeleteData3(Long id){
        used.deleteById(id);
        return "Deleted successfully";
    }
    @Override
    public Course getData3(Long id){
    return used.findById(id).orElse(null);
    }
    @Override
    public Course updateData3(Long id,Course entity){
        if(used.existsById(id)){
            entity.setId(id);
            return used.save(entity);
        } 
        return null;
    }
}