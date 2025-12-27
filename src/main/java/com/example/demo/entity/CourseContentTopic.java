






// package com.example.demo.entity;

// import jakarta.persistence.*;

// @Entity
// public class CourseContentTopic {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private String topicName;

//     private Double weightPercentage;

//     @ManyToOne
//     @JoinColumn(name = "course_id")
//     private Course course;

//     // getters/setters
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

import jakarta.persistence.*;

@Entity
@Table(name = "course_content_topic")
public class CourseContentTopic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "topic_name", nullable = false)
    private String topicName;

    @Column(name = "weight_percentage", nullable = false)
    private Double weightPercentage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course course;

    // Default constructor (JPA requirement)
    public CourseContentTopic() {}

    // getters/setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTopicName() { return topicName; }
    public void setTopicName(String topicName) { this.topicName = topicName; }

    public Double getWeightPercentage() { return weightPercentage; }
    public void setWeightPercentage(Double weightPercentage) { this.weightPercentage = weightPercentage; }

    public Course getCourse() { return course; }
    public void setCourse(Course course) { this.course = course; }
}
