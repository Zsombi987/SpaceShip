package com.greenfoxacademy.space_transporter.repository;

import com.greenfoxacademy.space_transporter.model.Spaceship;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpaceshipRepository extends CrudRepository<Spaceship, Long> {
    List<Spaceship> findAll();
}

// itt gyartjuk le az SQL-eket
