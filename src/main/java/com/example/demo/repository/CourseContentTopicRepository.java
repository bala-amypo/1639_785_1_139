package com.example.demo.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.CourseContentTopic;


@Repository
public interface CourseContentTopicRepository extends JpaRepository<CourseContentTopic,Long>{

}