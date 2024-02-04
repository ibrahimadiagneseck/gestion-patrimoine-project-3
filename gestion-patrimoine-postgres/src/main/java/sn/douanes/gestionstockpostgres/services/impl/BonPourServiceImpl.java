package sn.douanes.gestionstockpostgres.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.douanes.gestionstockpostgres.entities.*;
import sn.douanes.gestionstockpostgres.repositories.BonPourRepository;
import sn.douanes.gestionstockpostgres.services.BonPourService;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;
import java.util.List;


@Service
public class BonPourServiceImpl implements BonPourService {

    @Autowired
    BonPourRepository BonPourRepository;

    @Override
    public BonPour saveBonPour(BonPour b) {
        return BonPourRepository.save(b);
    }


    @Override
    public BonPour updateBonPour(BonPour b) {
        return BonPourRepository.save(b);
    }

    @Override
    public void deleteBonPour(BonPour b) {
        BonPourRepository.delete(b);
    }

    @Override
    public void deleteBonPourById(String id) {
        BonPourRepository.deleteById(id);
    }

    @Override
    public BonPour getBonPourById(String id) {
        return BonPourRepository.findById(id).isPresent() ? BonPourRepository.findById(id).get() : null;
    }

    @Override
    public List<BonPour> getAllBonPours() {
        return BonPourRepository.findAll();
    }

    @Override
    public BonPour ajouterBonPour(
            String descriptionBP,
            Integer numeroCourrielOrigine,
            Date dateCourrielOrigine,
            String etatBP,
            String objectCourrielOrigine,
            Integer numeroArriveDLF,
            Date dateArriveDLF,
            String observationDLF,
            Integer numeroArriveBLM,
            Date dateArriveBLM,
            String observationBLM,
            Integer numeroArriveSection,
            Date dateArriveSection,
            String observationSection,
            UniteDouaniere codeUniteDouaniere,
            Sections codeSection,
            Agent matriculeAgent
    ) {

        BonPour bonPour = new BonPour();
        bonPour.setDateEnregistrement(new Timestamp(System.currentTimeMillis()));
        bonPour.setIdentifiantBP(genererIdentifiantBE(codeSection.getCodeSection(), genererDateEnregistrement(bonPour.getDateEnregistrement())));

        bonPour.setDescriptionBP(descriptionBP);
        bonPour.setNumeroCourrielOrigine(numeroCourrielOrigine);
        bonPour.setDateCourrielOrigine(dateCourrielOrigine);
        bonPour.setEtatBP(etatBP);
        bonPour.setObjectCourrielOrigine(objectCourrielOrigine);
        bonPour.setNumeroArriveDLF(numeroArriveDLF);
        bonPour.setDateArriveDLF(dateArriveDLF);
        bonPour.setObservationDLF(observationDLF);
        bonPour.setNumeroArriveBLM(numeroArriveBLM);
        bonPour.setDateArriveBLM(dateArriveBLM);
        bonPour.setObservationBLM(observationBLM);
        bonPour.setNumeroArriveSection(numeroArriveSection);
        bonPour.setDateArriveSection(dateArriveSection);
        bonPour.setObservationSection(observationSection);
        bonPour.setCodeUniteDouaniere(codeUniteDouaniere);
        bonPour.setCodeSection(codeSection);
        bonPour.setMatriculeAgent(matriculeAgent);


        return BonPourRepository.save(bonPour);
    }


    private String genererIdentifiantBE(String codeSection, String dateEnregistrement) {
        // Timestamp t = new Timestamp(System.currentTimeMillis())
        return "BP" + codeSection + dateEnregistrement;
    }


    private String genererDateEnregistrement(Timestamp dateEnregistrement) {
        // Timestamp t = new Timestamp(System.currentTimeMillis())
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
        return dateEnregistrement.toLocalDateTime().format(formatter);
    }

}
