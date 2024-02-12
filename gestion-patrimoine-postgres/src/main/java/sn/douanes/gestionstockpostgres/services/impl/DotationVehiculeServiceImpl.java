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
import java.util.Set;


@Service
public class DotationVehiculeServiceImpl implements DotationVehiculeService {

    @Autowired
    DotationVehiculeRepository dotationVehiculeRepository;

    @Override
    public DotationVehicule saveDotationVehicule(DotationVehicule d) {
        return dotationVehiculeRepository.save(d);
    }

    @Override
    public DotationVehicule updateDotationVehicule(DotationVehicule d) {
        return dotationVehiculeRepository.save(d);
    }

    @Override
    public void deleteDotationVehicule(DotationVehicule d) {
        dotationVehiculeRepository.delete(d);
    }

    @Override
    public void deleteDotationVehiculeById(String id) {
        dotationVehiculeRepository.deleteById(id);
    }

    @Override
    public DotationVehicule getDotationVehiculeById(String id) {
        return dotationVehiculeRepository.findById(id).isPresent() ? dotationVehiculeRepository.findById(id).get() : null;
    }



    @Override
    public List<DotationVehicule> getAllDotationVehicules() {
        return dotationVehiculeRepository.findAll();
    }


    @Override
    public DotationVehicule ajouterDotationVehicule(

            ArticleBonSortie identifiantBS,
            Agent matriculeAgent,
            Set<Vehicule> vehiculeDotation
    ) {

        DotationVehicule dotationVehicule = new DotationVehicule();


        dotationVehicule.setIdentifiantDV(genererIdentifiantDV("SG", genererDateEnregistrement(new Timestamp(System.currentTimeMillis()))));



        dotationVehicule.setIdentifiantBS(identifiantBS);
        dotationVehicule.setDateDotation(new Date(System.currentTimeMillis()));
        dotationVehicule.setMatriculeAgent(matriculeAgent);
        dotationVehicule.setVehiculeDotation(vehiculeDotation);

        return dotationVehiculeRepository.save(dotationVehicule);
    }

    private String genererIdentifiantDV(String codeSection, String dateDotation) {
        // Timestamp t = new Timestamp(System.currentTimeMillis())
        return "DV" + codeSection + dateDotation;
    }


    private String genererDateEnregistrement(Timestamp dateEnregistrement) {
        // Timestamp t = new Timestamp(System.currentTimeMillis())
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
        return dateEnregistrement.toLocalDateTime().format(formatter);
    }



}
