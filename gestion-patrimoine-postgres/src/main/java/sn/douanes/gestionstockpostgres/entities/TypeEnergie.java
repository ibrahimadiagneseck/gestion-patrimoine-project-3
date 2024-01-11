package sn.douanes.gestionstockpostgres.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;


@Entity
@Table(name = "type_energie")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class TypeEnergie {

    @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
    // @Column(name = "code_type_vehicule", nullable = false, updatable = false)
    // @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "code_type_energie", length = 25)
    private String codeTypeEnergie;

    @Column(name = "libelle_type_energie", length = 100)
    private String libelleTypeEnergie;

}