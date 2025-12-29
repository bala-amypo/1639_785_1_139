









// package com.example.demo.controller;

// import java.util.*;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import com.example.demo.entity.Course;
// import com.example.demo.service.CourseService;
// import jakarta.validation.Valid;

// @RequestMapping("/Course")
// @RestController
// public class CourseController{
//     @Autowired  CourseService ser;
//     @PostMapping("/post")
//     public Course sendData(@RequestBody Course course){
//         return ser.createCourse(course);
//     }
//     @GetMapping("/get")
//     public List<Course> getval(){
//         return ser.getAllData3();
//     }
//     @GetMapping("/find/{id}")
//     public Course find(@PathVariable Long id){
//         return ser.getCourseById(id);
//     }
//     @PutMapping("/put/{id}")
//     public Course putval(@PathVariable Long id,@RequestBody Course course){
//         return ser.updateCourse(id,course);
//     }
//     @DeleteMapping("/delete/{id}")
//     public String del(@PathVariable Long id){
//         return ser.DeleteData3(id);
//     }
// }






// package com.example.demo.controller;

// import com.example.demo.entity.Course;
// import com.example.demo.service.CourseService;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/api/courses")
// public class CourseController {

//     private final CourseService ser;

//     public CourseController(CourseService ser) {
//         this.ser = ser;
//     }

//     @PostMapping
//     public Course create(@RequestBody Course course) {
//         return ser.createCourse(course);
//     }

//     @GetMapping
//     public List<Course> getAll() {
//         // matches getAllData3() in CourseService
//         return ser.getAllData3();
//     }

//     @GetMapping("/{id}")
//     public Course getById(@PathVariable Long id) {
//         return ser.getCourseById(id);
//     }

//     @PutMapping("/{id}")
//     public Course update(@PathVariable Long id, @RequestBody Course course) {
//         return ser.updateCourse(id, course);
//     }

//     @DeleteMapping("/{id}")
//     public void delete(@PathVariable Long id) {
//         // matches DeleteData3(Long) in CourseService
//         ser.DeleteData3(id);
//     }
// }




package com.example.demo.controller;

import com.example.demo.entity.Course;
import com.example.demo.service.CourseService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
@Tag(name = "Course")
public class CourseController {

    private final CourseService service;

    public CourseController(CourseService service) {
        this.service = service;
    }

    @PostMapping
    public Course create(@RequestBody Course c) {
        return service.createCourse(c);
    }

    @PutMapping("/{id}")
    public Course update(@PathVariable Long id, @RequestBody Course c) {
        return service.updateCourse(id, c);
    }

    @GetMapping("/{id}")
    public Course getById(@PathVariable Long id) {
        return service.getCourseById(id);
    }

    @GetMapping("/university/{universityId}")
    public List<Course> byUniversity(@PathVariable Long universityId) {
        return service.getCoursesByUniversity(universityId);
    }

    @DeleteMapping("/{id}")
    public void deactivate(@PathVariable Long id) {
        service.deactivateCourse(id);
    }
}