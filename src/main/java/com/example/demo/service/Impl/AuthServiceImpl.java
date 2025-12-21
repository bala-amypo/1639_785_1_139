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

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public User register(User user) {
        return userRepo.save(user);
    }

    @Override
    public User login(String email, String password) {
        return userRepo.findByEmailAndPassword(email, password)
                .orElseThrow(() -> new RuntimeException("Invalid email or password"));
    }

    @Override
    public User getData6(Long id) {
        return userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    @Override
    public List<User> getAllData6() {
        return userRepo.findAll();
    }

    @Override
    public User updateData6(Long id, User use) {
        User existingUser = userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

        existingUser.setName(use.getName());
        existingUser.setEmail(use.getEmail());
        existingUser.setPassword(use.getPassword());
        existingUser.setRole(use.getRole());

        return userRepository.save(existingUser);
    }

    @Override
    public String DeleteData6(Long id) {
        User existingUser = userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        userRepo.delete(existingUser);
        return "User deleted successfully with id: " + id;
    }
}
