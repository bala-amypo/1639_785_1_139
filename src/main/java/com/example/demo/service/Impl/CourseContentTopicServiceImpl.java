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

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import com.example.demo.entity.Course;
import com.example.demo.entity.CourseContentTopic;
import com.example.demo.repository.CourseContentTopicRepository;
import com.example.demo.repository.CourseRepository;
import com.example.demo.service.CourseContentTopicService;

@Service
public class CourseContentTopicServiceImpl implements CourseContentTopicService {

    private final CourseContentTopicRepository topicRepo;
    private final CourseRepository courseRepo;

    public CourseContentTopicServiceImpl(
            CourseContentTopicRepository topicRepo,
            CourseRepository courseRepo) {
        this.topicRepo = topicRepo;
        this.courseRepo = courseRepo;
    }

    @Override
    public CourseContentTopic create(Long courseId, CourseContentTopic topic) {
        Course course = courseRepo.findById(courseId)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Course not found"));

        topic.setCourse(course);
        return topicRepo.save(topic);
    }

    @Override
    public List<CourseContentTopic> getByCourse(Long courseId) {
        return topicRepo.findByCourseId(courseId);
    }

    @Override
    public CourseContentTopic update(Long id, CourseContentTopic topic) {
        CourseContentTopic existing = topicRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Topic not found"));

        // ✅ FIXED: correct getter
        existing.setTitle(topic.getTitle());

        return topicRepo.save(existing);
    }

    @Override
    public void delete(Long id) {
        if (!topicRepo.existsById(id)) {
            throw new ResponseStatusException(NOT_FOUND, "Topic not found");
        }
        topicRepo.deleteById(id);
    }
}
