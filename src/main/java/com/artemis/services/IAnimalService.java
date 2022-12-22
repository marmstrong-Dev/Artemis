package com.artemis.services;

import com.artemis.entities.Animal;
import java.util.List;

public interface IAnimalService {
    List<Animal> findAllAnimals();
    Animal findAnimal(int id);
    Animal createAnimal(Animal candidate);
    List<Animal> findAnimalsBySpecies(int species_id);
    List<Animal> findAnimalsByKeeper(int keeper_id);
    Animal modifyAnimalData(int id, Animal animal);
    boolean deleteAnimal(int id);
}
