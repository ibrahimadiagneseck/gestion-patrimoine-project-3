package sn.douanes.gestionstockpostgres.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.douanes.gestionstockpostgres.entities.BonPour;
import sn.douanes.gestionstockpostgres.repositories.BonPourRepository;
import sn.douanes.gestionstockpostgres.services.BonPourService;


@Service
public class BonPourServiceImpl implements BonPourService {

    @Autowired
    BonPourRepository bonPourRepository;

    @Override
    public BonPour saveBonPour(BonPour b) {
        return bonPourRepository.save(b);
    }

    @Override
    public BonPour updateBonPour(BonPour b) {
        return bonPourRepository.save(b);
    }

    @Override
    public void deleteBonPour(BonPour b) {
        bonPourRepository.delete(b);
    }

    @Override
    public void deleteBonPourById(String id) {
        bonPourRepository.deleteById(id);
    }

    @Override
    public BonPour getBonPour(String id) {
        return bonPourRepository.findById(id).get();
    }

    @Override
    public List<BonPour> getAllBonPours() {
        return bonPourRepository.findAll();
    }



}
