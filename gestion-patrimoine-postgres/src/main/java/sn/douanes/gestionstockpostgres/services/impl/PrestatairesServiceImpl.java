package sn.douanes.gestionstockpostgres.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.douanes.gestionstockpostgres.entities.BordereauLivraison;
import sn.douanes.gestionstockpostgres.entities.Prestataires;
import sn.douanes.gestionstockpostgres.entities.SecteurActivite;
import sn.douanes.gestionstockpostgres.exception.entities.PrestatairesExistException;
import sn.douanes.gestionstockpostgres.exception.entities.PrestatairesNotFoundException;
import sn.douanes.gestionstockpostgres.repositories.BordereauLivraisonRepository;
import sn.douanes.gestionstockpostgres.repositories.PrestatairesRepository;
import sn.douanes.gestionstockpostgres.services.PrestatairesService;

import java.util.*;

import static sn.douanes.gestionstockpostgres.constants.ApplicationConstants.PRESTATAIRES_ALREADY_EXISTS;


@Service
public class PrestatairesServiceImpl implements PrestatairesService {

    @Autowired
    PrestatairesRepository prestatairesRepository;

    @Autowired
    BordereauLivraisonRepository bordereauLivraisonRepository;

    @Override
    public Prestataires savePrestataires(Prestataires p) throws PrestatairesExistException {
        Prestataires prestataires = getPrestatairesById(p.getNinea());

        if(prestataires != null) {
            throw new PrestatairesExistException(PRESTATAIRES_ALREADY_EXISTS);
        } else {
            return prestatairesRepository.save(p);
        }

    }

    @Override
    public Prestataires updatePrestataires(Prestataires p) throws PrestatairesNotFoundException {
        return prestatairesRepository.save(p);
    }

    @Override
    public void deletePrestataires(Prestataires p) {
        prestatairesRepository.delete(p);
    }

    @Override
    public void deletePrestatairesById(String id) {
        // bordereauLivraisonRepository.existsByNinea(ninea)
        Prestataires prestataires = getPrestatairesById(id);
        List<BordereauLivraison> bordereaux = bordereauLivraisonRepository.findAllByNinea(prestataires);
        for (BordereauLivraison bordereau : bordereaux) {
            bordereau.setNinea(null);  // Mettez à jour la référence à null ou une autre valeur appropriée
            bordereauLivraisonRepository.save(bordereau);
        }

        prestatairesRepository.deleteById(id);
    }
    

    @Override
    public Prestataires getPrestatairesById(String id) {
        return prestatairesRepository.findById(id).isPresent() ? prestatairesRepository.findById(id).get() : null;
    }

    @Override
    public List<Prestataires> getAllPrestataires() {
        return prestatairesRepository.findAll();
    }


    @Override
    public Prestataires ajouterPrestataires(
            String ninea,
            String raisonSociale,
            Integer numeroTelephone,
            String adresseEmail,
            String adresse,
            Set<SecteurActivite> secteurActivite
    ) throws PrestatairesExistException {


        Prestataires prestataires = getPrestatairesById(ninea);

        if(prestataires != null) {
            throw new PrestatairesExistException(PRESTATAIRES_ALREADY_EXISTS);
        } else {
            prestataires = new Prestataires();
            prestataires.setNinea(ninea);
            prestataires.setRaisonSociale(raisonSociale);
            prestataires.setNumeroTelephone(numeroTelephone);
            prestataires.setAdresseEmail(adresseEmail);
            prestataires.setAdresse(adresse);
            return prestatairesRepository.save(prestataires);
        }

    }

    @Override
    public List<Prestataires> getAllPrestatairesWithSecteursActivite() {
        return prestatairesRepository.findAllWithSecteursActivite();
    }

    @Override
    public Set<SecteurActivite> getSecteurActiviteByPrestataires(Prestataires prestataire) {
        Optional<Prestataires> optionalPrestataire = Optional.ofNullable(prestataire);
        return optionalPrestataire.map(p -> p.getSecteurActivite()).orElse(new HashSet<>());
    }



}
