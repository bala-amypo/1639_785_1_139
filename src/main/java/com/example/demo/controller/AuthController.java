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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.util.Set;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    private JwtTokenProvider jwtProvider;

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        userRepo.findByEmail(user.getEmail()).ifPresent(u -> {
            throw new IllegalArgumentException("Email already exists");
        });
        user.setPassword(encoder.encode(user.getPassword()));
        if (user.getRoles() == null || user.getRoles().isEmpty()) {
            user.setRoles(Set.of("ROLE_USER"));
        }
        userRepo.save(user);
        return "User registered successfully";
    }

    @PostMapping("/login")
    public String login(@RequestBody User loginRequest) {
        User user = userRepo.findByEmail(loginRequest.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid credentials"));

        if (!encoder.matches(loginRequest.getPassword(), user.getPassword())) {
            throw new IllegalArgumentException("Invalid credentials");
        }

        return jwtProvider.createToken(user.getId(), user.getEmail(), user.getRoles());
    }
}