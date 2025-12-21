// package com.example.demo.entity;
// import java.time.LocalDateTime;
// import java.util.*;
// // import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.Id;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import lombok.Data;
// import lombok.AllArgsConstructor;
// import lombok.NoArgsConstructor;

// @Entity
// @Data
// @NoArgsConstructor
// @AllArgsConstructor
// public class User{
//     @Id
//     @GeneratedValue(strategy=GenerationType.IDENTITY)
//     // @Column(name="email",unique=true)
//     private Long id;
//     private String email;
//     private String password;
//     private Set<String> roles;
//     private LocalDateTime createdAt;

// }
package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String password;
}
