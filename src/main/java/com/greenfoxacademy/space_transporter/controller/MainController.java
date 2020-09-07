package com.greenfoxacademy.space_transporter.controller;

import com.greenfoxacademy.space_transporter.model.Planet;
import com.greenfoxacademy.space_transporter.service.PlanetServiceImpl;
import com.greenfoxacademy.space_transporter.service.SpaceshipServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class MainController {

    private PlanetServiceImpl planetService;
    private SpaceshipServiceImpl spaceshipService;

    @Autowired //spring sajatos annotacioja, hogy a service-eket idetegye, osszekotes a szerepe ebben a konstruktorban
    public MainController(PlanetServiceImpl planetService, SpaceshipServiceImpl spaceshipService) {
        this.planetService = planetService;
        this.spaceshipService = spaceshipService;
    }

    @GetMapping("/")
    public String getIndexPage(Model model) { //az a modell, ami eppen ehhez a kerelemhez tartozik, adhatok hozza sajat adatot, thymeleaf-fel tudom megjeleniteni
        model.addAttribute("planets", planetService.getPlanets());
        model.addAttribute("spaceship", spaceshipService.getSpaceship());
        return "index"; //visszaadjuk az indexet ami a html lesz
    }

    @GetMapping("/movehere/{id}") //modell nincs mert nem a thymeleaf-hez fog kelleni
    public String moveHere(@PathVariable long id) {
        spaceshipService.moveToPlanet(id); //tudja hogy melyik bolygohoz kell eppen utaznunk
        return "redirect:/";
    }

    @GetMapping("/toship/{id}")
    public String toShip(@PathVariable Long id) {
        Long amount = spaceshipService.getSpaceship().getMaxCapacity() - spaceshipService.getSpaceship().getUtilization(); //kivesszuk az adatbzaisban megtalalhato osszes bolygot
        Planet planet = null;
        List<Planet> planets = planetService.getPlanets();
        for (int i = 0; i < planets.size(); i ++) { //a ciklus vegigmegy az osszes bolygon
            if(planets.get(i).getPlanetId() == id){ //ha ennek a bolygonak az ID-ja megegyezik a parameterkent erkezett ID-val
                planet = planets.get(i); //akkor a planet valtozo egyenlo lesz az i-edik bolygoval
                break;
            }
        }

        if(amount > planet.getPopulation()) { //kiszamoljuk hany embert fogunk megmozgatni, hogy ne mehessen minuszba!
            amount = planet.getPopulation();
        }
        spaceshipService.movePeople(amount); //az egyikbol elveszunk, a masikba belerakjuk, iranytol fuggoen
        planetService.movePeople(spaceshipService.getSpaceship().getPlanet(),-amount);
        return "redirect:/";
    }

    @GetMapping("/toplanet/{id}")
    public String toPlanet(@PathVariable Long id) {
        Long amount = spaceshipService.getSpaceship().getUtilization(); //az osszes embert attesszuk a bolygora
        spaceshipService.movePeople(-amount); //kivesszuk
        planetService.movePeople(id,amount); //beletesszuk
        return "redirect:/"; //oldal ujratoltese
    }
}

// http kerelmekre valaszol, a valasz lehet html