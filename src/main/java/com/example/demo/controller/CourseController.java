// // package com.example.demo.controller;

// // import java.util.*;
// // import org.springframework.beans.factory.annotation.Autowired;
// // import org.springframework.web.bind.annotation.PostMapping;
// // import org.springframework.web.bind.annotation.GetMapping;
// // import org.springframework.web.bind.annotation.DeleteMapping;
// // import org.springframework.web.bind.annotation.PutMapping;
// // import org.springframework.web.bind.annotation.RequestBody;
// // import org.springframework.web.bind.annotation.RestController;
// // import org.springframework.web.bind.annotation.RequestMapping;
// // import org.springframework.web.bind.annotation.PathVariable;
// // import com.example.demo.entity.Course;
// // import com.example.demo.service.CourseService;
// // import jakarta.validation.Valid;

// // @RequestMapping("/Course")
// // @RestController
// // public class CourseController{
// //     @Autowired  CourseService ser;
// //     @PostMapping("/post")
// //     public Course sendData(@RequestBody Course course){
// //         return ser.createCourse(course);
// //     }
// //     @GetMapping("/get")
// //     public List<Course> getval(){
// //         return ser.getAllData3();
// //     }
// //     @GetMapping("/find/{id}")
// //     public Course find(@PathVariable Long id){
// //         return ser.getCourseById(id);
// //     }
// //     @PutMapping("/put/{id}")
// //     public Course putval(@PathVariable Long id,@RequestBody Course course){
// //         return ser.updateCourse(id,course);
// //     }
// //     @DeleteMapping("/delete/{id}")
// //     public String del(@PathVariable Long id){
// //         return ser.DeleteData3(id);
// //     }
// // }
// // // package com.example.demo.controller;

// // // import java.util.List;

// // // import org.springframework.beans.factory.annotation.Autowired;
// // // import org.springframework.http.ResponseEntity;
// // // import org.springframework.web.bind.annotation.*;

// // // import com.example.demo.entity.Course;
// // // import com.example.demo.service.CourseService;

// // // @RestController
// // // @RequestMapping("/courses")
// // // public class CourseController {

// // //     @Autowired
// // //     private CourseService courseService;

// // //     @PostMapping("/create")
// // //     public ResponseEntity<Course> createCourse(@RequestBody Course course) {
// // //         Course createdCourse = courseService.createCourse(course);
// // //         return ResponseEntity.ok(createdCourse); // HTTP 200
// // //     }

// // //     @GetMapping("/all")
// // //     public ResponseEntity<List<Course>> getAllCourses() {
// // //         List<Course> courses = courseService.getAllCourses();
// // //         return ResponseEntity.ok(courses); // HTTP 200
// // //     }

// // //     @GetMapping("/{id}")
// // //     public ResponseEntity<Course> getCourseById(@PathVariable Long id) {
// // //         Course course = courseService.getCourseById(id);
// // //         return ResponseEntity.ok(course); // HTTP 200
// // //     }

// // //     @PutMapping("/update/{id}")
// // //     public ResponseEntity<Course> updateCourse(@PathVariable Long id, @RequestBody Course course) {
// // //         Course updatedCourse = courseService.updateCourse(id, course);
// // //         return ResponseEntity.ok(updatedCourse); // HTTP 200
// // //     }

// // //     @DeleteMapping("/delete/{id}")
// // //     public ResponseEntity<String> deleteCourse(@PathVariable Long id) {
// // //         String message = courseService.deleteCourse(id);
// // //         return ResponseEntity.ok(message); // HTTP 200
// // //     }
// // // }
// package com.example.demo.controller;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.*;

// import com.example.demo.entity.Course;
// import com.example.demo.service.CourseService;

// @RestController
// @RequestMapping("/courses")
// public class CourseController {

//     @Autowired
//     private CourseService ser;

//     @PostMapping
//     public Course createCourse(@RequestBody Course course) {
//         return ser.createCourse(course);
//     }

//     @GetMapping("/{id}")
//     public Course getCourseById(@PathVariable Long id) {
//         return ser.getCourseById(id);
//     }

//     @GetMapping
//     public List<Course> getAllCourses() {
//         return ser.getAllCourses();  // <-- updated
//     }

//     @PutMapping("/{id}")
//     public Course updateCourse(@PathVariable Long id, @RequestBody Course course) {
//         return ser.updateCourse(id, course);
//     }

//     @DeleteMapping("/{id}")
//     public String deleteCourse(@PathVariable Long id) {
//         ser.deleteCourse(id);  // <-- updated
//         return "Course deleted successfully";
//     }
// }
package com.example.demo.controller;

import com.example.demo.entity.Course;
import com.example.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseService service;

    @PostMapping
    public Course create(@RequestBody Course course) {
        return service.createCourse(course);
    }

    @PutMapping("/{id}")
    public Course update(@PathVariable Long id, @RequestBody Course course) {
        return service.updateCourse(id, course);
    }

    @GetMapping("/{id}")
    public Course get(@PathVariable Long id) {
        return service.getCourseById(id);
    }

    @DeleteMapping("/{id}")
    public void deactivate(@PathVariable Long id) {
        service.deactivateCourse(id);
    }

    @GetMapping("/university/{universityId}")
    public List<Course> getByUniversity(@PathVariable Long universityId) {
        return service.getCoursesByUniversity(universityId);
    }
}