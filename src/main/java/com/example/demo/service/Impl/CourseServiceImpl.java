package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Course;
import com.example.demo.model.University;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.UniversityRepository;
import com.example.demo.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    UniversityRepository universityRepository;

    @Override
    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course updateCourse(Long id, Course course) {
        if (courseRepository.existsById(id)) {
            course.setId(id);
            return courseRepository.save(course);
        }
        throw new RuntimeException("not found");
    }

    @Override
    public Course getCourseById(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("not found"));
    }

    @Override
    public List<Course> getCoursesByUniversity(Long universityId) {
        University university = universityRepository.findById(universityId)
                .orElseThrow(() -> new RuntimeException("not found"));

        return courseRepository.findByUniversity(university);
    }

    @Override
    public void deactivateCourse(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("not found"));

        course.setActive(false);
        courseRepository.save(course);
    }
}