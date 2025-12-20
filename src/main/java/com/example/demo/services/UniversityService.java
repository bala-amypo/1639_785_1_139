package com.example.demo.service;

import com.example.demo.model.Garage;
import java.util.List;

public interface  UniversityService{
    University createGarage(University );
    Garage updateGarage(Long id, Garage garage);
    Garage getGarageById(Long id);
    List<Garage> getAllGarage();
    void deactivateGarage(Long id);
}