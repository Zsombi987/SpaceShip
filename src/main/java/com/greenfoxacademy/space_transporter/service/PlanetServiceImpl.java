package com.greenfoxacademy.space_transporter.service;

import com.greenfoxacademy.space_transporter.model.Planet;
import com.greenfoxacademy.space_transporter.repository.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanetServiceImpl implements PlanetService{

    private PlanetRepository repository;

    @Autowired
    public PlanetServiceImpl(PlanetRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Planet> getPlanets() {
        return repository.findAll();
    }

    @Override //metodust implementalunk (planets interface fuggvenye) // java 'egyediseg'
    public void movePeople(Long planet, Long change) { //visszateresi ertek nelkuli, long tipusu, planet nevu, long tipusu, change nevu parameterekkel
        List<Planet> planets = repository.findAll(); //kivesszuk az osszes bolygot es hozzarendeljuk egy lokalis listahoz
        for (int i = 0; i < planets.size(); i ++) { //a ciklus vegigmegy az osszes bolygon
            if(planets.get(i).getPlanetId() == planet){ //ha az i-edik bolygo id-ja megegyezik a parameterkent kapott bolygo id-javal
                planets.get(i).changePopulation(change); //akkor az i-edik bolygonak megvaltoztajuk a populaciojat
                break; //ha egy loopban vagyok, akkor kilep belole es atugrik a kovetkezore
            }
        }
        repository.saveAll(planets); //elkuldi a planets listat az adatbazisnak, de itt csak a populacio fog megvaltozni
    }
}

// itt implementaljuk a service classt es tartalmazza az osszes 'logikai' kodot
// itt hatarozzuk meg hogy mit szeretnenk csinalni a repositorival