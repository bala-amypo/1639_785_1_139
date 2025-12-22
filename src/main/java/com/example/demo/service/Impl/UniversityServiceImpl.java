package com.example.demo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;   
import com.example.demo.entity.University;
import com.example.demo.repository.UniversityRepository;
// import org.springframework.web.bind.annotation.PathVariable;
import com.example.demo.service.UniversityService;                

@Service
public class UniversityServiceImpl implements UniversityService{

    @Autowired UniversityRepository used;
    @Override
    public University createUniversity(University univ){
        return used.save(univ);  
    }
    @Override
    public List<University>getAllUniversities(){
        return used.findAll();
    }
    @Override
    public University getUniversityById(Long id){
    return used.findById(id).orElse(null);
    }
    @Override
    public University updateUniversity(Long id,University univ){
        if(used.existsById(id)){
            univ.setId(id);
            return used.save(univ);
        } 
        return null;
    }
    @Override
    public String DeleteData1(Long id){
        used.deleteById(id);
        return "Deleted successfully";
    }
   
}
// package com.example.demo.service.impl;

// import org.springframework.stereotype.Service;
// import java.util.List;
// import com.example.demo.entity.University;
// import com.example.demo.repository.UniversityRepository;
// import com.example.demo.service.UniversityService;

// @Service
// public class UniversityServiceImpl implements UniversityService {

//     private final UniversityRepository universityRepository;

//     public UniversityServiceImpl(UniversityRepository universityRepository) {
//         this.universityRepository = universityRepository;
//     }

//     @Override
//     public University createUniversity(University univ) {
//         return universityRepository.save(univ);
//     }

//     @Override
//     public University updateUniversity(Long id, University univ) {
//         University existing = universityRepository.findById(id)
//                 .orElseThrow(() -> new RuntimeException("University not found"));
//         existing.setName(univ.getName());
//         existing.setLocation(univ.getLocation());
//         return universityRepository.save(existing);
//     }

//     @Override
//     public University getUniversityById(Long id) {
//         return universityRepository.findById(id)
//                 .orElseThrow(() -> new RuntimeException("University not found"));
//     }

//     @Override
//     public List<University> getAllUniversities() {
//         return universityRepository.findAll();
//     }

//     @Override
//     public String deleteData(Long id) {
//         universityRepository.deleteById(id);
//         return "Deleted Successfully";
//     }
// }


