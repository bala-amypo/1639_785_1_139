package com.example.demo.service;

import com.example.demo.model.CourseContentTopic;
import java.util.List;

public interface  CourseContentTopicService{
    CourseContentTopic createTopic(Course course);
    CourseContentTopic updateTopic(Long id,CourseContentTopic course);
    CourseContentTopic getTopicById(Long id);
}