package sn.douanes.gestionstockpostgres.services;

import sn.douanes.gestionstockpostgres.entities.*;

import java.sql.Date;
import java.util.List;

public interface DotationVehiculeService {

    DotationVehicule saveDotationVehicule(DotationVehicule a);
    DotationVehicule updateDotationVehicule(DotationVehicule a);
    void deleteDotationVehicule(DotationVehicule a);
    void deleteDotationVehiculeById(Date dateDotation, Vehicule numeroSerie);
    DotationVehicule getDotationVehiculeById(Date dateDotation, Vehicule numeroSerie);
    List<DotationVehicule> getAllDotationVehicules();

    DotationVehicule ajouterDotationVehicule(Vehicule numeroSerie, Date dateDotation, ArticleBonSortie identifiantBS, Agent matriculeAgent);


}
