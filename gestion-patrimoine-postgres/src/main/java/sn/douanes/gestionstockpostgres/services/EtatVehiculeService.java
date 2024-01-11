package sn.douanes.gestionstockpostgres.services;

import sn.douanes.gestionstockpostgres.entities.EtatVehicule;

import java.util.List;

public interface EtatVehiculeService {

    EtatVehicule saveEtatVehicule(EtatVehicule e);
    EtatVehicule updateEtatVehicule(EtatVehicule e);
    void deleteEtatVehicule(EtatVehicule e);
    void deleteEtatVehiculeById(String id);
    EtatVehicule getEtatVehiculeById(String id);
    List<EtatVehicule> getAllEtatVehicules();


    EtatVehicule ajouterEtatVehicule(String codeMarque, String libelleMarque);

}
