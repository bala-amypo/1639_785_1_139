// package com.example.demo.service.impl;

// import java.util.List;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;   
// import com.example.demo.entity.CourseContentTopic;
// import com.example.demo.repository.CourseContentTopicRepository;
// // import org.springframework.web.bind.annotation.PathVariable;
// import com.example.demo.service.CourseContentTopicService;                

// @Service
// public class CourseContentTopicServiceImpl implements CourseContentTopicService{

//     @Autowired CourseContentTopicRepository used;
//     @Override
//     public CourseContentTopic createTopic(CourseContentTopic topic){
//         return used.save(topic);  
//     }
//     @Override
//     public List<CourseContentTopic>getAllData2(){
//         return used.findAll();
//     }
//     @Override
//     public String DeleteData2(Long id){
//         used.deleteById(id);
//         return "Deleted successfully";
//     }
//     @Override
//     public CourseContentTopic getTopicById(Long id){
//     return used.findById(id).orElse(null);
//     }
//     @Override
//     public CourseContentTopic updateTopic(Long id,CourseContentTopic topic){
//         if(used.existsById(id)){
//             topic.setId(id);
//             return used.save(topic);
//         } 
//         return null;
//     }
// }

package com.example.demo.service.impl;

import java.util.*;
import com.example.demo.entity.*;
import com.example.demo.repository.*;

public class CourseContentTopicServiceImpl {

    private CourseContentTopicRepository repo;
    private CourseRepository courseRepo;

    public CourseContentTopic createTopic(CourseContentTopic t) {
        if (t.getTopicName() == null || t.getTopicName().isBlank())
            throw new IllegalArgumentException("Topic name required");

        if (t.getWeightPercentage() < 0 || t.getWeightPercentage() > 100)
            throw new IllegalArgumentException("Weight must be 0-100");

        courseRepo.findById(t.getCourse().getId())
                .orElseThrow(() -> new RuntimeException("Course not found"));

        return repo.save(t);
    }

    public CourseContentTopic updateTopic(Long id, CourseContentTopic t) {
        repo.findById(id).orElseThrow(() -> new RuntimeException("Topic not found"));
        return repo.save(t);
    }

    public CourseContentTopic getTopicById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Topic not found"));
    }

    public List<CourseContentTopic> getTopicsForCourse(Long courseId) {
        courseRepo.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        return repo.findByCourseId(courseId);
    }
}
