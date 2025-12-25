// // package com.example.demo.entity;
// // // import java.util.*;

// // import jakarta.persistence.Column;
// // import jakarta.persistence.Entity;
// // import jakarta.persistence.Id;
// // import jakarta.persistence.JoinColumn;
// // import jakarta.persistence.OneToOne;
// // import jakarta.validation.constraints.NotBlank;
// // import jakarta.validation.constraints.Size;
// // import lombok.AllArgsConstructor;
// // import lombok.Data;
// // import lombok.NoArgsConstructor;
// // import jakarta.persistence.GeneratedValue;
// // import jakarta.persistence.GenerationType;


// // @Entity
// // @Data
// // @NoArgsConstructor
// // @AllArgsConstructor
// // public class CourseContentTopic{
// //     @Id
// //     @GeneratedValue(strategy=GenerationType.IDENTITY)
// //     @Column(name="column_id",unique=true)
// //     private Long id;
// //     @OneToOne
// //     @JoinColumn(name="course_id",nullable=false)
// //     private Course course;
// //     @NotBlank(message="Topic name")
// //     private String topicName;
// //     @Size(min=0,max=100,message="0-100")
// //     private Double weightPercentage;
// // }
// package com.example.demo.entity;

// public class CourseContentTopic {
//     private Long id;
//     private String topicName;
//     private Double weightPercentage;
//     private Course course;

//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }

//     public String getTopicName() { return topicName; }
//     public void setTopicName(String topicName) { this.topicName = topicName; }

//     public Double getWeightPercentage() { return weightPercentage; }
//     public void setWeightPercentage(Double weightPercentage) { this.weightPercentage = weightPercentage; }

//     public Course getCourse() { return course; }
//     public void setCourse(Course course) { this.course = course; }
// }
package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "course_content_topic")
public class CourseContentTopic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String topicName;

    private String description;

    // ✅ REQUIRED: no-args constructor
    public CourseContentTopic() {
    }

    // getters & setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
