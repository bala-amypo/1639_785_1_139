// package com.example.demo.entity;
// import java.time.LocalDateTime;
// // import java.util.*;

// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.OneToOne;
// import jakarta.validation.constraints.NotBlank;
// import lombok.AllArgsConstructor;
// import lombok.Data;
// import lombok.NoArgsConstructor;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;


// @Entity
// @Data
// @NoArgsConstructor
// @AllArgsConstructor
// public class TransferEvaluationResult{
//     @Id
//     @GeneratedValue(strategy=GenerationType.IDENTITY)
//     @Column(name="name",unique=true)
//     private Long id;
//     @OneToOne
//     @JoinColumn(name="sourceCourse_id",nullable=false)
//     private Course sourceCourse;
//     @OneToOne
//     @JoinColumn(name="targetCourse_id",nullable=false)
//     private Course targetCourse;
//     private Double overlapPercentage;
//     private Integer creditHourDifference;
//     private Boolean isEligibleForTransfer;
//     private LocalDateTime evaluatedAt;
//     @NotBlank(message="Evaluation reason is required")
//     private String notes;


// }
package com.example.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransferEvaluationResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "source_course_id", referencedColumnName = "id", nullable = false)
    private Course sourceCourse;

    @OneToOne
    @JoinColumn(name = "target_course_id", referencedColumnName = "id", nullable = false)
    private Course targetCourse;

    private Double overlapPercentage;
    private Integer creditHourDifference;
    private Boolean isEligibleForTransfer;
    private LocalDateTime evaluatedAt;

    @NotBlank(message = "Evaluation reason is required")
    private String notes;
}
