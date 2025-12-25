// package com.example.demo.repository;
// import org.springframework.stereotype.Repository;
// import org.springframework.data.jpa.repository.JpaRepository;
// import com.example.demo.entity.TransferRule;


// @Repository
// public interface TransferRuleRepository extends JpaRepository<TransferRule,Long>{

// }
package com.example.demo.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.example.demo.entity.TransferRule;

@Repository
public interface TransferRuleRepository extends JpaRepository<TransferRule, Long> {

    List<TransferRule> findBySourceUniversityIdAndTargetUniversityIdAndActiveTrue(
            Long sourceUniversityId,
            Long targetUniversityId
    );
}
