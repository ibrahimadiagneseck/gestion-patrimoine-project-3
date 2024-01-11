package sn.douanes.gestionstockpostgres.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;


@Entity
@Table(name = "etat_vehicule")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class EtatVehicule {

    @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
    // @Column(name = "code_marque", nullable = false, updatable = false)
    // @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "code_etat", length = 10)
    private String codeEtat;

    @Column(name = "libelle_etat", length = 10)
    private String libelleEtat;

}