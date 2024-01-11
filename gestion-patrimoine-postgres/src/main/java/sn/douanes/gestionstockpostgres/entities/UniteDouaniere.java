package sn.douanes.gestionstockpostgres.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "unite_douaniere")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UniteDouaniere {

    @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
    // @Column(name = "code_unite_douaniere", nullable = false, updatable = false)
    // @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "code_unite_douaniere", length = 3)
    private String codeUniteDouaniere;


    @Column(name = "nom_unite_douaniere")
    private String nomUniteDouaniere;

    @Column(name = "effectif_unite_douaniere")
    private Integer effectifUniteDouaniere;

    @Column(name = "nombre_arme")
    private Integer nombreArme;

    @Column(name = "nombre_automobile")
    private Integer nombreAutomobile;

    @Column(name = "nombre_materiel")
    private Integer nombreMateriel;


    @ManyToOne
    @JoinColumn(name = "code_type_unite_douaniere")
    private TypeUniteDouaniere codeTypeUniteDouaniere;

}