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

import java.util.List;
import com.example.demo.entity.University;

public interface UniversityService {

    University postData1(University university);

    List<University> getAllUniversities();

    University getUniversityById(Long id);

    University updateUniversity(Long id, University university);

    String DeleteData1(Long id);
}

