package sn.douanes.gestionstockpostgres.services;


import sn.douanes.gestionstockpostgres.entities.*;

import java.sql.Date;
import java.util.List;

public interface VehiculeService {

    Vehicule saveVehicule(Vehicule v);
    Vehicule updateVehicule(Vehicule v);
    void deleteVehicule(Vehicule v);
    void deleteVehiculeById(String id);
    Vehicule getVehiculeById(String id);
    List<Vehicule> getAllVehicules();


    Vehicule ajouterVehicule(String numeroSerie, String numeroImmatriculation, String modele, EtatVehicule codeEtat, TypeEnergie codeTypeEnergie, String numeroCarteGrise, Date dateMiseEnCirculation, Pays codePays, TypeVehicule codeTypeVehicule, MarqueVehicule codeMarque, UniteDouaniere codeUniteDouaniere, ArticleBonEntree identifiantBE);


}
