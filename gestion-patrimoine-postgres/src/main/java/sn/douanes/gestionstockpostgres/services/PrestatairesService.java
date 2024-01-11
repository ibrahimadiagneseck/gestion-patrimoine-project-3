package sn.douanes.gestionstockpostgres.services;

import sn.douanes.gestionstockpostgres.entities.Prestataires;
import sn.douanes.gestionstockpostgres.entities.SecteurActivite;

import java.util.List;
import java.util.Set;

public interface PrestatairesService {

    Prestataires savePrestataires(Prestataires p);
    Prestataires updatePrestataires(Prestataires p);
    void deletePrestataires(Prestataires p);
    void deletePrestatairesById(String id);
    Prestataires getPrestatairesById(String id);
    List<Prestataires> getAllPrestataires();


    Prestataires ajouterPrestataires(String ninea, String raisonSociale, Integer numeroTelephone, String adresseEmail, String adresse, Set<SecteurActivite> secteurActivite);

    List<Prestataires> getAllPrestatairesWithSecteursActivite();

    Set<SecteurActivite> getSecteurActiviteByPrestataires(Prestataires prestataire);

}
