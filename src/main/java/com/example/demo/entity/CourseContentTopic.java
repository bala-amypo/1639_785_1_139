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
    @JoinColumn(name="course_id",nullable=false)
    private Course course;
    @NotBlank(message="Topic name")
    private String topicName;
    @Size(min=0,max=100,message="0-100")
    private Double weightPercentage;
}