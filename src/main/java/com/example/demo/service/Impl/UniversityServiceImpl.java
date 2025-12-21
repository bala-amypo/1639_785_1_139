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
            entity.setId(id);
            return used.save(entity);
        } 
        return null;
    }
    @Override
    @PutMapping("/{id}/deactivate")
    public ResponseEntity<String> deactivateUniversity(@PathVariable Long id) {
        universityService.deactivateUniversity(id);
        return ResponseEntity.ok("University deactivated successfully");
    }
}