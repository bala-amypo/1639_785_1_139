package com.example.demo.service;

import com.example.demo.model.Garage;
import java.util.List;

public interface  TransferEvaluationService{
    TransferEvaluation updateUniversity(Long id,University univ);
    University getUniversityById(Long id);
    List<University> getAllUniversities();
    void deactivateUniversity(Long id);
}