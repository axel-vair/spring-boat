package org.s2na.boats.web;

import org.s2na.boats.domain.User;
import org.s2na.boats.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RequestMapping("/api/users")
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> listUsers() {
        return userRepository.findAll();
    }

    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<User> singleUser(@PathVariable Integer id) {
        return userRepository.findById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public User createUser(@RequestBody User user) {
        String defaultRole = "ROLE_USER";

        user.setRole(defaultRole);
       return userRepository.save(user);
    }



    @DeleteMapping(value = "{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable Integer id){
        userRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
