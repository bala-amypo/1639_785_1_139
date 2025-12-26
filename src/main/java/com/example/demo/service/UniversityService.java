// package com.example.demo.service;

// import java.util.List;
// import com.example.demo.entity.University;

// public interface UniversityService{
//     University createUniversity(University univ);
//     University updateUniversity(Long id,University univ);
//     University getUniversityById(Long id);
//     List<University>getAllUniversities();
//     String  DeleteData1(Long id);    
// }


package com.example.demo.service;

import com.example.demo.entity.University;
import java.util.List;

public interface UniversityService {

    University createUniversity(University university);

    University getUniversityById(Long id);

    University updateUniversity(Long id, University university);

    void deactivateUniversity(Long id);

    // used by UniversityController
    java.util.List<University> getAllUniversities();

    void DeleteData1(Long id);
}
