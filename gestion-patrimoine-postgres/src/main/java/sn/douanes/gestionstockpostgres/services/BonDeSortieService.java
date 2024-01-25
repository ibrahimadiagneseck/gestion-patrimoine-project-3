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

    BonDeSortie ajouterBonDeSortie(String identifiantBS, String numeroBS, String descriptionBS, Date dateBS, String observationBS, UniteDouaniere codeUniteDouaniere, Sections codeSection, ArticleBonPour identifiantBP, Agent matriculeAgent);


}
