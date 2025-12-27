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
//     // @GetMapping("/get")
//     // public List<CourseContentTopic> getval(){
//     //     return ser.getAllData2();
//     // }
//     // @DeleteMapping("/delete/{id}")
//     // public String del(@PathVariable Long id){
//     //     return ser.DeleteData2(id);
//     // }
//     @GetMapping("/find/{id}")
//     public CourseContentTopic find(@PathVariable Long id){
//         return ser.getTopicById(id);
//     }
//     @PutMapping("/put/{id}")
//     public CourseContentTopic putval(@PathVariable Long id,@RequestBody CourseContentTopic topic){
//         return ser.updateTopic(id,topic);
//     }
// }






package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "course_content_topic")
public class CourseContentTopic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "topic_name", nullable = false)
    private String topicName;

    @Column(name = "weight_percentage", nullable = false)
    private Double weightPercentage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course course;

    public CourseContentTopic() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTopicName() { return topicName; }
    public void setTopicName(String topicName) { this.topicName = topicName; }
    public Double getWeightPercentage() { return weightPercentage; }
    public void setWeightPercentage(Double weightPercentage) { this.weightPercentage = weightPercentage; }
    public Course getCourse() { return course; }
    public void setCourse(Course course) { this.course = course; }
}
