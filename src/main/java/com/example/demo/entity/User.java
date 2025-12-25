// // package com.example.demo.entity;
// // import java.time.LocalDateTime;
// // import java.util.*;
// // // import jakarta.persistence.Column;
// // import jakarta.persistence.Entity;
// // import jakarta.persistence.Id;
// // import jakarta.persistence.GeneratedValue;
// // import jakarta.persistence.GenerationType;
// // import lombok.Data;
// // import lombok.AllArgsConstructor;
// // import lombok.NoArgsConstructor;

// // @Entity
// // @Data
// // @NoArgsConstructor
// // @AllArgsConstructor
// // public class User{
// //     @Id
// //     @GeneratedValue(strategy=GenerationType.IDENTITY)
// //     // @Column(name="email",unique=true)
// //     private Long id;
// //     private String email;
// //     private String password;
// //     private Set<String> roles;
// //     private LocalDateTime createdAt;

// // }
// package com.example.demo.entity;

// import java.util.Set;

// public class User {
//     private Long id;
//     private String email;
//     private String password;
//     private Set<String> roles;

//     public User() {}

//     public User(String email, String password, Set<String> roles) {
//         this.email = email;
//         this.password = password;
//         this.roles = roles;
//     }

//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }

//     public String getEmail() { return email; }
//     public String getPassword() { return password; }
//     public Set<String> getRoles() { return roles; }
// }
package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    private Set<String> roles;
}