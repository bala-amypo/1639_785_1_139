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

public class University {
    private Long id;
    private String name;
    private boolean active = true;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}
