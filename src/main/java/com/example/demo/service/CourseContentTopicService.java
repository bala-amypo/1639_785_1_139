package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.CourseContentTopic;

public interface CourseContentTopicService{
    CourseContentTopic postData2(CourseContentTopic use);
    CourseContentTopic postdata2(CourseContentTopic log);
    List<CourseContentTopic>getAllData2();
    String  DeleteData2(Long id);
    CourseContentTopic getData2(Long id);         
    CourseContentTopic updateData2(Long id,CourseContentTopic entity);                                                        
}