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
@RequestMapping(value = "api/boats", method = {RequestMethod.POST})
@RestController
public class BoatController {

    @Autowired
    private BoatRepository boatRepository;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Boat> listBoats() {
        return boatRepository.findAll();
    }

    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Boat> singleBoat(@PathVariable Integer id) {
        return boatRepository.findById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Boat createBoat(@RequestBody Boat boat) {
        return boatRepository.save(boat);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<Boat> updateBoat(@PathVariable Integer id, @RequestBody Boat boat) {
        Optional<Boat> existingBoat = boatRepository.findById(id);
        if (existingBoat.isPresent()) {
            Boat updateBoat = existingBoat.get();
            updateBoat.setName(boat.getName());
            updateBoat.setClasse(boat.getClasse());
            updateBoat.setLength(boat.getLength());
            updateBoat.setTonnage(boat.getTonnage());

            Boat savedBoat = boatRepository.save(updateBoat);
            return ResponseEntity.ok(savedBoat);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Object> deleteBoat(@PathVariable Integer id) {
        boatRepository.deleteById(id);
        return ResponseEntity.noContent().build();

    }

}


