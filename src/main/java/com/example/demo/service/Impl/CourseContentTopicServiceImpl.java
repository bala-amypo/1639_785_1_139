package com.example.demo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;   
import com.example.demo.entity.CourseContentTopic;
import com.example.demo.repository.CourseContentTopicRepository;
// import org.springframework.web.bind.annotation.PathVariable;
import com.example.demo.service.CourseContentTopicService;                

@Service
public class CourseContentTopicServiceImpl implements CourseContentTopicService{

    @Autowired CourseContentTopicRepository used;
    @Override
    public CourseContentTopic createTopic(CourseContentTopic topic){
        return used.save(topic);  
    }
    @Override
    public List<CourseContentTopic>getAllData2(){
        return used.findAll();
    }
    @Override
    public String DeleteData2(Long id){
        used.deleteById(id);
        return "Deleted successfully";
    }
    @Override
    public CourseContentTopic getTopicById(Long id){
    return used.findById(id).orElse(null);
    }
    @Override
    public CourseContentTopic updateTopic(Long id,CourseContentTopic topic){
        if(used.existsById(id)){
            topic.setId(id);
            return used.save(topic);
        } 
        return null;
    }
}
// package com.example.demo.service.impl;

// import java.util.List;
// import java.util.Optional;

// import org.springframework.stereotype.Service;
// import org.springframework.beans.factory.annotation.Autowired;

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
//     public CourseContentTopic getTopicById(Long id) {
//         return repo.findById(id)
//                 .orElseThrow(() -> new RuntimeException("CourseContentTopic not found with id: " + id));
//     }

//     @Override
//     public List<CourseContentTopic> getAllData2() {
//         return repo.findAll();
//     }

//     @Override
//     public CourseContentTopic updateTopic(Long id, CourseContentTopic topic) {
//         CourseContentTopic existing = repo.findById(id)
//                 .orElseThrow(() -> new RuntimeException("CourseContentTopic not found with id: " + id));
        
//         existing.setCourse(topic.getCourse());
//         existing.setTopicName(topic.getTopicName());
//         existing.setWeightPercentage(topic.getWeightPercentage());
        
//         return repo.save(existing);
//     }

//     @Override
//     public String DeleteData2(Long id) {
//         CourseContentTopic existing = repo.findById(id)
//                 .orElseThrow(() -> new RuntimeException("CourseContentTopic not found with id: " + id));
//         repo.deleteById(id);
//         return "Deleted Successfully!";
//     }
// }
