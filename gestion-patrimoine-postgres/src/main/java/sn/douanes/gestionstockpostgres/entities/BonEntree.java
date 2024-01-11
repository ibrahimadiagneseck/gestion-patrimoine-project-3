package sn.douanes.gestionstockpostgres.entities;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;


@Entity
@Table(name = "bon_entree")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class BonEntree {

    @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
    // @Column(name = "identifiant_b_e", nullable = false, updatable = false)
    // @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "identifiant_b_e", length = 25)
    private String identifiantBE;

    @Column(name = "numero_b_e", length = 100, unique = true)
    private String numeroBE;

    @Column(name = "libelle_bon_entree")
    private String libelleBonEntree;

    @Column(name = "date_bon_entree")
    private Date dateBonEntree;

    @Column(name = "observation_bon_entree")
    private String observationBonEntree;


    @ManyToOne
    @JoinColumn(name = "identifiant_b_l")
    private BordereauLivraison identifiantBL;


}