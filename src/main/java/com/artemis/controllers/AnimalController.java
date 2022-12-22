package com.artemis.controllers;

import com.artemis.entities.Animal;
import com.artemis.exceptions.AnimalException;
import com.artemis.services.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/animals")
public class AnimalController {
    @Autowired
    private AnimalService animalService;

    // Fetch All Animals
    @GetMapping("/all")
    public ResponseEntity<List<Animal>> getAllAnimals() {
        List<Animal> animalList = animalService.findAllAnimals();
        return new ResponseEntity<List<Animal>>(animalList, HttpStatus.OK);
    }

    // Fetch Animal By Id
    @GetMapping("/find/{id}")
    public ResponseEntity<Animal> getAnimalById(@PathVariable("id") int id) {
        try
        { return new ResponseEntity<Animal>(animalService.findAnimal(id), HttpStatus.OK); }
        catch(AnimalException exception)
        { throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Animal Not Found"); }
    }

    // Create New Animal
    @PostMapping("/create")
    public ResponseEntity<Animal> createOneAnimal(@RequestBody Animal animal) {
        Animal candidateAnimal = animalService.createAnimal(animal);
        return new ResponseEntity<Animal>(candidateAnimal, HttpStatus.OK);
    }

    // Get All Animals By Species
    @GetMapping("/species/{species_id}")
    public ResponseEntity<List<Animal>> getAllBySpecies(@PathVariable("species_id") int speciesId) {
        List<Animal> filteredAnimals = animalService.findAnimalsBySpecies(speciesId);
        return new ResponseEntity<List<Animal>>(filteredAnimals, HttpStatus.OK);
    }

    // Get All Animals By Keeper
    @GetMapping("/keepers/{keeper_id}")
    public ResponseEntity<List<Animal>> getAllByKeeper(@PathVariable("keeper_id") int keeperId) {
        List<Animal> filteredAnimals = animalService.findAnimalsByKeeper(keeperId);
        return new ResponseEntity<List<Animal>>(filteredAnimals, HttpStatus.OK);
    }

    // Update Animal Information
    @PutMapping("/update/{id}")
    public ResponseEntity<Animal> modAnimal(@PathVariable("id") int id, @RequestBody Animal animal) {
        Animal moddedAnimal = animalService.modifyAnimalData(id, animal);
        return new ResponseEntity<Animal>(moddedAnimal, HttpStatus.OK);
    }

    // Delete Animal By Id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteAnimal(@PathVariable("id") int id) {
        boolean deleted = false;
        Map<String, Boolean> response = new HashMap<>();

        try {
            deleted = animalService.deleteAnimal(id);
            response.put("deleted", deleted);

            return ResponseEntity.ok(response);
        }
        catch(AnimalException exception)
        { throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Animal Not Found"); }
    }
}
