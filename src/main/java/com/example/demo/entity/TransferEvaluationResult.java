// // // package com.example.demo.entity;
// // // import java.time.LocalDateTime;
// // // // import java.util.*;

// // // import jakarta.persistence.Column;
// // // import jakarta.persistence.Entity;
// // // import jakarta.persistence.Id;
// // // import jakarta.persistence.JoinColumn;
// // // import jakarta.persistence.OneToOne;
// // // import jakarta.validation.constraints.NotBlank;
// // // import lombok.AllArgsConstructor;
// // // import lombok.Data;
// // // import lombok.NoArgsConstructor;
// // // import jakarta.persistence.GeneratedValue;
// // // import jakarta.persistence.GenerationType;


// // // @Entity
// // // @Data
// // // @NoArgsConstructor
// // // @AllArgsConstructor
// // // public class TransferEvaluationResult{
// // //     @Id
// // //     @GeneratedValue(strategy=GenerationType.IDENTITY)
// // //     @Column(name="name",unique=true)
// // //     private Long id;
// // //     @OneToOne
// // //     @JoinColumn(name="sourceCourse_id",nullable=false)
// // //     private Course sourceCourse;
// // //     @OneToOne
// // //     @JoinColumn(name="targetCourse_id",nullable=false)
// // //     private Course targetCourse;
// // //     private Double overlapPercentage;
// // //     private Integer creditHourDifference;
// // //     private Boolean isEligibleForTransfer;
// // //     private LocalDateTime evaluatedAt;
// // //     @NotBlank(message="Evaluation reason is required")
// // //     private String notes;


// // // }
// // package com.example.demo.entity;

// // public class TransferEvaluationResult {
// //     private Long id;
// //     private Boolean isEligibleForTransfer;
// //     private Double overlapPercentage;
// //     private String notes;

// //     public Long getId() { return id; }
// //     public void setId(Long id) { this.id = id; }

// //     public Boolean getIsEligibleForTransfer() { return isEligibleForTransfer; }
// //     public void setIsEligibleForTransfer(Boolean eligible) { this.isEligibleForTransfer = eligible; }

// //     public Double getOverlapPercentage() { return overlapPercentage; }
// //     public void setOverlapPercentage(Double overlapPercentage) { this.overlapPercentage = overlapPercentage; }

// //     public String getNotes() { return notes; }
// //     public void setNotes(String notes) { this.notes = notes; }
// // }

// package com.example.demo.entity;

// import jakarta.persistence.Entity;
// import jakarta.persistence.Id;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;

// @Entity
// public class TransferEvaluationResult {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private String result;

//     // other fields, getters, setters
//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }

//     public String getResult() { return result; }
//     public void setResult(String result) { this.result = result; }
// }
package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class TransferEvaluationResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Course sourceCourse;

    @ManyToOne
    private Course targetCourse;

    private Double overlapPercentage;
    private boolean isEligibleForTransfer;
    private String notes;
}