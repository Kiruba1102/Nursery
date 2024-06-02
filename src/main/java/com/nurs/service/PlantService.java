package com.nurs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nurs.model.Plant;
import com.nurs.repo.PlantRepositoryImpl;

@Service
@Transactional
public class PlantService {
  
  @Autowired
  private PlantRepositoryImpl plantRepository;
  
  public Plant savePlant(Plant plant) {
    return plantRepository.save(plant);
  }
  
  public Plant getPlantById(int id) {
    return plantRepository.findById(id);
  }
  
  public List<Plant> getAllPlants() {
    return plantRepository.findAll();
  }
  
  public void deletePlant(int id) {
    plantRepository.deleteById(id);
  }
  
  public Plant updatePlant(Plant plant) {
    return plantRepository.save(plant);
  }
}
