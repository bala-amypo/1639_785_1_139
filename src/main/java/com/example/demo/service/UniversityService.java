package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.University;

public interface UniversityService{
    University createUniversity(University univ);
    University updateUniversity(Long id,University univ);
    University getUniversityById(Long id);
    List<University>getAllUniversities();
    void deactivateUniversity(Long id); 
}