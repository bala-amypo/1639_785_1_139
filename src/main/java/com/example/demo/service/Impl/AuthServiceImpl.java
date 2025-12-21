package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User register(User user) {
        userRepository.save(user);
        return null;
    }

    @Override
    public User login(String email, String password) {
        return null;
    }
    @Override
    public List<User>getAllData6(){
        return userRepository.findAll();
    }
    @Override
    public User getData6(Long id){
    return userRepository.findById(id).orElseThrow(()-> new RuntimeException("not found"));
    }
    @Override
    public User updateData6(Long id,User use){
        if(userRepository.existsById(id)){
            use.setId(id);
            return userRepository.save(use);
        } 
        return null;
    }
    @Override
    public String DeleteData6(Long id){
        userRepository.deleteById(id);
        return "Deleted successfully";
    }
}