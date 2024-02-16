package sn.douanes.gestionstockpostgres.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.douanes.gestionstockpostgres.entities.*;
import sn.douanes.gestionstockpostgres.entities.keys.DotationVehiculeVehiculeId;
import sn.douanes.gestionstockpostgres.entities.keys.PrestatairesSecteurId;
import sn.douanes.gestionstockpostgres.repositories.DotationVehiculeVehiculeRepository;
import sn.douanes.gestionstockpostgres.repositories.PrestatairesSecteurRepository;
import sn.douanes.gestionstockpostgres.services.DotationVehiculeVehiculeService;

import java.util.List;


@Service
public class DotationVehiculeVehiculeServiceImpl implements DotationVehiculeVehiculeService {

    @Autowired
    DotationVehiculeVehiculeRepository dotationVehiculeVehiculeRepository;

    @Override
    public DotationVehiculeVehicule saveDotationVehiculeVehicule(DotationVehiculeVehicule d) {
        return dotationVehiculeVehiculeRepository.save(d);
    }

    @Override
    public DotationVehiculeVehicule updateDotationVehiculeVehicule(DotationVehiculeVehicule d) {
        return dotationVehiculeVehiculeRepository.save(d);
    }

    @Override
    public void deleteDotationVehiculeVehicule(DotationVehiculeVehicule d) {
        dotationVehiculeVehiculeRepository.delete(d);
    }

    @Override
    public void deleteDotationVehiculeVehiculeById(Vehicule numeroSerie, DotationVehicule identifiantDV) {
        dotationVehiculeVehiculeRepository.deleteById(new DotationVehiculeVehiculeId(numeroSerie, identifiantDV));
    }

    @Override
    public DotationVehiculeVehicule getDotationVehiculeVehiculeById(Vehicule numeroSerie, DotationVehicule identifiantDV) {
        return dotationVehiculeVehiculeRepository.findById(new DotationVehiculeVehiculeId(numeroSerie, identifiantDV)).isPresent() ? dotationVehiculeVehiculeRepository.findById(new DotationVehiculeVehiculeId(numeroSerie, identifiantDV)).get() : null;
    }

    @Override
    public DotationVehiculeVehicule getDotationVehiculeVehiculeById(Vehicule numeroSerie) {
        return dotationVehiculeVehiculeRepository.findByNumeroSerie(numeroSerie);
    }

    @Override
    public List<DotationVehiculeVehicule> getAllDotationVehiculeVehicule() {
        return dotationVehiculeVehiculeRepository.findAll();
    }


    @Override
    public DotationVehiculeVehicule ajouterDotationVehiculeVehicule(
            Vehicule numeroSerie,
            DotationVehicule identifiantDV
    ) {

        DotationVehiculeVehicule dotationVehiculeVehicule = new DotationVehiculeVehicule();

        dotationVehiculeVehicule.setNumeroSerie(numeroSerie);
        dotationVehiculeVehicule.setIdentifiantDV(identifiantDV);


        return dotationVehiculeVehiculeRepository.save(dotationVehiculeVehicule);
    }

}
