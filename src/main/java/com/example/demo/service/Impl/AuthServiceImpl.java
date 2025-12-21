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
        // Registration logic handled via Controller/Service
        userRepository.save(user);
        return null;
    }

    @Override
    public User login(String email, String password) {
        // Login logic handled via Controller/Service
        return null;
    }
}