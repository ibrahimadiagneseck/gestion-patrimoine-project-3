package sn.douanes.gestionstockpostgres.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sn.douanes.gestionstockpostgres.entities.keys.DotationVehiculeId;
import sn.douanes.gestionstockpostgres.entities.keys.DotationVehiculeVehiculeId;

@Entity
@IdClass(DotationVehiculeVehiculeId.class)
@Table(name = "dotation_vehicule_vehicule")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class DotationVehiculeVehicule {

    @Id
    @ManyToOne
    @JoinColumn(name = "numero_serie")
    private Vehicule numeroSerie;

    @Id
    @ManyToOne
    @JoinColumn(name = "identifiant_d_v")
    private DotationVehicule identifiantDV;

}
