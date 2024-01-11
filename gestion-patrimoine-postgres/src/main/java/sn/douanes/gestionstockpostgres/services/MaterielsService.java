package sn.douanes.gestionstockpostgres.services;

import sn.douanes.gestionstockpostgres.entities.Materiels;

import java.util.List;

public interface MaterielsService {

    Materiels saveMateriels(Materiels m);
    Materiels updateMateriels(Materiels m);
    void deleteMateriels(Materiels m);
    void deleteMaterielsById(String id);
    Materiels getMateriels(String id);
    List<Materiels> getAllMateriels();


}
