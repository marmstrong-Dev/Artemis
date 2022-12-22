package com.artemis.services;

import com.artemis.exceptions.SpeciesException;
import com.artemis.repositories.SpeciesRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.artemis.entities.Species;
import java.util.List;
import java.util.Optional;

@Service
public class SpeciesService implements ISpeciesService {
    @Autowired
    private SpeciesRepository speciesRepo;

    @Override
    public List<Species> findAllSpecies() {
        return (List<Species>) speciesRepo.findAll();
    }

    @Override
    public Species findSpeciesById(int id) {
        Optional<Species> optionalSpecies = speciesRepo.findById(id);

        if(optionalSpecies.isPresent())
        { return optionalSpecies.get(); }
        else
        { throw new SpeciesException("Species Not Found"); }
    }

    @Override
    public Species createNewSpecies(Species species) {
        return speciesRepo.save(species);
    }

    @Override
    public Species modifySpeciesData(int id, Species species) {
        Optional<Species> moddedSpecies = speciesRepo.findById(id);

        if(moddedSpecies.isPresent()) {
            Species updatedSpecies = moddedSpecies.get();

            updatedSpecies.setName(species.getName());
            updatedSpecies.setType(species.getType());
            updatedSpecies.setBinomial(species.getBinomial());
            updatedSpecies.setFamily(species.getFamily());
            updatedSpecies.setGenus(species.getGenus());

            return speciesRepo.save(updatedSpecies);
        }
        else
        { throw new SpeciesException("Species Not Found"); }
    }

    @Override
    public boolean deleteSpecies(int id) {
        Optional<Species> species = speciesRepo.findById(id);

        if(species.isPresent()) {
            speciesRepo.delete(species.get());
            return true;
        }
        else
        { throw new SpeciesException("Species Not Found - Unable To Delete"); }
    }
}
