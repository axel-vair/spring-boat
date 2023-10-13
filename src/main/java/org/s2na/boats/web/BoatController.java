package org.s2na.boats.web;

import org.s2na.boats.domain.Boat;
import org.s2na.boats.repository.BoatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RequestMapping(value = "/api/boats", method = { RequestMethod.POST })
@RestController
public class BoatController {

    @Autowired
    private BoatRepository boatRepository;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Boat> listBoats(){
        return boatRepository.findAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Boat> singleBoat(@PathVariable Integer id){
        return boatRepository.findById(id);
    }

    @PostMapping(value = "api/boats")
    public ResponseEntity<Boat> createBoat(@RequestBody Boat boat){
        return ResponseEntity.ok(boatRepository.save(boat));
    }
}


