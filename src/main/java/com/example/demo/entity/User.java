package com.example.demo.entity;
import java.


@Entity
public class Users{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private Set<String> roles;
    private LocalDateTime createdAt;

}