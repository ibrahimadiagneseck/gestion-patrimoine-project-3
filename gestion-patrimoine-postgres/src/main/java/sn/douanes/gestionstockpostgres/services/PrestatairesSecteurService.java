package sn.douanes.gestionstockpostgres.services;

import sn.douanes.gestionstockpostgres.entities.Prestataires;
import sn.douanes.gestionstockpostgres.entities.PrestatairesSecteur;
import sn.douanes.gestionstockpostgres.entities.SecteurActivite;

import java.util.List;

public interface PrestatairesSecteurService {

    PrestatairesSecteur savePrestatairesSecteur(PrestatairesSecteur p);
    PrestatairesSecteur updatePrestatairesSecteur(PrestatairesSecteur p);
    void deletePrestatairesSecteur(PrestatairesSecteur p);
    void deletePrestatairesSecteurById(Prestataires ninea, SecteurActivite codeSecteurActivite);
    PrestatairesSecteur getPrestatairesSecteurById(Prestataires ninea, SecteurActivite codeSecteurActivite);
    List<PrestatairesSecteur> getAllPrestatairesSecteur();


    PrestatairesSecteur ajouterPrestatairesSecteur(Prestataires ninea, SecteurActivite codeSecteurActivite);
}
