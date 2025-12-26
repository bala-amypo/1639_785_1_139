












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

















// package com.example.demo.controller;

// import org.springframework.web.bind.annotation.*;
// import java.util.List;
// import com.example.demo.entity.University;
// import com.example.demo.service.UniversityService;

// @RestController
// @RequestMapping("/universities")
// public class UniversityController {

//     private final UniversityService universityService;

//     public UniversityController(UniversityService universityService) {
//         this.universityService = universityService;
//     }

//     @PostMapping("/create")
//     public University create(@RequestBody University university) {
//         return universityService.createUniversity(university);
//     }

//     @GetMapping("/{id}")
//     public University getById(@PathVariable Long id) {
//         return universityService.getUniversityById(id);
//     }

//     @GetMapping("/all")
//     public List<University> getAll() {
//         return universityService.getAllUniversities();
//     }

//     @PutMapping("/update/{id}")
//     public University update(@PathVariable Long id, @RequestBody University university) {
//         return universityService.updateUniversity(id, university);
//     }

//     @DeleteMapping("/delete/{id}")
//     public String delete(@PathVariable Long id) {
//         return universityService.deleteData(id);
    // }
// }
package com.example.demo.controller;

import com.example.demo.entity.University;
import com.example.demo.service.UniversityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/universities")
public class UniversityController {

    private final UniversityService ser;

    public UniversityController(UniversityService ser) {
        this.ser = ser;
    }

    @PostMapping
    public University create(@RequestBody University university) {
        return ser.createUniversity(university);
    }

    @GetMapping
    public List<University> getAll() {
        // matches getAllUniversities() in UniversityService
        return ser.getAllUniversities();
    }

    @GetMapping("/{id}")
    public University getById(@PathVariable Long id) {
        return ser.getUniversityById(id);
    }

    @PutMapping("/{id}")
    public University update(@PathVariable Long id, @RequestBody University university) {
        return ser.updateUniversity(id, university);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        // matches DeleteData1(Long) in UniversityService
        ser.DeleteData1(id);
    }
}
