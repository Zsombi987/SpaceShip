package com.greenfoxacademy.space_transporter.repository;

import com.greenfoxacademy.space_transporter.model.Planet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlanetRepository extends CrudRepository<Planet, Long> {
    List<Planet> findAll();
}

// itt gyartjuk le az SQL-eket
// a spring/java az amit osszekotunk az adatbazissal