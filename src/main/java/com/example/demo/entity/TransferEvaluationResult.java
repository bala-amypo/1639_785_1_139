package com.example.demo.entity;
import java.util.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedType;
import jakarta.persistence.GenerationType;
import lambok.Data;
import lambok.AllArgsConstructor;
import lambok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class University{
    @Id
        @GeneratedValue(strategy=GenerationType.IDENTITY)
            @Column(name="name",unique=true)
                private Long id;
                    @OneToOne
                        @JoinColumn(name="sourceCourse_id",nullable=false)
                            private Course sourceCourse;
                                @OneToOne
                                    @JoinColumn(name="targetCourse_id",nullable=false)
                                        private Course targetCourse;
                                            private Double overlapPercentage;
                                                private Integer creditHourDifference;
                                                    private Boolean isEligibleForTransfer;
                                                        private LocalDateTime evaluatedAt;
                                                            @NotBlank(message="Evaluation reason is required")
                                                                private String notes;


                                                                }