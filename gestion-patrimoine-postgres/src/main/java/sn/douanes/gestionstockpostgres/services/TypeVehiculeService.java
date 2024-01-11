package sn.douanes.gestionstockpostgres.services;

import sn.douanes.gestionstockpostgres.entities.TypeVehicule;

import java.util.List;

public interface TypeVehiculeService {

    TypeVehicule saveTypeVehicule(TypeVehicule t);
    TypeVehicule updateTypeVehicule(TypeVehicule t);
    void deleteTypeVehicule(TypeVehicule t);
    void deleteTypeVehiculeById(String id);
    TypeVehicule getTypeVehiculeById(String id);
    List<TypeVehicule> getAllTypeVehicules();


    TypeVehicule ajouterTypeVehicule(String codeTypeVehicule, String libelleTypeVehicule);

}
