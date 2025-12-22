package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.Course;

public interface CourseService{
    Course createCourse(Course course);
    Course updateCourse(Long id,Course course);
    Course getCourseById(Long id);
    List<Course>getAllData3();
    String  DeleteData3(Long id);                                      
}
// package com.example.demo.service;

// import java.util.List;
// import com.example.demo.entity.Course;

// public interface CourseService {
//     Course createCourse(Course course);
//     List<Course> getAllCourses();
//     Course getCourseById(Long id);
//     Course updateCourse(Long id, Course course);
//     String deleteCourse(Long id);
// }
