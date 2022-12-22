package com.artemis.controllers;

import com.artemis.entities.Keeper;
import com.artemis.exceptions.KeeperException;
import com.artemis.services.KeeperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/keepers")
public class KeeperController {
    @Autowired
    private KeeperService keeperService;

    // Fetch All Keepers
    @GetMapping("/all")
    public ResponseEntity<List<Keeper>> getAllSpecies() {
        List<Keeper> keeperList = keeperService.findAllKeepers();
        return new ResponseEntity<List<Keeper>>(keeperList, HttpStatus.OK);
    }

    // Fetch One Keeper By Id
    @GetMapping("/find/{id}")
    public ResponseEntity<Keeper> getKeeperById(@PathVariable("id") int id) {
        try
        { return new ResponseEntity<Keeper>(keeperService.findKeeperById(id), HttpStatus.OK); }
        catch (KeeperException exception)
        { throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Keeper Not Found"); }
    }

    // Create New Keeper
    @PostMapping("/create")
    public ResponseEntity<Keeper> createKeeper(@RequestBody Keeper keeper) {
        Keeper candidateKeeper = keeperService.createNewKeeper(keeper);
        return new ResponseEntity<Keeper>(candidateKeeper, HttpStatus.OK);
    }

    // Update Keeper Information
    @PutMapping("/update/{id}")
    public ResponseEntity<Keeper> modKeeper(@PathVariable("id") int id, @RequestBody Keeper keeper) {
        Keeper moddedKeeper = keeperService.modifyKeeperData(id, keeper);
        return new ResponseEntity<Keeper>(moddedKeeper, HttpStatus.OK);
    }

    // Delete Keeper
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteKeeper(@PathVariable("id") int id) {
        boolean deleted = false;
        Map<String, Boolean> response = new HashMap<>();

        try {
            deleted = keeperService.deleteKeeper(id);
            response.put("deleted", deleted);

            return ResponseEntity.ok(response);
        }
        catch(KeeperException exception)
        { throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Keeper Not Found"); }
    }
}
