// // package com.example.demo.repository;
// // import org.springframework.stereotype.Repository;
// // import org.springframework.data.jpa.repository.JpaRepository;
// // import com.example.demo.entity.CourseContentTopic;


// // @Repository
// // public interface CourseContentTopicRepository extends JpaRepository<CourseContentTopic,Long>{

// // }
// package com.example.demo.repository;

// import org.springframework.stereotype.Repository;
// import org.springframework.data.jpa.repository.JpaRepository;
// import java.util.List;
// import com.example.demo.entity.CourseContentTopic;

// @Repository
// public interface CourseContentTopicRepository extends JpaRepository<CourseContentTopic, Long> {

//     List<CourseContentTopic> findByCourseId(Long courseId);
// }
package com.example.demo.repository;

import com.example.demo.entity.CourseContentTopic;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CourseContentTopicRepository extends JpaRepository<CourseContentTopic, Long> {
    List<CourseContentTopic> findByCourseId(Long courseId);
}