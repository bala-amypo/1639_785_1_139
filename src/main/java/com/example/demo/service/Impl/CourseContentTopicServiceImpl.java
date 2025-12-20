package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Course;
import com.example.demo.entity.CourseContentTopic;
import com.example.demo.repository.CourseContentTopicRepository;
import com.example.demo.repository.CourseRepository;
import com.example.demo.service.CourseContentTopicService;

@Service
public class CourseContentTopicServiceImpl implements CourseContentTopicService {

    @Autowired
    CourseContentTopicRepository topicRepository;

    @Autowired
    CourseRepository courseRepository;

    @Override
    public CourseContentTopic createTopic(CourseContentTopic topic) {
        return topicRepository.save(topic);
    }

    @Override
    public List<CourseContentTopic> getTopicsForCourse(Long courseId) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("not found"));
        return topicRepository.findByCourse(course);
    }

    @Override
    public CourseContentTopic getTopicById(Long id) {
        return topicRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("not found"));
    }

    @Override
    public CourseContentTopic updateTopic(Long id, CourseContentTopic topic) {
        if (topicRepository.existsById(id)) {
            topic.setId(id);
            return topicRepository.save(topic);
        }
        throw new RuntimeException("not found");
    }
}