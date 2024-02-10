package sn.douanes.gestionstockpostgres.services;

import sn.douanes.gestionstockpostgres.entities.*;
import sn.douanes.gestionstockpostgres.exception.entities.PrestatairesExistException;

import java.sql.Date;
import java.util.List;
import java.util.Set;

public interface DotationVehiculeService {

    DotationVehicule saveDotationVehicule(DotationVehicule d);
    DotationVehicule updateDotationVehicule(DotationVehicule d);
    void deleteDotationVehicule(DotationVehicule d);
    void deleteDotationVehiculeById(String id);
    DotationVehicule getDotationVehiculeById(String id);
    List<DotationVehicule> getAllDotationVehicules();

    DotationVehicule ajouterDotationVehicule(ArticleBonSortie identifiantBS, Agent matriculeAgent, Set<Vehicule> vehiculeDotation);




}
