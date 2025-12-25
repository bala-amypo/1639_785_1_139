// // package com.example.demo.repository;
// // import org.springframework.stereotype.Repository;
// // import org.springframework.data.jpa.repository.JpaRepository;
// // import com.example.demo.entity.University;


// // @Repository
// // public interface UniversityRepository extends JpaRepository<University,Long>{

// // }

// // package com.example.demo.repository;

// // import org.springframework.stereotype.Repository;
// // import org.springframework.data.jpa.repository.JpaRepository;
// // import java.util.Optional;
// // import com.example.demo.entity.University;

// // @Repository
// // public interface UniversityRepository extends JpaRepository<University, Long> {

// //     Optional<University> findByName(String name);
// // }
// package com.example.demo.repository;

// import java.util.List;
// import org.springframework.data.jpa.repository.JpaRepository;
// import com.example.demo.entity.CourseContentTopic;

// public interface CourseContentTopicRepository
//         extends JpaRepository<CourseContentTopic, Long> {

//     List<CourseContentTopic> findByCourseId(Long courseId);
// }
package com.example.demo.repository;

import com.example.demo.entity.University;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UniversityRepository extends JpaRepository<University, Long> {
    Optional<University> findByName(String name);
}