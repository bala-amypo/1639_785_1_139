package com.example.demo.service;

import java.util.List;
import com.example.demo.model.User;

public interface CourseContentService{
    CourseContent postData2(CourseContent use);
    CourseContent postdata2(CourseContent log);
    List<CourseContent>getAllData2();
    String  DeleteData2(Long id);
    CourseContent getData2(Long id);         
    CourseContent updateData2(Long id,CourseContent entity);                                                        
}