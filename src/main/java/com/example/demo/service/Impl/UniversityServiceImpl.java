// package com.example.demo.service.impl;

// import java.util.List;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;   
// import com.example.demo.entity.University;
// import com.example.demo.repository.UniversityRepository;
// // import org.springframework.web.bind.annotation.PathVariable;
// import com.example.demo.service.UniversityService;                

// @Service
// public class UniversityServiceImpl implements UniversityService{

//     @Autowired UniversityRepository used;
//     @Override
//     public University createUniversity(University univ){
//         return used.save(univ);  
//     }
//     @Override
//     public List<University>getAllUniversities(){
//         return used.findAll();
//     }
//     @Override
//     public University getUniversityById(Long id){
//     return used.findById(id).orElseThrow(()-> new RuntimeException("not found"));
//     }
//     @Override
//     public University updateUniversity(Long id,University univ){
//         if(used.existsById(id)){
//             univ.setId(id);
//             return used.save(univ);
//         } 
//         return null;
//     }
//     @Override
//     public String DeleteData1(Long id){
//         used.deleteById(id);
//         return "Deleted successfully";
//     }
   
// }
package com.example.demo.service.impl;

import com.example.demo.entity.University;
import com.example.demo.repository.UniversityRepository;
import com.example.demo.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UniversityServiceImpl implements UniversityService {

    @Autowired
    private UniversityRepository universityRepository;

    @Override
    public University createUniversity(University univ) {
        return universityRepository.save(univ);
    }

    @Override
    public University updateUniversity(Long id, University univ) {
        Optional<University> existing = universityRepository.findById(id);
        if (existing.isPresent()) {
            University university = existing.get();
            university.setName(univ.getName()); // example field
            university.setLocation(univ.getLocation()); // example field
            // set other fields as needed
            return universityRepository.save(university);
        } else {
            return null; // or throw exception
        }
    }

    @Override
    public University getUniversityById(Long id) {
        return universityRepository.findById(id).orElse(null);
    }

    @Override
    public List<University> getAllUniversities() {
        return universityRepository.findAll();
    }

    @Override
    public String DeleteData1(Long id) {
        if (universityRepository.existsById(id)) {
            universityRepository.deleteById(id);
            return "University deleted successfully";
        } else {
            return "University not found";
        }
    }
}
