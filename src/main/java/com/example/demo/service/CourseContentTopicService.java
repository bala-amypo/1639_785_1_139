package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.CourseContentTopic;

public interface CourseContentTopicService{
    CourseContentTopic createTopic(CourseContentTopic topic);
    CourseContentTopic getTopicById(Long id); 
    List<CourseContentTopic>getAllData2();
    CourseContentTopic updateTopic(Long id,CourseContentTopic topic);
    String  DeleteData2(Long id);                                                                
}
// package com.example.demo.service;

// import java.util.List;
// import com.example.demo.entity.CourseContentTopic;

// public interface CourseContentTopicService {

//     CourseContentTopic createTopic(CourseContentTopic topic);

//     List<CourseContentTopic> getAllData2();

//     CourseContentTopic getTopicById(Long id);

//     CourseContentTopic updateTopic(Long id, CourseContentTopic topic);

//     String DeleteData2(Long id);
// }
// package com.example.demo.service;

// import java.util.List;
// import com.example.demo.entity.CourseContentTopic;

// public interface CourseContentTopicService {

//     CourseContentTopic create(Long courseId, CourseContentTopic topic);

//     List<CourseContentTopic> getByCourse(Long courseId);

//     CourseContentTopic update(Long id, CourseContentTopic topic);

//     void delete(Long id);
// }
