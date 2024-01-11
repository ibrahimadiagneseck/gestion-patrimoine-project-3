package sn.douanes.gestionstockpostgres.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.douanes.gestionstockpostgres.entities.BonDeSortie;
import sn.douanes.gestionstockpostgres.repositories.BonDeSortieRepository;
import sn.douanes.gestionstockpostgres.services.BonDeSortieService;


@Service
public class BonDeSortieServiceImpl implements BonDeSortieService {

    @Autowired
    BonDeSortieRepository bonDeSortieRepository;

    @Override
    public BonDeSortie saveBonDeSortie(BonDeSortie b) {
        return bonDeSortieRepository.save(b);
    }

    @Override
    public BonDeSortie updateBonDeSortie(BonDeSortie b) {
        return bonDeSortieRepository.save(b);
    }

    @Override
    public void deleteBonDeSortie(BonDeSortie b) {
        bonDeSortieRepository.delete(b);
    }

    @Override
    public void deleteBonDeSortieById(String id) {
        bonDeSortieRepository.deleteById(id);
    }

    @Override
    public BonDeSortie getBonDeSortie(String id) {
        return bonDeSortieRepository.findById(id).get();
    }

    @Override
    public List<BonDeSortie> getAllBonDeSorties() {
        return bonDeSortieRepository.findAll();
    }



}
