package org.s2na.boats.web;

import org.s2na.boats.domain.Boat;
import org.s2na.boats.domain.Classe;
import org.s2na.boats.repository.ClasseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RequestMapping("/api/classes")
@RestController
public class ClasseController {
    @Autowired
    private ClasseRepository classeRepository;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Classe> classeList(){
        return classeRepository.findAll();
    }

    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Classe> singleClasse(@PathVariable Integer id){
        return classeRepository.findById(id);
    }

    @PutMapping(value ="{id}")
    public ResponseEntity<Classe> updateClasse(@PathVariable Integer id, @RequestBody Classe classe) {
        Optional<Classe> existingClasse = classeRepository.findById(id);
        if (existingClasse.isPresent()) {
            Classe updateClasse = existingClasse.get();
            updateClasse.setName(classe.getName());

            Classe savedClasse = classeRepository.save(updateClasse);
            return ResponseEntity.ok(savedClasse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Classe createClasse(@RequestBody Classe classe){return classeRepository.save(classe);}
}
