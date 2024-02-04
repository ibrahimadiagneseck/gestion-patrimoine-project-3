package sn.douanes.gestionstockpostgres.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.douanes.gestionstockpostgres.entities.*;
import sn.douanes.gestionstockpostgres.repositories.BonDeSortieRepository;
import sn.douanes.gestionstockpostgres.services.BonDeSortieService;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;
import java.util.List;


@Service
public class BonDeSortieServiceImpl implements BonDeSortieService {

    @Autowired
    BonDeSortieRepository bonDeSortieRepository;

    @Override
    public BonDeSortie saveBonDeSortie(BonDeSortie b) {
        return bonDeSortieRepository.save(b);
    }


    @Override
    public BonDeSortie updateBonDeSortie(BonDeSortie b) {
        return bonDeSortieRepository.save(b);
    }

    @Override
    public void deleteBonDeSortie(BonDeSortie b) {
        bonDeSortieRepository.delete(b);
    }

    @Override
    public void deleteBonDeSortieById(String id) {
        bonDeSortieRepository.deleteById(id);
    }

    @Override
    public BonDeSortie getBonDeSortieById(String id) {
        return bonDeSortieRepository.findById(id).isPresent() ? bonDeSortieRepository.findById(id).get() : null;
    }

    @Override
    public List<BonDeSortie> getAllBonDeSorties() {
        return bonDeSortieRepository.findAll();
    }

    @Override
    public BonDeSortie ajouterBonDeSortie(
            String numeroBS,
            String descriptionBS,
            Date dateBS,
            String observationBS,
            UniteDouaniere codeUniteDouaniere,
            Sections codeSection,
            BonPour identifiantBP,
            Agent matriculeAgent
    ) {

        BonDeSortie bonDeSortie = new BonDeSortie();

        bonDeSortie.setDateEnregistrement(new Timestamp(System.currentTimeMillis()));
        bonDeSortie.setIdentifiantBS(genererIdentifiantBS(codeSection.getCodeSection(), genererDateEnregistrement(new Timestamp(System.currentTimeMillis()))));

        bonDeSortie.setNumeroBS(numeroBS);
        bonDeSortie.setDescriptionBS(descriptionBS);
        bonDeSortie.setDateBS(dateBS);
        bonDeSortie.setObservationBS(observationBS);
        bonDeSortie.setCodeUniteDouaniere(codeUniteDouaniere);
        bonDeSortie.setCodeSection(codeSection);
        bonDeSortie.setIdentifiantBP(identifiantBP);
        bonDeSortie.setMatriculeAgent(matriculeAgent);


        return bonDeSortieRepository.save(bonDeSortie);
    }


    private String genererIdentifiantBS(String codeSection, String dateEnregistrement) {
        // Timestamp t = new Timestamp(System.currentTimeMillis())
        return "BS" + codeSection + dateEnregistrement;
    }


    private String genererDateEnregistrement(Timestamp dateEnregistrement) {
        // Timestamp t = new Timestamp(System.currentTimeMillis())
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
        return dateEnregistrement.toLocalDateTime().format(formatter);
    }

}
