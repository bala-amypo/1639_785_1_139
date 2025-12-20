package com.example.demo.entity;
import java.util.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedType;
import jakarta.persistence.GenerationType;
import lambok.Data;
import lambok.AllArgsConstructor;
import lambok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="name",unique=true)
    private Long id;
    private String name;
    private String password;
    private Set<String> roles;
    private LocalDateTime createdAt;

}