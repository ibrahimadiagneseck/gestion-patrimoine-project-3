package sn.douanes.gestionstockpostgres.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.douanes.gestionstockpostgres.entities.Pays;
import sn.douanes.gestionstockpostgres.repositories.PaysRepository;
import sn.douanes.gestionstockpostgres.services.PaysService;

import java.util.List;


@Service
public class PaysServiceImpl implements PaysService {

    @Autowired
    PaysRepository paysRepository;

    @Override
    public Pays savePays(Pays p) {
        return paysRepository.save(p);
    }

    @Override
    public Pays updatePays(Pays p) {
        return paysRepository.save(p);
    }

    @Override
    public void deletePays(Pays p) {
        paysRepository.delete(p);
    }

    @Override
    public void deletePaysById(String id) {
        paysRepository.deleteById(id);
    }

    @Override
    public Pays getPaysById(String id) {
        return paysRepository.findById(id).isPresent() ? paysRepository.findById(id).get() : null;
    }

    @Override
    public List<Pays> getAllPays() {
        return paysRepository.findAll();
    }


    @Override
    public Pays ajouterPays(
            String codePays,
            String libellePays
    ) {

        Pays pays = new Pays();

        pays.setCodePays(codePays);
        pays.setLibellePays(libellePays);

        return paysRepository.save(pays);
    }


}
