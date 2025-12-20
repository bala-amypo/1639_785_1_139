package com.example.demo.service;

import com.example.demo.entity.CourseContentTopic;
import java.util.List;

public interface  CourseContentTopicService{
    CourseContentTopic createTopic(CourseContentTopic course);
    CourseContentTopic updateTopic(Long id,CourseContentTopic course);
    CourseContentTopic getTopicById(Long id);
}