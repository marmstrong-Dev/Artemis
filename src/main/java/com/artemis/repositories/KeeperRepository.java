package com.artemis.repositories;

import org.springframework.data.repository.CrudRepository;
import com.artemis.entities.Keeper;

public interface KeeperRepository extends CrudRepository<Keeper, Integer> {
}
