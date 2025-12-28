// package com.example.demo.service.impl;
// import java.util.*;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.example.demo.entity.User;
// import com.example.demo.repository.UserRepository;
// import com.example.demo.service.AuthService;

// @Service
// public class AuthServiceImpl implements AuthService {

//     @Autowired
//     UserRepository userRepository;

//     @Override
//     public User register(User user) {
//         userRepository.save(user);
//         return null;
//     }

//     @Override
//     public User login(String email, String password) {
//         return null;
//     }
//     @Override
//     public List<User>getAllData6(){
//         return userRepository.findAll();
//     }
//     @Override
//     public User getData6(Long id){
//     return userRepository.findById(id).orElse(null);
//     }
//     @Override
//     public User updateData6(Long id,User use){
//         if(userRepository.existsById(id)){
//             use.setId(id);
//             return userRepository.save(use);
//         } 
//         return null;
//     }
//     @Override
//     public String DeleteData6(Long id){
//         userRepository.deleteById(id);
//         return "Deleted successfully";
//     }
// }










package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User register(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User login(String email, String password) {
        return null;  // Handled by Spring Security
    }

    @Override
    public List<User> getAllData6() {
        return userRepository.findAll();
    }

    @Override
    public User getData6(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User updateData6(Long id, User user) {
        if (userRepository.existsById(id)) {
            user.setId(id);
            if (user.getPassword() != null && !user.getPassword().startsWith("$2a$")) {
                user.setPassword(passwordEncoder.encode(user.getPassword()));
            }
            return userRepository.save(user);
        }
        return null;
    }

    // ✅ FIXED: Capital 'D' to match AuthService interface
    @Override
    public String DeleteData6(Long id) {
        userRepository.deleteById(id);
        return "Deleted successfully";
    }
}
