package sn.douanes.gestionstockpostgres.services;

import sn.douanes.gestionstockpostgres.entities.BonPour;

import java.util.List;

public interface BonPourService {

    BonPour saveBonPour(BonPour b);
    BonPour updateBonPour(BonPour b);
    void deleteBonPour(BonPour b);
    void deleteBonPourById(String id);
    BonPour getBonPour(String id);
    List<BonPour> getAllBonPours();


}
