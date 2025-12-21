// package com.example.demo.controller;

// import java.util.*;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import com.example.demo.entity.TransferEvaluationResult;
// import com.example.demo.service.TransferEvaluationService;
// import jakarta.validation.Valid;

// @RequestMapping("/TransferEvaluationResult")
// @RestController
// public class TransferEvaluationResultController{
//     @Autowired  TransferEvaluationService ser;
//     @PostMapping("/post")
//     public TransferEvaluationResult sendData(@RequestBody TransferEvaluationResult stu){
//         return ser.postData4(stu);
//     }
//     @GetMapping("/get")
//     public List<TransferEvaluationResult> getval(){
//         return ser.getAllData4();
//     }
//     @DeleteMapping("/delete/{id}")
//     public String del(@PathVariable Long id){
//         return ser.DeleteData4(id);
//     }
//     @GetMapping("/find/{id}")
//     public TransferEvaluationResult find(@PathVariable Long id){
//         return ser.getEvaluationById(id);
//     }
//     @PutMapping("/put/{id}")
//     public TransferEvaluationResult putval(@PathVariable Long id,@RequestBody TransferEvaluationResult entity){
//         return ser.updateData4(id,entity);
//     }
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
