package com.example.demo.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.User;


@Repository
public interface CourseContentTopicRepository extends JpaRepository<User,Long>{

}