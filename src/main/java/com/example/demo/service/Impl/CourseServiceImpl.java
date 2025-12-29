
// package com.example.demo.service.impl;

// import com.example.demo.entity.Course;
// import com.example.demo.repository.CourseRepository;
// import com.example.demo.repository.UniversityRepository;
// import com.example.demo.service.CourseService;
// import org.springframework.stereotype.Service;

// import java.util.List;

// @Service
// public class CourseServiceImpl implements CourseService {

//     // these names are used by tests via reflection
//     private CourseRepository repo;
//     private UniversityRepository univRepo;

//     @Override
//     public Course createCourse(Course course) {
//         if (course.getCreditHours() <= 0) {
//             throw new IllegalArgumentException("> 0");
//         }
//         if (course.getUniversity() == null || course.getUniversity().getId() == null) {
//             throw new IllegalArgumentException("University required");
//         }

//         univRepo.findById(course.getUniversity().getId())
//                 .orElseThrow(() -> new RuntimeException("not found"));

//         if (repo.findByUniversityIdAndCourseCode(
//                 course.getUniversity().getId(), course.getCourseCode()).isPresent()) {
//             throw new IllegalArgumentException("duplicate");
//         }

//         return repo.save(course);
//     }

//     @Override
//     public Course getCourseById(Long id) {
//         return repo.findById(id)
//                 .orElseThrow(() -> new RuntimeException("not found"));
//     }

//     @Override
//     public Course updateCourse(Long id, Course course) {
//         Course existing = repo.findById(id)
//                 .orElseThrow(() -> new RuntimeException("not found"));
//         existing.setCourseCode(course.getCourseCode());
//         existing.setCourseName(course.getCourseName());
//         existing.setCreditHours(course.getCreditHours());
//         return repo.save(existing);
//     }

//     @Override
//     public void deactivateCourse(Long id) {
//         Course c = repo.findById(id)
//                 .orElseThrow(() -> new RuntimeException("not found"));
//         c.setActive(false);
//         repo.save(c);
//     }

//     @Override
//     public List<Course> getCoursesByUniversity(Long universityId) {
//         // used by tests (test37CoursesByUniversity)
//         return repo.findByUniversityIdAndActiveTrue(universityId);
//     }

//     // controller helper: list all courses
//     @Override
//     public List<Course> getAllData3() {
//         return repo.findAll();
//     }

//     // controller helper: delete course
//     @Override
//     public void DeleteData3(Long id) {
//         repo.deleteById(id);
//     }
// }









package com.example.demo.service.impl;

import com.example.demo.entity.Course;
import com.example.demo.entity.University;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.UniversityRepository;
import com.example.demo.service.CourseService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepository repo;

    @Autowired
    UniversityRepository univRepo;

    public CourseServiceImpl() {
    }

    @Override
    public Course createCourse(Course course) {

        if (course.getCreditHours() == null || course.getCreditHours() <= 0) {
            throw new IllegalArgumentException("Credit hours must be > 0");
        }

        University u = univRepo.findById(course.getUniversity().getId())
                .orElseThrow(() -> new RuntimeException("University not found"));

        repo.findByUniversityIdAndCourseCode(u.getId(), course.getCourseCode())
                .ifPresent(c -> { throw new IllegalArgumentException("Duplicate course"); });

        course.setUniversity(u);
        return repo.save(course);
    }

    @Override
    public Course updateCourse(Long id, Course course) {
        Course existing = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        return repo.save(existing);
    }

    @Override
    public Course getCourseById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));
    }

    @Override
    public void deactivateCourse(Long id) {
        Course c = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        c.setActive(false);
        repo.save(c);
    }

    @Override
    public List<Course> getCoursesByUniversity(Long universityId) {
        return repo.findByUniversityIdAndActiveTrue(universityId);
    }
}
