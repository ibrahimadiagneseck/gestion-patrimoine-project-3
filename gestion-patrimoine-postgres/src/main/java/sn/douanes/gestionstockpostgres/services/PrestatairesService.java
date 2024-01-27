package sn.douanes.gestionstockpostgres.services;

import sn.douanes.gestionstockpostgres.entities.Prestataires;
import sn.douanes.gestionstockpostgres.entities.SecteurActivite;
import sn.douanes.gestionstockpostgres.exception.entities.PrestatairesExistException;
import sn.douanes.gestionstockpostgres.exception.entities.PrestatairesNotFoundException;

import java.util.List;
import java.util.Set;

public interface PrestatairesService {

    Prestataires savePrestataires(Prestataires p) throws PrestatairesExistException;
    Prestataires updatePrestataires(Prestataires p) throws PrestatairesNotFoundException;
    void deletePrestataires(Prestataires p);
    void deletePrestatairesById(String id);
    Prestataires getPrestatairesById(String id);
    List<Prestataires> getAllPrestataires();


    Prestataires ajouterPrestataires(String ninea, String raisonSociale, Integer numeroTelephone, String adresseEmail, String adresse, Set<SecteurActivite> secteurActivite) throws PrestatairesExistException;

    List<Prestataires> getAllPrestatairesWithSecteursActivite();

    Set<SecteurActivite> getSecteurActiviteByPrestataires(Prestataires prestataire);

}
