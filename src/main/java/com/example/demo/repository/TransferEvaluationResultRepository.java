// // package com.example.demo.repository;
// // import org.springframework.stereotype.Repository;
// // import org.springframework.data.jpa.repository.JpaRepository;
// // import com.example.demo.entity.TransferEvaluationResult;


// // @Repository
// // public interface TransferEvaluationResultRepository extends JpaRepository<TransferEvaluationResult,Long>{

// // }
// package com.example.demo.repository;

// import org.springframework.stereotype.Repository;
// import org.springframework.data.jpa.repository.JpaRepository;
// import java.util.List;
// import com.example.demo.entity.TransferEvaluationResult;

// @Repository
// public interface TransferEvaluationResultRepository
//         extends JpaRepository<TransferEvaluationResult, Long> {

//     List<TransferEvaluationResult> findBySourceCourseId(Long sourceCourseId);
// }
package com.example.demo.repository;

import com.example.demo.entity.TransferEvaluationResult;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TransferEvaluationResultRepository extends JpaRepository<TransferEvaluationResult, Long> {
    List<TransferEvaluationResult> findBySourceCourseId(Long sourceCourseId);
}