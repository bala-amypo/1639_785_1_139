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

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.entity.University;
import com.example.demo.repository.UniversityRepository;
import com.example.demo.service.UniversityService;

@Service
public class UniversityServiceImpl implements UniversityService {

    private final UniversityRepository repository;

    public UniversityServiceImpl(UniversityRepository repository) {
        this.repository = repository;
    }

    @Override
    public University createUniversity(University univ) {
        return repository.save(univ);
    }

    @Override
    public List<University> getAllUniversities() {
        return repository.findAll();
    }

    @Override
    public University getUniversityById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "University not found with id " + id
                        ));
    }

    @Override
    public University updateUniversity(Long id, University univ) {
        University existing = repository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "University not found with id " + id
                        ));

        univ.setId(existing.getId());
        return repository.save(univ);
    }

    @Override
    public String DeleteData1(Long id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "University not found with id " + id
            );
        }
        repository.deleteById(id);
        return "Deleted successfully";
    }
}
