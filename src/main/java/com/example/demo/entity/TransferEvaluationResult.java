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

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "transfer_evaluation_result")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransferEvaluationResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "source_course_id", nullable = false, unique = true)
    private Course sourceCourse;

    @OneToOne
    @JoinColumn(name = "target_course_id", nullable = false, unique = true)
    private Course targetCourse;

    @Column(name = "overlap_percentage")
    private Double overlapPercentage;

    @Column(name = "credit_hour_difference")
    private Integer creditHourDifference;

    @Column(name = "is_eligible_for_transfer")
    private Boolean isEligibleForTransfer;

    @Column(name = "evaluated_at", updatable = false)
    private LocalDateTime evaluatedAt;

    @Column(length = 500)
    private String notes;
    @PrePersist
    protected void onCreate() {
        this.evaluatedAt = LocalDateTime.now();
    }
}
