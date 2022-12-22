package com.artemis.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.artemis.entities.Animal;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AnimalRepository extends CrudRepository<Animal, Integer> {
    @Query("SELECT a FROM Animal a WHERE a.species.id = :species")
    List<Animal> findBySpecies(@Param("species") int species);

    @Query("SELECT a FROM Animal a WHERE a.keeper.id = :keeper")
    List<Animal> findByKeeper(@Param("keeper") int keeper);
}
