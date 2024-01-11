package sn.douanes.gestionstockpostgres.services;

import sn.douanes.gestionstockpostgres.entities.BonDeSortie;

import java.util.List;

public interface BonDeSortieService {

    BonDeSortie saveBonDeSortie(BonDeSortie b);
    BonDeSortie updateBonDeSortie(BonDeSortie b);
    void deleteBonDeSortie(BonDeSortie b);
    void deleteBonDeSortieById(String id);
    BonDeSortie getBonDeSortie(String id);
    List<BonDeSortie> getAllBonDeSorties();


}
