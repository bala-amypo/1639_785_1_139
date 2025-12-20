package com.example.demo.service;

import com.example.demo.entity.Course;
import java.util.List;

public interface  CourseService{
    Course createCourse(Course univ);
    Course updateCourse(Long id,Course univ);
    Course getCourseById(Long id);
    void deactivateCourse(Long id);
}