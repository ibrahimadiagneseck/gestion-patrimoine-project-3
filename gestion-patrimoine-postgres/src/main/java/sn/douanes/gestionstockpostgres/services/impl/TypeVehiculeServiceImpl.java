package sn.douanes.gestionstockpostgres.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.douanes.gestionstockpostgres.entities.TypeVehicule;
import sn.douanes.gestionstockpostgres.repositories.TypeVehiculeRepository;
import sn.douanes.gestionstockpostgres.services.TypeVehiculeService;


@Service
public class TypeVehiculeServiceImpl implements TypeVehiculeService {

    @Autowired
    TypeVehiculeRepository typeVehiculeRepository;

    @Override
    public TypeVehicule saveTypeVehicule(TypeVehicule t) {
        return typeVehiculeRepository.save(t);
    }

    @Override
    public TypeVehicule updateTypeVehicule(TypeVehicule t) {
        return typeVehiculeRepository.save(t);
    }

    @Override
    public void deleteTypeVehicule(TypeVehicule t) {
        typeVehiculeRepository.delete(t);
    }

    @Override
    public void deleteTypeVehiculeById(String id) {
        typeVehiculeRepository.deleteById(id);
    }

    @Override
    public TypeVehicule getTypeVehiculeById(String id) {
        return typeVehiculeRepository.findById(id).isPresent() ? typeVehiculeRepository.findById(id).get() : null;
    }

    @Override
    public List<TypeVehicule> getAllTypeVehicules() {
        return typeVehiculeRepository.findAll();
    }


    @Override
    public TypeVehicule ajouterTypeVehicule(
            String codeTypeVehicule,
            String libelleTypeVehicule
    ) {

        TypeVehicule typeVehicule = new TypeVehicule();

        typeVehicule.setCodeTypeVehicule(codeTypeVehicule);
        typeVehicule.setLibelleTypeVehicule(libelleTypeVehicule);


        return typeVehiculeRepository.save(typeVehicule);
    }



}
