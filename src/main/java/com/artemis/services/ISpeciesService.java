package com.artemis.services;

import com.artemis.entities.Species;
import java.util.List;

public interface ISpeciesService {
    List<Species> findAllSpecies();
    Species findSpeciesById(int id);
    Species createNewSpecies(Species species);
    Species modifySpeciesData(int id, Species species);
    boolean deleteSpecies(int id);
}
