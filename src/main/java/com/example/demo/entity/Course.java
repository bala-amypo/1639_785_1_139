// // // package com.example.demo.entity;
// // // import jakarta.persistence.Column;
// // // import jakarta.persistence.Entity;
// // // import jakarta.persistence.Id;
// // // import jakarta.persistence.JoinColumn;
// // // import jakarta.persistence.OneToOne;
// // // import lombok.AllArgsConstructor;
// // // import lombok.Data;
// // // import lombok.NoArgsConstructor;
// // // import jakarta.persistence.GeneratedValue;
// // // import jakarta.persistence.GenerationType;

// // // @Entity
// // // @Data
// // // @NoArgsConstructor
// // // @AllArgsConstructor
// // // public class Course{
// // //     @Id
// // //     @GeneratedValue(strategy=GenerationType.IDENTITY)
// // //     @Column(name="column_id",unique=true)
// // //     private Long id;
// // //     @OneToOne
// // //     @JoinColumn(name="university_id",nullable=false)
// // //     private University university;
// // //     private String courseCode;
// // //     private String courseName;
// // //     private String description;
// // //     private String department;
// // //     private Integer creditHours;
// // //     private Boolean active =true;
// // // }
package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String courseCode;
    private String courseName;
    private int creditHours;
    private boolean active = true;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "university_id")
    private University university;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CourseContentTopic> topics;
}