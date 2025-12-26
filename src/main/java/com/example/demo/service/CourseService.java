// package com.example.demo.service;

// import java.util.List;
// import com.example.demo.entity.Course;

// public interface CourseService{
//     Course createCourse(Course course);
//     Course updateCourse(Long id,Course course);
//     Course getCourseById(Long id);
//     List<Course>getAllData3();
//     String  DeleteData3(Long id);                                      
// }













// package com.example.demo.service;

// import java.util.List;
// import com.example.demo.entity.Course;

// public interface CourseService {

//     Course createCourse(Course course);

//     List<Course> getAllData3();

//     Course getCourseById(Long id);

//     Course updateCourse(Long id, Course course);

//     String DeleteData3(Long id);
// }






package com.example.demo.service;

import com.example.demo.entity.Course;
import java.util.List;

public interface CourseService {

    Course createCourse(Course course);

    Course getCourseById(Long id);

    Course updateCourse(Long id, Course course);

    void deactivateCourse(Long id);

    java.util.List<Course> getCoursesByUniversity(Long universityId);

    // used by CourseController
    java.util.List<Course> getAllData3();

    void DeleteData3(Long id);
}
