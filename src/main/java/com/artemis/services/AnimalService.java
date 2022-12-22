package com.artemis.services;

import com.artemis.exceptions.AnimalException;
import com.artemis.repositories.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.artemis.entities.Animal;
import java.util.List;
import java.util.Optional;

@Service
public class AnimalService implements IAnimalService {
    @Autowired
    private AnimalRepository animalRepo;

    @Override
    public List<Animal> findAllAnimals() {
        return (List<Animal>) animalRepo.findAll();
    }

    @Override
    public Animal findAnimal(int id) {
        Optional<Animal> optionalAnimal = animalRepo.findById(id);

        if(optionalAnimal.isPresent())
        { return optionalAnimal.get(); }
        else
        { throw new AnimalException("Animal Not Found"); }
    }

    @Override
    public Animal createAnimal(Animal candidate) {
        animalRepo.save(candidate);
        return candidate;
    }

    @Override
    public List<Animal> findAnimalsBySpecies(int species_id) {
        return animalRepo.findBySpecies(species_id);
    }

    @Override
    public List<Animal> findAnimalsByKeeper(int keeper_id) {
        return animalRepo.findByKeeper(keeper_id);
    }

    @Override
    public Animal modifyAnimalData(int id, Animal animal) {
        Optional<Animal> moddedAnimal = animalRepo.findById(id);

        if(moddedAnimal.isPresent()) {
            Animal updatedAnimal = moddedAnimal.get();

            updatedAnimal.setName(animal.getName());
            updatedAnimal.setDescription(animal.getDescription());

            return animalRepo.save(updatedAnimal);
        }
        else
        { throw new AnimalException("Animal Not Found"); }
    }

    @Override
    public boolean deleteAnimal(int id) {
        Optional<Animal> animal = animalRepo.findById(id);

        if(animal.isPresent()) {
            animalRepo.delete(animal.get());
            return true;
        }
        else
        { throw new AnimalException("Animal Not Found - Unable To Delete"); }
    }
}
