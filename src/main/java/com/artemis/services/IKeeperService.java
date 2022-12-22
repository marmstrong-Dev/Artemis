package com.artemis.services;

import com.artemis.entities.Keeper;
import java.util.List;

public interface IKeeperService {
    List<Keeper> findAllKeepers();
    Keeper findKeeperById(int id);
    Keeper createNewKeeper(Keeper keeper);
    Keeper modifyKeeperData(int id, Keeper keeper);
    boolean deleteKeeper(int id);
}
