

// package com.example.demo.controller;

// import com.example.demo.entity.User;
// import com.example.demo.security.JwtTokenProvider;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.authentication.BadCredentialsException;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.Authentication;
// import org.springframework.security.core.context.SecurityContextHolder;
// import org.springframework.web.bind.annotation.*;

// import java.util.Map;

// @RestController
// @RequestMapping("/auth")
// public class AuthController {

//     @Autowired
//     private AuthenticationManager authenticationManager;
    
//     @Autowired
//     private JwtTokenProvider jwtTokenProvider;

//     @PostMapping("/register")
//     public ResponseEntity<?> register(@RequestBody User user) {
//         return ResponseEntity.ok(user);
//     }

//     @PostMapping("/login")
//     public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
//         try {
//             Authentication authentication = authenticationManager.authenticate(
//                 new UsernamePasswordAuthenticationToken(
//                     loginRequest.getEmail(), 
//                     loginRequest.getPassword()
//                 )
//             );
            
//             SecurityContextHolder.getContext().setAuthentication(authentication);
//             String jwt = jwtTokenProvider.generateToken(authentication.getName());
            
//             return ResponseEntity.ok(Map.of("token", jwt));
            
//         } catch (BadCredentialsException e) {
//             return ResponseEntity.status(401)
//                 .body(Map.of("error", "Invalid email or password"));
//         } catch (Exception e) {
//             return ResponseEntity.status(400)
//                 .body(Map.of("error", "Login failed"));
//         }
//     }

//     public static class LoginRequest {
//         private String email;
//         private String password;
        
//         public String getEmail() { return email; }
//         public void setEmail(String email) { this.email = email; }
//         public String getPassword() { return password; }
//         public void setPassword(String password) { this.password = password; }
//     }
// }




package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<Map<String, Object>> register(@Valid @RequestBody User user) {
        try {
            Map<String, Object> response = new HashMap<>();
            response.put("message", "User registered successfully");
            response.put("userId", user.getId());
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Map.of("error", "Registration failed"));
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@Valid @RequestBody LoginRequest loginRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                    loginRequest.getEmail().toLowerCase(), 
                    loginRequest.getPassword()
                )
            );
            
            SecurityContextHolder.getContext().setAuthentication(authentication);
            
            // FIXED: Uses authentication.getName() which returns String (email)
            String jwt = jwtTokenProvider.generateToken(authentication.getName());
            
            Map<String, Object> response = new HashMap<>();
            response.put("token", jwt);
            response.put("message", "Login successful");
            
            return ResponseEntity.ok(response);
            
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(Map.of("error", "Invalid email or password"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Map.of("error", "Login failed"));
        }
    }
}
