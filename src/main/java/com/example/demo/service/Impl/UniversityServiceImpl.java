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
    public University createUniversity(University univ){
        return used.save(univ);  
    }
    @Override
    public List<University>getAllUniversities(){
        return used.findAll();
    }
    @Override
    public University getUniversityById(Long id){
    return used.findById(id).orElseThrow(()-> new RuntimeException("not found"));
    }
    @Override
    public University updateUniversity(Long id,University univ){
        if(used.existsById(id)){
            univ.setId(id);
            return used.save(univ);
        } 
        return null;
    }
    @Override
    public String DeleteData1(Long id){
        used.deleteById(id);
        return "Deleted successfully";
    }
   
}