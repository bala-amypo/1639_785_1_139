// package com.example.demo.service;

// import java.util.List;
// import com.example.demo.entity.CourseContentTopic;

// public interface CourseContentTopicService{
//     CourseContentTopic createTopic(CourseContentTopic topic);
//     CourseContentTopic getTopicById(Long id); 
//     List<CourseContentTopic>getAllData2();
//     CourseContentTopic updateTopic(Long id,CourseContentTopic topic);
//     String  DeleteData2(Long id);                                                                
// }
package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.CourseContentTopic;

public interface CourseContentTopicService {

    CourseContentTopic postData2(CourseContentTopic topic);

    List<CourseContentTopic> getAllData2();

    CourseContentTopic getById(Long id);

    CourseContentTopic updateData2(Long id, CourseContentTopic topic);

    String DeleteData2(Long id);
}
