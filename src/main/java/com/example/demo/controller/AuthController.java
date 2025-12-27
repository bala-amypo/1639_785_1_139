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

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.JwtTokenProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AuthController {
    
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public AuthController(AuthenticationManager authenticationManager, 
                         JwtTokenProvider jwtTokenProvider,
                         PasswordEncoder passwordEncoder,
                         UserRepository userRepository) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @PostMapping("/auth/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody LoginRequest request) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.username, request.password)
        );
        String token = jwtTokenProvider.generateToken(request.username);
        return ResponseEntity.ok(Map.of("token", token, "message", "Login successful"));
    }

    @PostMapping("/auth/register")
    public ResponseEntity<Map<String, String>> register(@RequestBody RegisterRequest request) {
        if (userRepository.findByUsername(request.username).isPresent()) {
            return ResponseEntity.badRequest()
                .body(Map.of("error", "User already exists"));
        }
        
        User user = new User();
        user.setUsername(request.username);
        user.setEmail(request.email);
        user.setPassword(passwordEncoder.encode(request.password));
        user.setRoles("ROLE_USER");
        
        userRepository.save(user);
        
        String token = jwtTokenProvider.generateToken(request.username);
        return ResponseEntity.ok(Map.of("token", token, "message", "Registered successfully"));
    }

    static class LoginRequest {
        public String username;
        public String password;
    }

    static class RegisterRequest {
        public String username;
        public String email;
        public String password;
    }
}
