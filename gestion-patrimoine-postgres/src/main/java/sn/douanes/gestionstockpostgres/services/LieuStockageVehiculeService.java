package sn.douanes.gestionstockpostgres.services;



import sn.douanes.gestionstockpostgres.entities.LieuStockageVehicule;

import java.util.List;

public interface LieuStockageVehiculeService {

    LieuStockageVehicule saveLieuStockageVehicule(LieuStockageVehicule l);
    LieuStockageVehicule updateLieuStockageVehicule(LieuStockageVehicule l);
    void deleteLieuStockageVehicule(LieuStockageVehicule l);
    void deleteLieuStockageVehiculeById(String id);
    LieuStockageVehicule getLieuStockageVehiculeById(String id);
    List<LieuStockageVehicule> getAllLieuStockageVehicules();


    LieuStockageVehicule ajouterLieuStockageVehicule(String codeLieuVH, String libellleLieuVH,Integer nombreLimiteStockageVH);
}
