package sn.douanes.gestionstockpostgres.services;

import sn.douanes.gestionstockpostgres.entities.*;

import java.util.List;

public interface UniteDouaniereSectionsService {

    UniteDouaniereSections saveUniteDouaniereSections(UniteDouaniereSections uniteDouaniereSections);
    UniteDouaniereSections updateUniteDouaniereSections(UniteDouaniereSections uniteDouaniereSections);
    void deleteUniteDouaniereSections(UniteDouaniereSections uniteDouaniereSections);
    void deleteUniteDouaniereSectionsById(UniteDouaniere codeUniteDouaniere, Sections codeSection);
    UniteDouaniereSections getUniteDouaniereSectionsById(UniteDouaniere codeUniteDouaniere, Sections codeSection);
    List<UniteDouaniereSections> getAllUniteDouaniereSections();

    UniteDouaniereSections ajouterUniteDouaniereSections(UniteDouaniere codeUniteDouaniere, Sections codeSection);
}
