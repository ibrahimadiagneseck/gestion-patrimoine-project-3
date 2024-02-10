package sn.douanes.gestionstockpostgres.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "lieu_stockage_vehicule")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class LieuStockageVehicule {

    @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
    // @Column(name = "code_type_vehicule", nullable = false, updatable = false)
    // @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "code_lieu_vh", length = 3)
    private String codeLieuVH;

    @Column(name = "libellle_lieu_vh", length = 100)
    private String libellleLieuVH;

    @Column(name = "nombre_limite_stockage_vh")
    private Integer nombreLimiteStockageVH;


}
