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
// // package com.example.demo.entity;

// // public class Course {
// //     private Long id;
// //     private String courseCode;
// //     private String courseName;
// //     private int creditHours;
// //     private boolean active = true;
// //     private University university;

// //     public Long getId() { return id; }
// //     public void setId(Long id) { this.id = id; }

// //     public String getCourseCode() { return courseCode; }
// //     public void setCourseCode(String courseCode) { this.courseCode = courseCode; }

// //     public String getCourseName() { return courseName; }
// //     public void setCourseName(String courseName) { this.courseName = courseName; }

// //     public int getCreditHours() { return creditHours; }
// //     public void setCreditHours(int creditHours) { this.creditHours = creditHours; }

// //     public boolean isActive() { return active; }
// //     public void setActive(boolean active) { this.active = active; }

// //     public University getUniversity() { return university; }
// //     public void setUniversity(University university) { this.university = university; }
// // }
// package com.example.demo.entity;

// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.Table;
// import jakarta.persistence.Column;

// @Entity
// @Table(name = "course")
// public class Course {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @Column(nullable = false)
//     private String courseName;

//     private String description;

//     // ✅ REQUIRED BY JPA
//     public Course() {
//     }

//     // getters & setters
//     public Long getId() {
//         return id;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public String getCourseName() {
//         return courseName;
//     }

//     public void setCourseName(String courseName) {
//         this.courseName = courseName;
//     }

//     public String getDescription() {
//         return description;
//     }

//     public void setDescription(String description) {
//         this.description = description;
//     }
// }
package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "university_id")
    private University university;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<CourseContentTopic> topics;

    @OneToMany(mappedBy = "sourceCourse", cascade = CascadeType.ALL)
    private List<TransferEvaluationResult> evaluationResults;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public University getUniversity() { return university; }
    public void setUniversity(University university) { this.university = university; }

    public List<CourseContentTopic> getTopics() { return topics; }
    public void setTopics(List<CourseContentTopic> topics) { this.topics = topics; }

    public List<TransferEvaluationResult> getEvaluationResults() { return evaluationResults; }
    public void setEvaluationResults(List<TransferEvaluationResult> evaluationResults) { this.evaluationResults = evaluationResults; }
}
