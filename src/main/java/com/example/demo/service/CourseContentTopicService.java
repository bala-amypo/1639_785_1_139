package com.example.demo.service;

import com.example.demo.model.University;
import java.util.List;

public interface  UniversityService{
    University createTopic(Course course);
    University updateTopic(Long id,CourseContentTopic course);
    University getTopicById(Long id);
}