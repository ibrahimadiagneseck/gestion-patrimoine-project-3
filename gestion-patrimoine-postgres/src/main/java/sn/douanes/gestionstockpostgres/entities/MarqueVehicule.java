package sn.douanes.gestionstockpostgres.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "marque_vehicule")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MarqueVehicule {

    @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
    // @Column(name = "code_marque", nullable = false, updatable = false)
    // @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "code_marque", length = 25)
    private String codeMarque;

    @Column(name = "libelle_marque", length = 100)
    private String libelleMarque;

}