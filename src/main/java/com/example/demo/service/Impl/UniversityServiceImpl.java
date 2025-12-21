package com.example.demo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;   
import com.example.demo.entity.University;
import com.example.demo.repository.UniversityRepository;
// import org.springframework.web.bind.annotation.PathVariable;
import com.example.demo.service.UniversityService;                

@Service
public class UniversityServiceImpl implements UniversityService{

    @Autowired UniversityRepository used;
    @Override
    public University postData1(University use){
        return used.save(use);  
    }
    @Override
    public List<University>getAllData1(){
        return used.findAll();
    }
    @Override
    public String DeleteData1(Long id){
        used.deleteById(id);
        return "Deleted successfully";
    }
    @Override
    public University getData1(Long id){
    return used.findById(id).orElse(null);
    }
    @Override
    public University updateData1(Long id,University entity){
        if(used.existsById(id)){
            entity.setId(id);
            return used.save(entity);
        } 
        return null;
    }
}