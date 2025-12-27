// package com.example.demo.controller;

// import java.util.List;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.*;
// import com.example.demo.entity.User;
// import com.example.demo.service.AuthService;



// @RestController
// @RequestMapping("/auth")
// public class AuthController {
//     @Autowired AuthService authService;
//     @PostMapping("/register")
//     public User register(@RequestBody User user) {
//         return authService.register(user);
//     }

//     @PostMapping("/login")
//     public User login(@RequestParam String email,
//                       @RequestParam String password) {
//         return authService.login(email, password);
//     }

//     @GetMapping("/{id}")
//     public User getById(@PathVariable Long id) {
//         return authService.getData6(id);
//     }

//     @GetMapping
//     public List<User> getAll() {
//         return authService.getAllData6();
//     }

//     @PutMapping("/{id}")
//     public User update(@PathVariable Long id,
//                        @RequestBody User user) {
//         return authService.updateData6(id, user);
//     }

//     @DeleteMapping("/{id}")
//     public String delete(@PathVariable Long id) {
//         return authService.DeleteData6(id);
//     }
// }



package com.example.demo.controller;

import com.example.demo.security.JwtTokenProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthController {
    
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    public AuthController(AuthenticationManager authenticationManager, 
                         JwtTokenProvider jwtTokenProvider,
                         PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.passwordEncoder = passwordEncoder;
    }

    // ✅ LOGIN - Existing endpoint
    @PostMapping("/auth/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody LoginRequest request) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.username, request.password)
        );
        
        String token = jwtTokenProvider.generateToken(request.username);
        
        Map<String, String> response = new HashMap<>();
        response.put("token", token);
        response.put("message", "Login successful");
        
        return ResponseEntity.ok(response);
    }

    // ✅ NEW REGISTER endpoint
    @PostMapping("/auth/register")
    public ResponseEntity<Map<String, String>> register(@RequestBody RegisterRequest request) {
        // In real app: Save to database with encoded password
        // For demo: Just encode and return token
        
        String encodedPassword = passwordEncoder.encode(request.password);
        
        Map<String, String> response = new HashMap<>();
        response.put("token", jwtTokenProvider.generateToken(request.username));
        response.put("message", "User registered successfully");
        response.put("encodedPassword", encodedPassword); // Remove in production
        
        return ResponseEntity.ok(response);
    }

    // ✅ Login DTO
    static class LoginRequest {
        public String username;
        public String password;
    }

    // ✅ Register DTO
    static class RegisterRequest {
        public String username;
        public String password;
    }
}
