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

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.User;
import com.example.demo.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        return ResponseEntity.ok(authService.register(user));
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestParam String email, @RequestParam String password) {
        return ResponseEntity.ok(authService.login(email, password));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<User> getById(@PathVariable Long id) {
        return ResponseEntity.ok(authService.getData6(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.ok(authService.getAllData6());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User user) {
        return ResponseEntity.ok(authService.updateData6(id, user));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        return ResponseEntity.ok(authService.DeleteData6(id));
    }
}
