package com.example.demo.service;

import java.util.List;
import com.example.demo.model.User;

public interface CourseContentService{
    User postData1(User use);
    User postdata(User log);
    List<User>getAllData1();
    String  DeleteData1(Long id);
    User getData1(Long id);         
    User updateData1(Long id,User entity);                                                        
}