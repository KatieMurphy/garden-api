package com.example.garden.controller;

import com.example.garden.exception.ResourceNotFoundException;
import com.example.garden.model.Plant;
import com.example.garden.repository.PlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class PlantController {

    @Autowired
    private PlantRepository plantRepository;

    //get all plants
    @GetMapping("/plants")
    public List<Plant> getAllPlants() {
        return plantRepository.findAll();
    }

    //create plant
    @PostMapping("/plants")
    public Plant createPlant(@RequestBody Plant plant) {
        return plantRepository.save(plant);
    }

    @GetMapping("/plants/{id}")
    public ResponseEntity<Plant> getPlantById(@PathVariable Integer id) {
        Plant plant = plantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Plant does not exist with id:" + id));
        return ResponseEntity.ok(plant);
    }

    //TODO updating all/some fields?
    @PutMapping("/plants/{id}")
    public ResponseEntity<Plant> updatePlant(@PathVariable Integer id, @RequestBody Plant plantDetails) {
        Plant plant = plantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Plant does not exist with id:" + id));

        plant.setName(plantDetails.getName());

        Plant updatePlant = plantRepository.save(plant);
        return ResponseEntity.ok(updatePlant);
    }

    @DeleteMapping("/plants/{id}")
    public ResponseEntity<Map<String, Boolean>> deletePlant(@PathVariable Integer id){
        Plant plant = plantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Plant not exist with id :" + id));

        plantRepository.delete(plant);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);

    }
}
