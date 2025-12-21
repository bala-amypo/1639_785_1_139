// package com.example.demo.service.impl;

// import java.util.List;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;   
// import com.example.demo.entity.Course;
// import com.example.demo.repository.CourseRepository;
// // import org.springframework.web.bind.annotation.PathVariable;
// import com.example.demo.service.CourseService;                

// @Service
// public class CourseServiceImpl implements CourseService{

//     @Autowired CourseRepository used;
//     @Override
//     public Course createCourse(Course course){
//         return used.save(course);  
//     }
//     @Override
//     public List<Course>getAllData3(){
//         return used.findAll();
//     }
//     @Override
//     public Course getCourseById(Long id){
//     return used.findById(id).orElse(null);
//     }
//     @Override
//     public Course updateCourse(Long id,Course course){
//         if(used.existsById(id)){
//             course.setId(id);
//             return used.save(course);
//         } 
//         return null;
//     }
//     @Override
//     public String DeleteData3(Long id){
//         used.deleteById(id);
//         return "Deleted successfully";
//     }
// }
package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Course;
import com.example.demo.repository.CourseRepository;
import com.example.demo.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course getCourseById(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found with id: " + id));
    }

    @Override
    public Course updateCourse(Long id, Course course) {
        Course existingCourse = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found with id: " + id));

        existingCourse.setUniversity(course.getUniversity());
        existingCourse.setCourseCode(course.getCourseCode());
        existingCourse.setCourseName(course.getCourseName());
        existingCourse.setDescription(course.getDescription());
        existingCourse.setDepartment(course.getDepartment());
        existingCourse.setCreditHours(course.getCreditHours());
        existingCourse.setActive(course.getActive());

        return courseRepository.save(existingCourse);
    }

    @Override
    public String deleteCourse(Long id) {
        Course existingCourse = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found with id: " + id));

        courseRepository.delete(existingCourse);
        return "Course deleted successfully with id: " + id;
    }
}
