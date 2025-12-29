

// package com.example.demo.service.impl;
// import java.util.*;
// import com.example.demo.entity.University;
// import com.example.demo.repository.UniversityRepository;
// import com.example.demo.service.UniversityService;
// import org.springframework.stereotype.Service;
// import org.springframework.beans.factory.annotation.Autowired;  // Add this import

// @Service
// public class UniversityServiceImpl implements UniversityService {

//     @Autowired  // Add this - enables Spring injection
//     private UniversityRepository repository;

//     @Override
//     public University createUniversity(University university) {
//         if (university.getName() == null || university.getName().trim().isEmpty()) {
//             throw new IllegalArgumentException("Name required");
//         }
//         if (repository.findByName(university.getName()).isPresent()) {
//             throw new IllegalArgumentException("already exists");
//         }
//         return repository.save(university);
//     }

//     @Override
//     public University getUniversityById(Long id) {
//         return repository.findById(id)
//                 .orElseThrow(() -> new RuntimeException("not found"));
//     }

//     @Override
//     public University updateUniversity(Long id, University university) {
//         University existing = repository.findById(id)
//                 .orElseThrow(() -> new RuntimeException("not found"));
//         existing.setName(university.getName());
//         return repository.save(existing);
//     }

//     @Override
//     public void deactivateUniversity(Long id) {
//         University u = repository.findById(id)
//                 .orElseThrow(() -> new RuntimeException("not found"));
//         u.setActive(false);
//         repository.save(u);
//     }

//     @Override
//     public List<University> getAllUniversities() {  // Fix import issue
//         return repository.findAll();
//     }

//     @Override
//     public void DeleteData1(Long id) {
//         repository.deleteById(id);
//     }
// }






package com.example.demo.service.impl;

import com.example.demo.entity.University;
import com.example.demo.repository.UniversityRepository;
import com.example.demo.service.UniversityService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class UniversityServiceImpl implements UniversityService {

    @Autowired
    UniversityRepository repository;

    public UniversityServiceImpl(){
    }

    @Override
    public University createUniversity(University university) {
        if (university.getName() == null || university.getName().isBlank()) {
            throw new IllegalArgumentException("Name required");
        }

        repository.findByName(university.getName())
                .ifPresent(u -> {
                    throw new IllegalArgumentException("University already exists");
                });

        return repository.save(university);
    }

    @Override
    public University updateUniversity(Long id, University updated) {
        University existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("University not found"));

        existing.setName(updated.getName());
        existing.setCountry(updated.getCountry());
        existing.setAccreditationLevel(updated.getAccreditationLevel());
        existing.setActive(updated.getActive());

        return repository.save(existing);
    }

    @Override
    public University getUniversityById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("University not found"));
    }

    @Override
    public void deactivateUniversity(Long id) {
        University u = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("University not found"));
        u.setActive(false);
        repository.save(u);
    }

    @Override
    public List<University> getAllUniversities() {
        return repository.findAll();
    }
}
