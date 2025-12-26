// package com.example.demo.repository;
// import org.springframework.stereotype.Repository;
// import org.springframework.data.jpa.repository.JpaRepository;
// import com.example.demo.entity.Course;


// @Repository
// public interface CourseRepository extends JpaRepository<Course,Long>{

// }

package com.example.demo.repository;

import com.example.demo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {

    java.util.Optional<Course> findByUniversityIdAndCourseCode(Long universityId, String courseCode);

    java.util.List<Course> findByUniversityIdAndActiveTrue(Long universityId);
}
