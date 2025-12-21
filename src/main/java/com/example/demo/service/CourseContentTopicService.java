package com.example.demo.service;

import java.util.List;
import com.example.demo.model.User;

public interface CourseContentService{
    CourseContent postData2(CourseContent use);
    User postdata2(User log);
    List<User>getAllData2();
    String  DeleteData2(Long id);
    User getData2(Long id);         
    User updateData2(Long id,User entity);                                                        
}