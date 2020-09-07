package com.greenfoxacademy.space_transporter.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Planet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long planetId;

    private String name;

    private Long population;

    public Planet() {
    }

    public Planet(String name, Long population) {
        this.name = name;
        this.population = population;
    }

    public long getPlanetId() {
        return planetId;
    }

    public String getName() {
        return name;
    }

    public Long getPopulation() {
        return population;
    }

    public void changePopulation(Long change) {
        this.population = this.population + change;
    }
}

// itt allitjuk be az adatbazis tabla minden egyes sorat