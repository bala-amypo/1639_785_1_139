
// package com.example.demo.entity;

// import jakarta.persistence.*;
// import lombok.Data;
// import java.util.Set;

// @Entity
// @Table(name = "users")
// @Data
// public class User {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private String email;
//     private String password;

//     @ElementCollection(fetch = FetchType.EAGER)
//     private Set<String> roles;
// }











// package com.example.demo.entity;

// import jakarta.persistence.*;
// import java.util.Set;

// @Entity
// @Table(name = "user")
// public class User {
    
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;
    
//     @Column(unique = true)
//     private String username;
    
//     @Column
//     private String password;
    
//     // ✅ FIX: Store roles as simple comma-separated string
//     @Column(columnDefinition = "varchar(255) default 'USER'")
//     private String roles = "USER";
    
//     // Getters/Setters
//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }
    
//     public String getUsername() { return username; }
//     public void setUsername(String username) { this.username = username; }
    
//     public String getPassword() { return password; }
//     public void setPassword(String password) { this.password = password; }
    
//     public String getRoles() { return roles; }
//     public void setRoles(String roles) { this.roles = roles; }
// }











package com.example.demo.entity;

import jakarta.persistence.*;

@Entity@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, length = 50)
    private String username;

    @Column(unique = true, length = 100)
    private String email;

    @Column(nullable = false, length = 500)
    private String password;

    @Column(nullable = false, length = 255)
    private String roles = "ROLE_USER";

    public User() {}

    // ✅ ADDED for tests
    public User(String username, String email, Set<String> roles) {
        this.username = username;
        this.email = email;
        this.roles = String.join(",", roles);
    }

    // ... all your existing getters/setters
}
