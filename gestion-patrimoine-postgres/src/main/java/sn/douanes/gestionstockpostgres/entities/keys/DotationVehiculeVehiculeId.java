package sn.douanes.gestionstockpostgres.entities.keys;

import sn.douanes.gestionstockpostgres.entities.DotationVehicule;
import sn.douanes.gestionstockpostgres.entities.Prestataires;
import sn.douanes.gestionstockpostgres.entities.SecteurActivite;
import sn.douanes.gestionstockpostgres.entities.Vehicule;

import java.io.Serializable;

public class DotationVehiculeVehiculeId implements Serializable {

    private Vehicule numeroSerie;

    private DotationVehicule identifiantDV;


    public DotationVehiculeVehiculeId() {

    }

    public DotationVehiculeVehiculeId(Vehicule numeroSerie, DotationVehicule identifiantDV) {
        this.numeroSerie = numeroSerie;
        this.identifiantDV = identifiantDV;
    }
}
