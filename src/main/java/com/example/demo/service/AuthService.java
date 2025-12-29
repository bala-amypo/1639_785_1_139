// package com.example.demo.service;

// import com.example.demo.entity.User;
// import java.util.List;

// public interface  AuthService{
//     User register(User user);
//     User login(String email,String password);
//     User getData6(Long id); 
//     List<User>getAllData6();
//     User updateData6(Long id,User use);
//     String  DeleteData6(Long id);

// }




package com.example.demo.service;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.dto.RegisterRequest;

public interface AuthService {

    String register(RegisterRequest request);

    AuthResponse login(AuthRequest request);
}
    