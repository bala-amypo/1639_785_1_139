// // // package com.example.demo.service.impl;

// // // import java.util.List;
// // // import org.springframework.beans.factory.annotation.Autowired;
// // // import org.springframework.stereotype.Service;   
// // // import com.example.demo.entity.CourseContentTopic;
// // // import com.example.demo.repository.CourseContentTopicRepository;
// // // // import org.springframework.web.bind.annotation.PathVariable;
// // // import com.example.demo.service.CourseContentTopicService;                

// // // @Service
// // // public class CourseContentTopicServiceImpl implements CourseContentTopicService{

// // //     @Autowired CourseContentTopicRepository used;
// // //     @Override
// // //     public CourseContentTopic createTopic(CourseContentTopic topic){
// // //         return used.save(topic);  
// // //     }
// // //     @Override
// // //     public List<CourseContentTopic>getAllData2(){
// // //         return used.findAll();
// // //     }
// // //     @Override
// // //     public String DeleteData2(Long id){
// // //         used.deleteById(id);
// // //         return "Deleted successfully";
// // //     }
// // //     @Override
// // //     public CourseContentTopic getTopicById(Long id){
// // //     return used.findById(id).orElse(null);
// // //     }
// // //     @Override
// // //     public CourseContentTopic updateTopic(Long id,CourseContentTopic topic){
// // //         if(used.existsById(id)){
// // //             topic.setId(id);
// // //             return used.save(topic);
// // //         } 
// // //         return null;
// // //     }
// // // }

// // package com.example.demo.service.impl;

// // import java.util.*;
// // import com.example.demo.entity.*;
// // import com.example.demo.repository.*;

// // public class CourseContentTopicServiceImpl {

// //     private CourseContentTopicRepository repo;
// //     private CourseRepository courseRepo;

// //     public CourseContentTopic createTopic(CourseContentTopic t) {
// //         if (t.getTopicName() == null || t.getTopicName().isBlank())
// //             throw new IllegalArgumentException("Topic name required");

// //         if (t.getWeightPercentage() < 0 || t.getWeightPercentage() > 100)
// //             throw new IllegalArgumentException("Weight must be 0-100");

// //         courseRepo.findById(t.getCourse().getId())
// //                 .orElseThrow(() -> new RuntimeException("Course not found"));

// //         return repo.save(t);
// //     }

// //     public CourseContentTopic updateTopic(Long id, CourseContentTopic t) {
// //         repo.findById(id).orElseThrow(() -> new RuntimeException("Topic not found"));
// //         return repo.save(t);
// //     }

// //     public CourseContentTopic getTopicById(Long id) {
// //         return repo.findById(id)
// //                 .orElseThrow(() -> new RuntimeException("Topic not found"));
// //     }

// //     public List<CourseContentTopic> getTopicsForCourse(Long courseId) {
// //         courseRepo.findById(courseId)
// //                 .orElseThrow(() -> new RuntimeException("Course not found"));
// //         return repo.findByCourseId(courseId);
// //     }
// // }
// package com.example.demo.service.impl;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.example.demo.entity.CourseContentTopic;
// import com.example.demo.repository.CourseContentTopicRepository;
// import com.example.demo.service.CourseContentTopicService;

// @Service
// public class CourseContentTopicServiceImpl implements CourseContentTopicService {

//     @Autowired
//     private CourseContentTopicRepository repo;

//     @Override
//     public CourseContentTopic createTopic(CourseContentTopic topic) {
//         return repo.save(topic);
//     }

//     @Override
//     public List<CourseContentTopic> getAllData2() {
//         return repo.findAll();
//     }

//     @Override
//     public CourseContentTopic getTopicById(Long id) {
//         return repo.findById(id).orElse(null);
//     }

//     @Override
//     public CourseContentTopic updateTopic(Long id, CourseContentTopic topic) {
//         CourseContentTopic existing = repo.findById(id).orElse(null);
//         if (existing != null) {
//             existing.setTopicName(topic.getTopicName());
//             return repo.save(existing);
//         }
//         return null;
//     }

//     @Override
//     public String DeleteData2(Long id) {
//         repo.deleteById(id);
//         return "Course content topic deleted successfully";
//     }
// }
package com.example.demo.service.impl;

import com.example.demo.entity.CourseContentTopic;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.CourseContentTopicRepository;
import com.example.demo.repository.CourseRepository;
import com.example.demo.service.CourseContentTopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseContentTopicServiceImpl implements CourseContentTopicService {

    @Autowired
    private CourseContentTopicRepository repo;

    @Autowired
    private CourseRepository courseRepo;

    @Override
    public CourseContentTopic createTopic(CourseContentTopic topic) {
        if (topic.getTopicName() == null || topic.getTopicName().isBlank()) {
            throw new IllegalArgumentException("Topic name is required");
        }
        if (topic.getWeightPercentage() < 0 || topic.getWeightPercentage() > 100) {
            throw new IllegalArgumentException("Weight percentage must be between 0 and 100");
        }
        courseRepo.findById(topic.getCourse().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Course", topic.getCourse().getId()));
        return repo.save(topic);
    }

    @Override
    public CourseContentTopic updateTopic(Long id, CourseContentTopic topic) {
        CourseContentTopic existing = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Topic", id));
        existing.setTopicName(topic.getTopicName());
        existing.setWeightPercentage(topic.getWeightPercentage());
        return repo.save(existing);
    }

    @Override
    public CourseContentTopic getTopicById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Topic", id));
    }

    @Override
    public List<CourseContentTopic> getTopicsForCourse(Long courseId) {
        courseRepo.findById(courseId)
                .orElseThrow(() -> new ResourceNotFoundException("Course", courseId));
        return repo.findByCourseId(courseId);
    }
}