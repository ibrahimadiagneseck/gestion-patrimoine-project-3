package sn.douanes.gestionstockpostgres.services;

import sn.douanes.gestionstockpostgres.entities.UniteHierarchique;

import java.util.List;

public interface UniteHierarchiqueService {

    UniteHierarchique saveUniteHierarchique(UniteHierarchique u);
    UniteHierarchique updateUniteHierarchique(UniteHierarchique u);
    void deleteUniteHierarchique(UniteHierarchique u);
    void deleteUniteHierarchiqueById(String id);
    UniteHierarchique getUniteHierarchique(String id);
    List<UniteHierarchique> getAllUniteHierarchiques();


}
