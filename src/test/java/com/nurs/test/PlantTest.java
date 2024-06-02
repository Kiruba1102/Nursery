package com.nurs.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.nurs.model.Plant;
import com.nurs.service.PlantService;

@SpringBootTest
public class PlantTest {

	
	
	 @Autowired
	 private PlantService plantService;
	 
	 @Test
	 void test_plant() {
		 List<Plant> plants = plantService.getAllPlants();
		  assertNotNull(plants);
	 }
	 
	 @Test
	 void test_plan2t() {
		 Plant plant = plantService.getPlantById(1);
		  assertNotNull(plant);
	 }
}
