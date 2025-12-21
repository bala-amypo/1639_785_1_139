package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.Course;

public interface CourseService{
    Course postData3(Course use);
    Course postdata3(Course log);
    List<Course>getAllData3();
    String  DeleteData3(Long id);
    Course getData3(Long id);         
    Course updateData3(Long id,Course entity);                                                        
}