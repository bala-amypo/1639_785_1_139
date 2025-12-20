package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.University;
import com.example.demo.service.UniversityService;

@RestController
@RequestMapping("/api/universities")
public class UniversityController {

    @Autowired
    UniversityService universityService;

    // POST /
    @PostMapping("/")
    public University createUniversity(@RequestBody University university) {
        return universityService.createUniversity(university);
    }

    // PUT /{id}
    @PutMapping("/{id}")
    public University updateUniversity(@PathVariable Long id,
                                       @RequestBody University university) {
        return universityService.updateUniversity(id, university);
    }

    // GET /{id}
    @GetMapping("/{id}")
    public University getUniversityById(@PathVariable Long id) {
        return universityService.getUniversityById(id);
    }

    // GET /
    @GetMapping("/")
    public List<University> getAllUniversities() {
        return universityService.getAllUniversities();
    }

    // PUT /{id}/deactivate
    @PutMapping("/{id}/deactivate")
    public String deactivateUniversity(@PathVariable Long id) {
        universityService.deactivateUniversity(id);
        return "University deactivated";
    }
}