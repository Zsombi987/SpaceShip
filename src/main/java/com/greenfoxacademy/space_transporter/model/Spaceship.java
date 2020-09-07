package com.greenfoxacademy.space_transporter.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Spaceship {

    @Id
    private Long spaceshipId;

    private Long maxCapacity;

    private Long planet;

    private Long utilization;

    public Spaceship() {
    }

    public Spaceship(Long maxCapacity, Long planetId, Long utilization) {
        this.maxCapacity = maxCapacity;
        this.planet = planet;
        this.utilization = utilization;
    }

    public Long getMaxCapacity() {
        return maxCapacity;
    }

    public Long getPlanet() {
        return planet;
    }

    public void setPlanet(Long planet) {
        this.planet = planet;
    }

    public Long getUtilization() {
        return utilization;
    }

    public void changeUtilization(Long change) { //szeretnenk allitani rajta, hozzaadni, elvenni belole
        this.utilization += change;
    }
}

// (itt allitjuk be az adatbazis tabla minden egyes sorat)
// meghatarozzuk az adatmodellt-modelleket
// hibernate funkcio az ami elvegzi a feladatokat valojaban