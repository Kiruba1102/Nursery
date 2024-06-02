package com.nurs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.nurs.model.Plant;
import com.nurs.service.PlantService;

@RestController
@RequestMapping("/api/plants")
@CrossOrigin("*")
public class PlantController {
  
  @Autowired
  private PlantService plantService;
  
  @PostMapping("/imageupload")
  public ResponseEntity<?> upload(@RequestParam("species") String species,
                                  @RequestParam("variety") String variety,
                                  @RequestParam("quantity") int quantity,
                                  @RequestParam("price") double price,
                                  @RequestParam("image") MultipartFile image){
    try {
      Plant img = new Plant();
      img.setSpecies(species);
      img.setVariety(variety);
      img.setQuantity(quantity);
      img.setPrice(price);
      img.setImage(image.getBytes());
      plantService.savePlant(img);
      return new ResponseEntity<>(HttpStatus.OK);
    }
    catch (Exception e) {
      return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
  
  @GetMapping("/{id}")
  public ResponseEntity<Plant> getPlantById(@PathVariable int id) {
    Plant plant = plantService.getPlantById(id);
    if (plant == null) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(plant);
  }
  
  @GetMapping("/get")
  public ResponseEntity<List<Plant>> getAllPlants() {
    List<Plant> plants = plantService.getAllPlants();
    return ResponseEntity.ok(plants);
  }
  
  @PutMapping("/{id}")
  public ResponseEntity<Plant> updatePlant(@PathVariable int id, @RequestBody Plant plant) {
    Plant existingPlant = plantService.getPlantById(id);
    if (existingPlant == null) {
      return ResponseEntity.notFound().build();
    }
    plant.setPid(id);
    Plant updatedPlant = plantService.updatePlant(plant);
    return ResponseEntity.ok(updatedPlant);
  }
  
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deletePlant(@PathVariable int id) {
    Plant plant = plantService.getPlantById(id);
    if (plant == null) {
      return ResponseEntity.notFound().build();
    }
    plantService.deletePlant(id);
    return ResponseEntity.noContent().build();
  }
}
