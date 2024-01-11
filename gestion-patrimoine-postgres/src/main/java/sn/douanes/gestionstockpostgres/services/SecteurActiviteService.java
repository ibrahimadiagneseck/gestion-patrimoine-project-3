package sn.douanes.gestionstockpostgres.services;

import sn.douanes.gestionstockpostgres.entities.Prestataires;
import sn.douanes.gestionstockpostgres.entities.SecteurActivite;

import java.util.List;
import java.util.Set;

public interface SecteurActiviteService {

    SecteurActivite saveSecteurActivite(SecteurActivite s);
    SecteurActivite updateSecteurActivite(SecteurActivite s);
    void deleteSecteurActivite(SecteurActivite s);
    void deleteSecteurActiviteById(String id);
    SecteurActivite getSecteurActiviteById(String id);
    List<SecteurActivite> getAllSecteurActivites();


    SecteurActivite ajouterSecteurActivite(String codeSecteurActivite, String libelleSecteurActivite);

}
