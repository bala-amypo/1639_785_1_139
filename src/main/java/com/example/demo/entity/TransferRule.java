package com.example.demo.entity;
// import java.util.*;

// import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
// import jakarta.persistence.GeneratedType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransferRule{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    // @Column(name="name",unique=true)
    private Long id;
    @OneToOne
    @JoinColumn(name="sourceUniversity_id",nullable=false)
    private University sourceUniversity;
    @OneToOne
    @JoinColumn(name="targetUniversity_id",nullable=false)
    private University targetUniversity;
    private Double minimumOverlapPercentage;
    private Integer creditHourTolerance;
    private Boolean active=true;
}