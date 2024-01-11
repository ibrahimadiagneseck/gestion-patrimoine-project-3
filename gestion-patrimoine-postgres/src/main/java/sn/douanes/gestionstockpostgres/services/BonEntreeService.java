package sn.douanes.gestionstockpostgres.services;


import sn.douanes.gestionstockpostgres.entities.BonEntree;
import sn.douanes.gestionstockpostgres.entities.BordereauLivraison;

import java.sql.Date;
import java.util.List;

public interface BonEntreeService {

    BonEntree saveBonEntree(BonEntree b);
    BonEntree updateBonEntree(BonEntree b);
    void deleteBonEntree(BonEntree b);
    void deleteBonEntreeById(String id);
    BonEntree getBonEntreeById(String id);
    List<BonEntree> getAllBonEntrees();

    BonEntree ajouterBonEntree(String numeroBE, String libelleBonEntree, Date dateBonEntree, String observationBonEntree, BordereauLivraison identifiantBL);


}
