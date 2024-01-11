package sn.douanes.gestionstockpostgres.services;

import org.springframework.stereotype.Service;
import sn.douanes.gestionstockpostgres.entities.TypeMateriel;

import java.util.List;


public interface TypeMaterielService {

    TypeMateriel saveTypeMateriel(TypeMateriel t);
    TypeMateriel updateTypeMateriel(TypeMateriel t);
    void deleteTypeMateriel(TypeMateriel t);
    void deleteTypeMaterielById(String id);
    TypeMateriel getTypeMateriel(String id);
    List<TypeMateriel> getAllTypeMateriels();


}
