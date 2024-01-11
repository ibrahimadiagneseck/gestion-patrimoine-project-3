package sn.douanes.gestionstockpostgres.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.douanes.gestionstockpostgres.entities.Controle;
import sn.douanes.gestionstockpostgres.repositories.ControleRepository;
import sn.douanes.gestionstockpostgres.services.ControleService;


@Service
public class ControleServiceImpl implements ControleService {

    @Autowired
    ControleRepository controleRepository;

    @Override
    public Controle saveControle(Controle c) {
        return controleRepository.save(c);
    }

    @Override
    public Controle updateControle(Controle c) {
        return controleRepository.save(c);
    }

    @Override
    public void deleteControle(Controle c) {
        controleRepository.delete(c);
    }

    @Override
    public void deleteControleById(String id) {
        controleRepository.deleteById(id);
    }

    @Override
    public Controle getControle(String id) {
        return controleRepository.findById(id).get();
    }

    @Override
    public List<Controle> getAllControles() {
        return controleRepository.findAll();
    }



}
