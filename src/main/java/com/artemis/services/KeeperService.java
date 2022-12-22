package com.artemis.services;

import com.artemis.entities.Keeper;
import com.artemis.exceptions.KeeperException;
import com.artemis.repositories.KeeperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class KeeperService implements IKeeperService {
    @Autowired
    private KeeperRepository keeperRepo;

    @Override
    public List<Keeper> findAllKeepers() {
        return(List<Keeper>) keeperRepo.findAll();
    }

    @Override
    public Keeper findKeeperById(int id) {
        Optional<Keeper> optionalKeeper = keeperRepo.findById(id);

        if(optionalKeeper.isPresent())
        { return optionalKeeper.get(); }
        else
        { throw new KeeperException("Keeper Not Found"); }
    }

    @Override
    public Keeper createNewKeeper(Keeper keeper) {
        keeper.setStartDate(Date.from(Instant.now()));
        return keeperRepo.save(keeper);
    }

    @Override
    public Keeper modifyKeeperData(int id, Keeper keeper) {
        Optional<Keeper> moddedKeeper = keeperRepo.findById(id);

        if(moddedKeeper.isPresent()) {
            Keeper updatedKeeper = moddedKeeper.get();

            updatedKeeper.setFirstName(keeper.getFirstName());
            updatedKeeper.setLastName(keeper.getLastName());
            updatedKeeper.setEmailAddress(keeper.getEmailAddress());
            updatedKeeper.setPhoneNumber(keeper.getPhoneNumber());

            return keeperRepo.save(updatedKeeper);
        }
        else
        { throw new KeeperException("Keeper Not Found"); }
    }

    @Override
    public boolean deleteKeeper(int id) {
        Optional<Keeper> keeper = keeperRepo.findById(id);

        if(keeper.isPresent()) {
            keeperRepo.delete(keeper.get());
            return true;
        }
        else
        { throw new KeeperException("Keeper Not Found - Unable To Delete"); }
    }
}
