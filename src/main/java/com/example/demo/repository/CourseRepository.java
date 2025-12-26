package com.example.demo.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.Course;


@Repository
public interface CourseRepository extends JpaRepository<Course,Long>{

}
