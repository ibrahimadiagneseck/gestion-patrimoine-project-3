package sn.douanes.gestionstockpostgres.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.douanes.gestionstockpostgres.entities.*;
import sn.douanes.gestionstockpostgres.entities.keys.DotationVehiculeId;
import sn.douanes.gestionstockpostgres.repositories.DotationVehiculeRepository;
import sn.douanes.gestionstockpostgres.services.DotationVehiculeService;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;
import java.util.List;


@Service
public class DotationVehiculeServiceImpl implements DotationVehiculeService {

    @Autowired
    DotationVehiculeRepository dotationVehiculeRepository;

    @Override
    public DotationVehicule saveDotationVehicule(DotationVehicule a) {
        return dotationVehiculeRepository.save(a);
    }

    @Override
    public DotationVehicule updateDotationVehicule(DotationVehicule a) {
        return dotationVehiculeRepository.save(a);
    }

    @Override
    public void deleteDotationVehicule(DotationVehicule a) {
        dotationVehiculeRepository.delete(a);
    }

    @Override
    public void deleteDotationVehiculeById(Date dateDotation, Vehicule numeroSerie) {
        dotationVehiculeRepository.deleteById(new DotationVehiculeId(dateDotation, numeroSerie));
    }

    @Override
    public DotationVehicule getDotationVehiculeById(Date dateDotation, Vehicule numeroSerie) {
        return dotationVehiculeRepository.findById(new DotationVehiculeId(dateDotation, numeroSerie)).isPresent() ? dotationVehiculeRepository.findById(new DotationVehiculeId(dateDotation, numeroSerie)).get() : null;
    }



    @Override
    public List<DotationVehicule> getAllDotationVehicules() {
        return dotationVehiculeRepository.findAll();
    }


    @Override
    public DotationVehicule ajouterDotationVehicule(
            Vehicule numeroSerie,
            ArticleBonSortie identifiantBS,
            Agent matriculeAgent
    ) {

        DotationVehicule dotationVehicule = new DotationVehicule();

        dotationVehicule.setDateDotation(new Timestamp(System.currentTimeMillis()));

        dotationVehicule.setNumeroSerie(numeroSerie);
        dotationVehicule.setIdentifiantBS(identifiantBS);
        dotationVehicule.setMatriculeAgent(matriculeAgent);

        return dotationVehiculeRepository.save(dotationVehicule);
    }



}
