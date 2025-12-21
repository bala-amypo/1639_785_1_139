// package com.example.demo.entity;
// import java.util.*;

// // import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.Id;
// import lombok.AllArgsConstructor;
// import lombok.Data;
// import lombok.NoArgsConstructor;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;


// @Entity
// @Data
// @NoArgsConstructor
// @AllArgsConstructor
// public class University{
//     @Id
//     @GeneratedValue(strategy=GenerationType.IDENTITY)
//     // @Column(name="name",unique=true)
//     private Long id;
//     private String name;
//     private String accreditationLevel;
//     private Set<String> country;
//     private Boolean active=true;
// }
package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "universities")
public class University {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String location;
}
