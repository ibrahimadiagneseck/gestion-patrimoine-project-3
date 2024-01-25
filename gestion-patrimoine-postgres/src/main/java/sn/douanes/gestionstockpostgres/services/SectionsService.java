package sn.douanes.gestionstockpostgres.services;

import sn.douanes.gestionstockpostgres.entities.Sections;
import sn.douanes.gestionstockpostgres.entities.UniteDouaniere;

import java.util.List;

public interface SectionsService {

    Sections saveSections(Sections s);
    Sections updateSections(Sections s);
    void deleteSections(Sections s);
    void deleteSectionsById(String id);
    Sections getSectionsById(String id);
    List<Sections> getAllSectionss();


    Sections ajouterSections(String codeSection, String libelleSection);

}
