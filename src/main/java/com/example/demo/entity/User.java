// package com.example.demo.entity;

// import jakarta.persistence.*;
// import java.util.Set;
// import java.util.HashSet;

// @Entity
// @Table(name = "users")
// public class User {
    
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @Column(unique = true, nullable = false, length = 50)
//     private String username;

//     @Column(unique = true, length = 100)
//     private String email;

//     @Column(nullable = false, length = 500)
//     private String password;

//     @Column(nullable = false, length = 255)
//     private String roles = "ROLE_USER";

//     // ✅ Default constructor (JPA requirement)
//     public User() {}

//     // ✅ Test constructor
//     public User(String username, String email, Set<String> roles) {
//         this.username = username;
//         this.email = email;
//         this.roles = String.join(",", roles);
//     }

//     // ✅ ALL GETTERS
//     public Long getId() { return id; }
//     public String getUsername() { return username; }
//     public String getEmail() { return email; }
//     public String getPassword() { return password; }
//     public String getRoles() { return roles; }

//     // ✅ ALL SETTERS
//     public void setId(Long id) { this.id = id; }
//     public void setUsername(String username) { this.username = username; }
//     public void setEmail(String email) { this.email = email; }
//     public void setPassword(String password) { this.password = password; }
//     public void setRoles(String roles) { this.roles = roles; }
// }










package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = true)
    private String email;
    private String password;
    private String role = "AGENT";

    public User() {}

    public User(String name, String email, String password, String role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = (role == null) ? "AGENT" : role;
    }

    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}