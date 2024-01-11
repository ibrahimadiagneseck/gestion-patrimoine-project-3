package sn.douanes.gestionstockpostgres.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.douanes.gestionstockpostgres.entities.Armes;
import sn.douanes.gestionstockpostgres.repositories.ArmesRepository;
import sn.douanes.gestionstockpostgres.services.ArmesService;


@Service
public class ArmesServiceImpl implements ArmesService {

    @Autowired
    ArmesRepository armesRepository;

    @Override
    public Armes saveArmes(Armes a) {
        return armesRepository.save(a);
    }

    @Override
    public Armes updateArmes(Armes a) {
        return armesRepository.save(a);
    }

    @Override
    public void deleteArmes(Armes a) {
        armesRepository.delete(a);
    }

    @Override
    public void deleteArmesById(String id) {
        armesRepository.deleteById(id);
    }

    @Override
    public Armes getArmes(String id) {
        return armesRepository.findById(id).get();
    }

    @Override
    public List<Armes> getAllArmes() {
        return armesRepository.findAll();
    }



}
