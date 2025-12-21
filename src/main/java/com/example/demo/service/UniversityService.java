package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.University;

public interface UniversityService{
    University createUniversity(University univ);
     University updateData1(Long id,University entity);
    List<University>getAllData1();
    String  DeleteData1(Long id);
    University getData1(Long id);         
    University updateData1(Long id,University entity);                                                        
}