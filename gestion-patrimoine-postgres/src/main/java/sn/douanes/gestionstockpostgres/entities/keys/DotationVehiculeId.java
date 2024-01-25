package sn.douanes.gestionstockpostgres.entities.keys;

import sn.douanes.gestionstockpostgres.entities.BonDeSortie;
import sn.douanes.gestionstockpostgres.entities.Vehicule;

import java.io.Serializable;
import java.sql.Date;

public class DotationVehiculeId implements Serializable {

    private Date dateDotation;


    private Vehicule numeroSerie;

    public DotationVehiculeId() {
    }

    public DotationVehiculeId(Date dateDotation, Vehicule numeroSerie) {
        this.dateDotation = dateDotation;
        this.numeroSerie = numeroSerie;
    }
}
