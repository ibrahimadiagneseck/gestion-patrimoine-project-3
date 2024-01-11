package sn.douanes.gestionstockpostgres.services;

import sn.douanes.gestionstockpostgres.entities.TypeEnergie;

import java.util.List;

public interface TypeEnergieService {

    TypeEnergie saveTypeEnergie(TypeEnergie t);
    TypeEnergie updateTypeEnergie(TypeEnergie t);
    void deleteTypeEnergie(TypeEnergie t);
    void deleteTypeEnergieById(String id);
    TypeEnergie getTypeEnergieById(String id);
    List<TypeEnergie> getAllTypeEnergies();


    TypeEnergie ajouterTypeEnergie(String codeTypeEnergie, String libelleTypeEnergie);

}
