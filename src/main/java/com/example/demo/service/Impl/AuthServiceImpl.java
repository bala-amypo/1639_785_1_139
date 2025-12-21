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
//     return userRepository.findById(id).orElseThrow(()-> new RuntimeException("not found"));
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
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User register(User user) {
        // You might want to hash the password here before saving
        return userRepository.save(user);
    }

    @Override
    public User login(String email, String password) {
        Optional<User> userOpt = userRepository.findByEmail(email);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            if (user.getPassword().equals(password)) { // simple check, consider hashing in real apps
                return user;
            }
        }
        return null; // or throw exception for invalid login
    }

    @Override
    public User getData6(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<User> getAllData6() {
        return userRepository.findAll();
    }

    @Override
    public User updateData6(Long id, User use) {
        Optional<User> existing = userRepository.findById(id);
        if (existing.isPresent()) {
            User user = existing.get();
            user.setName(use.getName());
            user.setEmail(use.getEmail());
            user.setPassword(use.getPassword());
            // update other fields as needed
            return userRepository.save(user);
        }
        return null;
    }

    @Override
    public String DeleteData6(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return "User deleted successfully";
        } else {
            return "User not found";
        }
    }
}
