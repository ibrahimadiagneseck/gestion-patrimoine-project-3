package sn.douanes.gestionstockpostgres.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.douanes.gestionstockpostgres.entities.TypeMateriel;
import sn.douanes.gestionstockpostgres.repositories.TypeMaterielRepository;
import sn.douanes.gestionstockpostgres.services.TypeMaterielService;


@Service
public class TypeMaterielServiceImpl implements TypeMaterielService {

    @Autowired
    TypeMaterielRepository typeMaterielRepository;

    @Override
    public TypeMateriel saveTypeMateriel(TypeMateriel t) {
        return typeMaterielRepository.save(t);
    }

    @Override
    public TypeMateriel updateTypeMateriel(TypeMateriel t) {
        return typeMaterielRepository.save(t);
    }

    @Override
    public void deleteTypeMateriel(TypeMateriel t) {
        typeMaterielRepository.delete(t);
    }

    @Override
    public void deleteTypeMaterielById(String id) {
        typeMaterielRepository.deleteById(id);
    }

    @Override
    public TypeMateriel getTypeMateriel(String id) {
        return typeMaterielRepository.findById(id).get();
    }

    @Override
    public List<TypeMateriel> getAllTypeMateriels() {
        return typeMaterielRepository.findAll();
    }



}
