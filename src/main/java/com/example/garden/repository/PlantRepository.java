package com.example.garden.repository;

import com.example.garden.model.Plant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlantRepository extends JpaRepository<Plant, Integer> {

}
