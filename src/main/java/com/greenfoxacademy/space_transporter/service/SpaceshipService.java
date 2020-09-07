package com.greenfoxacademy.space_transporter.service;

import com.greenfoxacademy.space_transporter.model.Spaceship;

public interface SpaceshipService {
    Spaceship getSpaceship();
    void movePeople(Long number);
    void moveToPlanet(Long id);
}

// itt tortenik a 'business logic' kifejtese