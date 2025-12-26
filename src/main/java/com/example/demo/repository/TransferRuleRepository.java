// package com.example.demo.repository;
// import org.springframework.stereotype.Repository;
// import org.springframework.data.jpa.repository.JpaRepository;
// import com.example.demo.entity.TransferRule;


// @Repository
// public interface TransferRuleRepository extends JpaRepository<TransferRule,Long>{

// }


package com.example.demo.repository;

import com.example.demo.entity.TransferRule;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TransferRuleRepository extends JpaRepository<TransferRule, Long> {

    java.util.List<TransferRule>
    findBySourceUniversityIdAndTargetUniversityIdAndActiveTrue(Long sourceId, Long targetId);
}
