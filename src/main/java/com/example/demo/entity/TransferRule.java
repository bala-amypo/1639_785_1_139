// // package com.example.demo.entity;
// // // import java.util.*;

// // // import jakarta.persistence.Column;
// // import jakarta.persistence.Entity;
// // import jakarta.persistence.Id;
// // import jakarta.persistence.JoinColumn;
// // import jakarta.persistence.OneToOne;
// // import lombok.AllArgsConstructor;
// // import lombok.Data;
// // import lombok.NoArgsConstructor;
// // // import jakarta.persistence.GeneratedType;
// // import jakarta.persistence.GeneratedValue;
// // import jakarta.persistence.GenerationType;


// // @Entity
// // @Data
// // @NoArgsConstructor
// // @AllArgsConstructor
// // public class TransferRule{
// //     @Id
// //     @GeneratedValue(strategy=GenerationType.IDENTITY)
// //     // @Column(name="name",unique=true)
// //     private Long id;
// //     @OneToOne
// //     @JoinColumn(name="sourceUniversity_id",nullable=false)
// //     private University sourceUniversity;
// //     @OneToOne
// //     @JoinColumn(name="targetUniversity_id",nullable=false)
// //     private University targetUniversity;
// //     private Double minimumOverlapPercentage;
// //     private Integer creditHourTolerance;
// //     private Boolean active=true;
// // }
// package com.example.demo.entity;

// public class TransferRule {
//     private Long id;
//     private University sourceUniversity;
//     private University targetUniversity;
//     private Double minimumOverlapPercentage;
//     private Integer creditHourTolerance;
//     private boolean active = true;

//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }

//     public University getSourceUniversity() { return sourceUniversity; }
//     public void setSourceUniversity(University sourceUniversity) { this.sourceUniversity = sourceUniversity; }

//     public University getTargetUniversity() { return targetUniversity; }
//     public void setTargetUniversity(University targetUniversity) { this.targetUniversity = targetUniversity; }

//     public Double getMinimumOverlapPercentage() { return minimumOverlapPercentage; }
//     public void setMinimumOverlapPercentage(Double minimumOverlapPercentage) { this.minimumOverlapPercentage = minimumOverlapPercentage; }

//     public Integer getCreditHourTolerance() { return creditHourTolerance; }
//     public void setCreditHourTolerance(Integer creditHourTolerance) { this.creditHourTolerance = creditHourTolerance; }

//     public boolean isActive() { return active; }
//     public void setActive(boolean active) { this.active = active; }
// }

package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class TransferRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ruleName;

    private String description;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getRuleName() { return ruleName; }
    public void setRuleName(String ruleName) { this.ruleName = ruleName; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
