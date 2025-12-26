// // // // // package com.example.demo.service.impl;

// // // // // import java.util.List;
// // // // // import org.springframework.beans.factory.annotation.Autowired;
// // // // // import org.springframework.stereotype.Service;   
// // // // // import com.example.demo.entity.Course;
// // // // // import com.example.demo.repository.CourseRepository;
// // // // // // import org.springframework.web.bind.annotation.PathVariable;
// // // // // import com.example.demo.service.CourseService;                

// // // // // @Service
// // // // // public class CourseServiceImpl implements CourseService{

// // // // //     @Autowired CourseRepository repo;
// // // // //     @Override
// // // // //     public Course createCourse(Course course){
// // // // //         return repo.save(course);  
// // // // //     }
// // // // //     @Override
// // // // //     public List<Course>getAllData3(){
// // // // //         return repo.findAll();
// // // // //     }
// // // // //     @Override
// // // // //     public Course getCourseById(Long id){
// // // // //     return repo.findById(id).orElse(null);
// // // // //     }
// // // // //     @Override
// // // // //     public Course updateCourse(Long id,Course course){
// // // // //         if(repo.existsById(id)){
// // // // //             course.setId(id);
// // // // //             return repo.save(course);
// // // // //         } 
// // // // //         return null;
// // // // //     }
// // // // //     @Override
// // // // //     public String DeleteData3(Long id){
// // // // //         repo.deleteById(id);
// // // // //         return "Deleted successfully";
// // // // //     }
// // // // // }

// // // // package com.example.demo.service.impl;

// // // // import java.util.*;
// // // // import com.example.demo.entity.*;
// // // // import com.example.demo.repository.*;

// // // // public class CourseServiceImpl {

// // // //     private CourseRepository repo;
// // // //     private UniversityRepository univRepo;

// // // //     public Course createCourse(Course c) {
// // // //         if (c.getCreditHours() <= 0)
// // // //             throw new IllegalArgumentException("Credit hours must be > 0");

// // // //         Long uid = c.getUniversity().getId();
// // // //         univRepo.findById(uid).orElseThrow(() -> new RuntimeException("University not found"));

// // // //         repo.findByUniversityIdAndCourseCode(uid, c.getCourseCode())
// // // //                 .ifPresent(x -> { throw new IllegalArgumentException("Duplicate course"); });

// // // //         return repo.save(c);
// // // //     }

// // // //     public void deactivateCourse(Long id) {
// // // //         Course c = repo.findById(id)
// // // //                 .orElseThrow(() -> new RuntimeException("Course not found"));
// // // //         c.setActive(false);
// // // //         repo.save(c);
// // // //     }

// // // //     public Course updateCourse(Long id, Course c) {
// // // //         Course existing = repo.findById(id)
// // // //                 .orElseThrow(() -> new RuntimeException("Course not found"));
// // // //         return repo.save(existing);
// // // //     }

// // // //     public Course getCourseById(Long id) {
// // // //         return repo.findById(id)
// // // //                 .orElseThrow(() -> new RuntimeException("Course not found"));
// // // //     }

// // // //     public List<Course> getCoursesByUniversity(Long univId) {
// // // //         return repo.findByUniversityIdAndActiveTrue(univId);
// // // //     }
// // // // }
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
    private CourseRepository repo;

    @Override
    public Course createCourse(Course course) {
        return repo.save(course);
    }

    @Override
    public List<Course> getAllData3() {
        return repo.findAll();
    }

    @Override
    public Course getCourseById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Course updateCourse(Long id, Course course) {
        Course existing = repo.findById(id).orElse(null);
        if (existing != null) {
            existing.setCourseName(course.getCourseName());
            return repo.save(existing);
        }
        return null;
    }

    @Override
    public String DeleteData3(Long id) {
        repo.deleteById(id);
        return "Course deleted successfully";
    }
}
// // package com.example.demo.service.impl;

// // import java.util.List;

// // import org.springframework.stereotype.Service;
// // import org.springframework.beans.factory.annotation.Autowired;
// // import org.springframework.web.server.ResponseStatusException;
// // import static org.springframework.http.HttpStatus.NOT_FOUND;

// // import com.example.demo.entity.Course;
// // import com.example.demo.repository.CourseRepository;
// // import com.example.demo.service.CourseService;

// // @Service
// // public class CourseServiceImpl implements CourseService {

// //     @Autowired
// //     private CourseRepository repo;

// //     @Override
// //     public Course createCourse(Course course) {
// //         return repo.save(course);
// //     }

// //     @Override
// //     public Course getCourseById(Long id) {
// //         return repo.findById(id)
// //                 .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Course not found"));
// //     }

// //     @Override
// //     public List<Course> getAllCourses() {
// //         return repo.findAll();
// //     }

// //     @Override
// //     public Course updateCourse(Long id, Course course) {
// //         Course existing = getCourseById(id);
// //         existing.setCourseName(course.getCourseName());
// //         existing.setDescription(course.getDescription());
// //         return repo.save(existing);
// //     }

// //     @Override
// //     public void deleteCourse(Long id) {
// //         repo.deleteById(id);
// //     }
// // }
// package com.example.demo.service.impl;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;
// import org.springframework.web.server.ResponseStatusException;

// import static org.springframework.http.HttpStatus.NOT_FOUND;

// import com.example.demo.entity.Course;
// import com.example.demo.repository.CourseRepository;
// import com.example.demo.service.CourseService;

// @Service
// public class CourseServiceImpl implements CourseService {

//     @Autowired
//     private CourseRepository repo;

//     @Override
//     public Course createCourse(Course course) {
//         return repo.save(course);
//     }

//     @Override
//     public Course getCourseById(Long id) {
//         return repo.findById(id)
//                 .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Course not found"));
//     }

//     @Override
//     public List<Course> getAllCourses() {
//         return repo.findAll();
//     }

//     @Override
//     public Course updateCourse(Long id, Course course) {
//         Course existing = getCourseById(id);
//         existing.setCourseName(course.getCourseName());
//         existing.setDescription(course.getDescription());
//         return repo.save(existing);
//     }

//     @Override
//     public void deleteCourse(Long id) {
//         repo.deleteById(id);
//     }
// }
