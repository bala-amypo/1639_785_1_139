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
// import com.example.demo.entity.University;
// import com.example.demo.service.UniversityService;
// import jakarta.validation.Valid;

// @RequestMapping("/University")
// @RestController
// public class UniversityController{
//     @Autowired  UniversityService ser;
//     @PostMapping("/register")
//     public University sendData(@RequestBody University univ){
//         return ser.createUniversity(univ);
//     }
//     @GetMapping("/get")
//     public List<University> getval(){
//         return ser.getAllUniversities();
//     }
//     @GetMapping("/find/{id}")
//     public University find(@PathVariable Long id){
//         return ser.getUniversityById(id);
//     }
//     @PutMapping("/put/{id}")
//     public University putval(@PathVariable Long id,@RequestBody University univ){
//         return ser.updateUniversity(id,univ);
//     }
//     @DeleteMapping("/delete/{id}")
//     public String del(@PathVariable Long id){
//         return ser.DeleteData1(id);
//     }
// }
package com.example.demo.controller;

import com.example.demo.entity.University;
import com.example.demo.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/universities")
public class UniversityController {

    @Autowired
    private UniversityService universityService;

    @PostMapping
    public ResponseEntity<University> createUniversity(@RequestBody University univ) {
        University created = universityService.createUniversity(univ);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<University> updateUniversity(@PathVariable Long id, @RequestBody University univ) {
        University updated = universityService.updateUniversity(id, univ);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<University> getUniversityById(@PathVariable Long id) {
        University university = universityService.getUniversityById(id);
        if (university != null) {
            return ResponseEntity.ok(university);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<University>> getAllUniversities() {
        return ResponseEntity.ok(universityService.getAllUniversities());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUniversity(@PathVariable Long id) {
        String message = universityService.DeleteData1(id);
        return ResponseEntity.ok(message);
    }
}
