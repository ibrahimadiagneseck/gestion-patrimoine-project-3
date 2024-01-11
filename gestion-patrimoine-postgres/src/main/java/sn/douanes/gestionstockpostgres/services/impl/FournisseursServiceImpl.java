package sn.douanes.gestionstockpostgres.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.douanes.gestionstockpostgres.entities.Fournisseurs;
import sn.douanes.gestionstockpostgres.repositories.FournisseursRepository;
import sn.douanes.gestionstockpostgres.services.FournisseursService;


@Service
public class FournisseursServiceImpl implements FournisseursService {

    @Autowired
    FournisseursRepository fournisseursRepository;

    @Override
    public Fournisseurs saveFournisseurs(Fournisseurs f) {
        return fournisseursRepository.save(f);
    }

    @Override
    public Fournisseurs updateFournisseurs(Fournisseurs f) {
        return fournisseursRepository.save(f);
    }

    @Override
    public void deleteFournisseurs(Fournisseurs f) {
        fournisseursRepository.delete(f);
    }

    @Override
    public void deleteFournisseursById(String id) {
        fournisseursRepository.deleteById(id);
    }

    @Override
    public Fournisseurs getFournisseurs(String id) {
        return fournisseursRepository.findById(id).get();
    }

    @Override
    public List<Fournisseurs> getAllFournisseurs() {
        return fournisseursRepository.findAll();
    }



}
