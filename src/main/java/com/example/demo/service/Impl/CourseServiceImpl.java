package com.example.demo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;   
import com.example.demo.entity.Course;
import com.example.demo.repository.CourseRepository;
// import org.springframework.web.bind.annotation.PathVariable;
import com.example.demo.service.CourseService;                

@Service
public class CourseServiceImpl implements CourseService{

    @Autowired CourseRepository repo;
    @Override
    public Course createCourse(Course course){
        return repo.save(course);  
    }
    @Override
    public List<Course>getAllData3(){
        return repo.findAll();
    }
    @Override
    public Course getCourseById(Long id){
    return repo.findById(id).orElse(null);
    }
    @Override
    public Course updateCourse(Long id,Course course){
        if(repo.existsById(id)){
            course.setId(id);
            return repo.save(course);
        } 
        return null;
    }
    @Override
    public String DeleteData3(Long id){
        repo.deleteById(id);
        return "Deleted successfully";
    }
}
