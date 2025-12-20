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
public class University{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="name",unique=true)
    private Long id;
    @OneToOne
    @JoinColumn(name="university_id",nullable=false)
    private University university;
    private String courseCode;
    private String courseName;
    private String description;
    private String department;
    private Integer creditHours;
    private Boolean active =true;


}