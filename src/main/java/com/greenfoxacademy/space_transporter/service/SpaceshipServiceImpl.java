package com.greenfoxacademy.space_transporter.service;

import com.greenfoxacademy.space_transporter.model.Spaceship;
import com.greenfoxacademy.space_transporter.repository.SpaceshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpaceshipServiceImpl implements SpaceshipService {

    @Autowired
    private SpaceshipRepository repository;


    @Override
    public Spaceship getSpaceship() {
        return repository.findAll().get(0);
    }

    @Override
    public void movePeople(Long number) {
        Spaceship ship = getSpaceship();
        ship.changeUtilization(number);
        repository.save(ship);
    }

    @Override
    public void moveToPlanet(Long id) {
        Spaceship ship = getSpaceship();
        ship.setPlanet(id);
        repository.save(ship);
    }
}

// itt implementaljuk a service classt es tartalmazza az osszes 'logikai' kodot