package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.User;
import com.example.demo.service.AuthService;



@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired

    // Register
    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return authService.register(user);
    }

    // Login
    @PostMapping("/login")
    public User login(@RequestParam String email,
                      @RequestParam String password) {
        return authService.login(email, password);
    }

    // Get by ID
    @GetMapping("/{id}")
    public User getById(@PathVariable Long id) {
        return authService.getData6(id);
    }

    // Get all
    @GetMapping
    public List<User> getAll() {
        return authService.getAllData6();
    }

    // Update
    @PutMapping("/{id}")
    public User update(@PathVariable Long id,
                       @RequestBody User user) {
        return authService.updateData6(id, user);
    }

    // Delete
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        return authService.DeleteData6(id);
    }
}