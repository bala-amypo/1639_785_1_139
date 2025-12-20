package com.example.demo.service;

import com.example.demo.model.Garage;
import java.util.List;

public interface  CourseService{
    Course createCourse(University univ);
    Course updateCourse(Long id,University univ);
    Course getCourseById(Long id);
    void deactivateCourse(Long id);
}