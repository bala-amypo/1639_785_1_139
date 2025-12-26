







// package com.example.demo.service.impl;

// import java.util.List;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;   
// import com.example.demo.entity.University;
// import com.example.demo.repository.UniversityRepository;
// import com.example.demo.exception.ResourceNotFoundException;
// // import org.springframework.web.bind.annotation.PathVariable;
// import com.example.demo.service.UniversityService;                

// @Service
// public class UniversityServiceImpl implements UniversityService{

//     @Autowired UniversityRepository repository;
//     @Override
//     public University createUniversity(University univ){
//         return repository.save(univ);  
//     }
//     @Override
//     public List<University>getAllUniversities(){
//         return repository.findAll();
//     }
//     @Override
//     public University getUniversityById(Long id){
//     return repository.findById(id).orElseThrow(()->new ResourceNotFoundException("exists"));
//     }
//     @Override
//     public University updateUniversity(Long id,University univ){
//         if(repository.existsById(id)){
//             univ.setId(id);
//             return repository.save(univ);
//         } 
//         return null;
//     }
//     @Override
//     public String DeleteData1(Long id){
//         repository.deleteById(id);
//         return "Deleted successfully";
//     }
   
// }









// package com.example.demo.service.impl;

// import java.util.*;
// import com.example.demo.entity.University;
// import com.example.demo.repository.UniversityRepository;

// public class UniversityServiceImpl {

//     private UniversityRepository repository;

//     public University createUniversity(University u) {
//         if (u.getName() == null || u.getName().isBlank())
//             throw new IllegalArgumentException("Name required");

//         repository.findByName(u.getName()).ifPresent(x -> {
//             throw new IllegalArgumentException("University already exists");
//         });
//         return repository.save(u);
//     }

//     public University updateUniversity(Long id, University u) {
//         University existing = repository.findById(id)
//                 .orElseThrow(() -> new RuntimeException("University not found"));
//         if (u.getName() != null)
//             existing.setName(u.getName());
//         return repository.save(existing);
//     }

//     public University getUniversityById(Long id) {
//         return repository.findById(id)
//                 .orElseThrow(() -> new RuntimeException("University not found"));
//     }

//     public void deactivateUniversity(Long id) {
//         University u = repository.findById(id)
//                 .orElseThrow(() -> new RuntimeException("University not found"));
//         u.setActive(false);
//         repository.save(u);
//     }
// }


// package com.example.demo.service.impl;

// import com.example.demo.entity.University;
// import com.example.demo.exception.ResourceNotFoundException;
// import com.example.demo.repository.UniversityRepository;
// import com.example.demo.service.UniversityService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;
// import java.util.List;

// @Service
// public class UniversityServiceImpl implements UniversityService {

//     @Autowired
//     private UniversityRepository repository;

//     @Override
//     public University createUniversity(University university) {
//         if (university.getName() == null || university.getName().isBlank()) {
//             throw new IllegalArgumentException("Name is required");
//         }
//         repository.findByName(university.getName()).ifPresent(u -> {
//             throw new IllegalArgumentException("University with this name already exists");
//         });
//         return repository.save(university);
//     }

//     @Override
//     public University updateUniversity(Long id, University university) {
//         University existing = getUniversityById(id);
//         existing.setName(university.getName());
//         return repository.save(existing);
//     }

//     @Override
//     public University getUniversityById(Long id) {
//         return repository.findById(id)
//                 .orElseThrow(() -> new ResourceNotFoundException("University not found with id: " + id));
//     }

//     @Override
//     public void deactivateUniversity(Long id) {
//         University u = getUniversityById(id);
//         u.setActive(false);
//         repository.save(u);
//     }

//     @Override
//     public List<University> getAllUniversities() {
//         return repository.findAll();
//     }
// }







package com.example.demo.service.impl;

import com.example.demo.entity.University;
import com.example.demo.repository.UniversityRepository;
import com.example.demo.service.UniversityService;
import org.springframework.stereotype.Service;

@Service
public class UniversityServiceImpl implements UniversityService {

    private UniversityRepository repository;

    @Override
    public University createUniversity(University university) {
        if (university.getName() == null || university.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Name required");
        }
        if (repository.findByName(university.getName()).isPresent()) {
            throw new IllegalArgumentException("already exists");
        }
        return repository.save(university);
    }

    @Override
    public University getUniversityById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("not found"));
    }

    @Override
    public University updateUniversity(Long id, University university) {
        University existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("not found"));
        existing.setName(university.getName());
        return repository.save(existing);
    }

    @Override
    public void deactivateUniversity(Long id) {
        University u = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("not found"));
        u.setActive(false);
        repository.save(u);
    }
}
