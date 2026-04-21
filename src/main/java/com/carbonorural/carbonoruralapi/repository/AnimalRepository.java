package com.carbonorural.carbonoruralapi.repository;

import com.carbonorural.carbonoruralapi.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal, Long> {
}
