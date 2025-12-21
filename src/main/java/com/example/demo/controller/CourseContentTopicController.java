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
// import com.example.demo.entity.CourseContentTopic;
// import com.example.demo.service.CourseContentTopicService;
// import jakarta.validation.Valid;

// @RequestMapping("/CourseContentTopic")
// @RestController
// public class CourseContentTopicController{
//     @Autowired  CourseContentTopicService ser;
//     @PostMapping("/post")
//     public CourseContentTopic sendData(@RequestBody CourseContentTopic topic){
//         return ser.createTopic(topic);
//     }
//     @GetMapping("/get")
//     public List<CourseContentTopic> getval(){
//         return ser.getAllData2();
//     }
//     @DeleteMapping("/delete/{id}")
//     public String del(@PathVariable Long id){
//         return ser.DeleteData2(id);
//     }
//     @GetMapping("/find/{id}")
//     public CourseContentTopic find(@PathVariable Long id){
//         return ser.getTopicById(id);
//     }
//     @PutMapping("/put/{id}")
//     public CourseContentTopic putval(@PathVariable Long id,@RequestBody CourseContentTopic topic){
//         return ser.updateTopic(id,topic);
//     }
// }
package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.CourseContentTopic;
import com.example.demo.service.CourseContentTopicService;

@RestController
@RequestMapping("/course-content-topic")
public class CourseContentTopicController {

    @Autowired
    private CourseContentTopicService service;

    @PostMapping("/create")
    public ResponseEntity<CourseContentTopic> createTopic(@RequestBody CourseContentTopic topic) {
        CourseContentTopic created = service.createTopic(topic);
        return ResponseEntity.ok(created); // 200 OK
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<CourseContentTopic> getTopicById(@PathVariable Long id) {
        CourseContentTopic topic = service.getTopicById(id);
        return ResponseEntity.ok(topic); // 200 OK
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<CourseContentTopic>> getAllTopics() {
        List<CourseContentTopic> topics = service.getAllData2();
        return ResponseEntity.ok(topics); // 200 OK
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CourseContentTopic> updateTopic(@PathVariable Long id,
                                                          @RequestBody CourseContentTopic topic) {
        CourseContentTopic updated = service.updateTopic(id, topic);
        return ResponseEntity.ok(updated); // 200 OK
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTopic(@PathVariable Long id) {
        String msg = service.DeleteData2(id);
        return ResponseEntity.ok(msg); // 200 OK
    }
}
