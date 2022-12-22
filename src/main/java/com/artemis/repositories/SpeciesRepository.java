package com.artemis.repositories;

import org.springframework.data.repository.CrudRepository;
import com.artemis.entities.Species;

public interface SpeciesRepository extends CrudRepository<Species, Integer> {
}
