package com.example.demo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;   
import com.example.demo.entity.University;
import com.example.demo.repository.UniversityRepository;
import com.example.demo.exception.ResourceNotFoundException;
// import org.springframework.web.bind.annotation.PathVariable;
import com.example.demo.service.UniversityService;                

@Service
public class UniversityServiceImpl implements UniversityService{

    @Autowired UniversityRepository repository;
    @Override
    public University createUniversity(University univ){
        return repository.save(univ);  
    }
    @Override
    public List<University>getAllUniversities(){
        return repository.findAll();
    }
    @Override
    public University getUniversityById(Long id){
    return repository.findById(id).orElseThrow(()->new ResourceNotFoundException("exists"));
    }
    @Override
    public University updateUniversity(Long id,University univ){
        if(repository.existsById(id)){
            univ.setId(id);
            return repository.save(univ);
        } 
        return null;
    }
    @Override
    public String DeleteData1(Long id){
        repository.deleteById(id);
        return "Deleted successfully";
    }
   
}
