package com.example.demo.entity;
// import java.util.*;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseContentTopic{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="column_id",unique=true)
    private Long id;
    @OneToOne
    @JoinColumn(name="course_id",nullable=false)
    private Course course;
    @NotBlank(message="Topic name")
    private String topicName;
    @Size(min=0,max=100,message="0-100")
    private Double weightPercentage;
}