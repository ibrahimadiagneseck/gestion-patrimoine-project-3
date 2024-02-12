package sn.douanes.gestionstockpostgres.services;


import jakarta.persistence.*;
import sn.douanes.gestionstockpostgres.entities.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

public interface BonDeSortieService {

    BonDeSortie saveBonDeSortie(BonDeSortie b);
    BonDeSortie updateBonDeSortie(BonDeSortie b);
    void deleteBonDeSortie(BonDeSortie b);
    void deleteBonDeSortieById(String id);
    BonDeSortie getBonDeSortieById(String id);
    List<BonDeSortie> getAllBonDeSorties();

    BonDeSortie ajouterBonDeSortie(String numeroBS, String descriptionBS, BonPour identifiantBP, Agent matriculeAgent);


}
