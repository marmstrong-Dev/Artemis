package com.artemis.controllers;

import com.artemis.exceptions.SpeciesException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.artemis.entities.Species;
import com.artemis.services.SpeciesService;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/species")
public class SpeciesController {
    @Autowired
    private SpeciesService speciesService;

    // Fetch All Species
    @GetMapping("/all")
    public ResponseEntity<List<Species>> getAllSpecies() {
        List<Species> speciesList = speciesService.findAllSpecies();
        return new ResponseEntity<List<Species>>(speciesList, HttpStatus.OK);
    }

    // Fetch One Species By Id
    @GetMapping("/find/{id}")
    public ResponseEntity<Species> getSpeciesById(@PathVariable("id") int id) {
        try
        { return new ResponseEntity<Species>(speciesService.findSpeciesById(id), HttpStatus.OK); }
        catch(SpeciesException exception)
        { throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Species Not Found"); }
    }

    // Create New Species
    @PostMapping("/create")
    public ResponseEntity<Species> createSpecies(@RequestBody Species species) {
        Species moddedSpecies = speciesService.createNewSpecies(species);
        return new ResponseEntity<Species>(moddedSpecies, HttpStatus.OK);
    }

    // Update Species Information
    @PutMapping("/update/{id}")
    public ResponseEntity<Species> modSpecies(@PathVariable("id") int id, @RequestBody Species species) {
        Species moddedSpecies = speciesService.modifySpeciesData(id, species);
        return new ResponseEntity<Species>(moddedSpecies, HttpStatus.OK);
    }

    // Delete A Species By Id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteSpecies(@PathVariable("id") int id) {
        boolean deleted = false;
        Map<String, Boolean> response = new HashMap<>();

        try {
            deleted = speciesService.deleteSpecies(id);
            response.put("deleted", deleted);

            return ResponseEntity.ok(response);
        }
        catch(SpeciesException exception)
        { throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Species Not Found"); }
    }
}
