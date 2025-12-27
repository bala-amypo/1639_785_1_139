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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;

    public AuthController(AuthenticationManager authenticationManager, 
                         JwtTokenProvider jwtTokenProvider) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping("/auth/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.username, request.password)
        );
        String token = jwtTokenProvider.generateToken(request.username);
        return ResponseEntity.ok(token);
    }

    static class LoginRequest {
        public String username;
        public String password;
    }
}
