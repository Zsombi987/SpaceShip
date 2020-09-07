package com.greenfoxacademy.space_transporter.service;

import com.greenfoxacademy.space_transporter.model.Planet;

import java.util.List;

public interface PlanetService {
    List<Planet> getPlanets();
    void movePeople(Long planetName, Long change);
}

// itt tortenik a 'business logic' kifejtese