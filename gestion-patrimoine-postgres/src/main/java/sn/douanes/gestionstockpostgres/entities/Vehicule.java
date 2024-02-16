package sn.douanes.gestionstockpostgres.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "vehicule")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vehicule {

    @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
    // @Column(name = "numero_serie", nullable = false, updatable = false)
    // @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "numero_serie", length = 30)
    private String numeroSerie;


    @Column(name = "numero_immatriculation", length = 20)
    private String numeroImmatriculation;


    @Column(name = "modele", length = 50)
    private String modele;

    @ManyToOne
    @JoinColumn(name = "code_etat")
    private EtatVehicule codeEtat;

    @ManyToOne
    @JoinColumn(name = "code_type_energie")
    private TypeEnergie codeTypeEnergie;


    @Column(name = "numero_carte_grise", length = 30)
    private String numeroCarteGrise;

    @Column(name = "date_mise_en_circulation")
    private Date dateMiseEnCirculation;

    @ManyToOne
    @JoinColumn(name = "code_pays")
    private Pays codePays;

    @ManyToOne
    @JoinColumn(name = "code_type_vehicule")
    private TypeVehicule codeTypeVehicule;

    @ManyToOne
    @JoinColumn(name = "code_marque")
    private MarqueVehicule codeMarque;


    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "identifiant_b_e", referencedColumnName = "identifiant_b_e"),
            @JoinColumn(name = "code_article_bon_entree", referencedColumnName = "code_article_bon_entree")
    })
    private ArticleBonEntree identifiantBE;



        @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "vehiculeDotation")
    private Set<DotationVehicule> dotationVehicule = new HashSet<>();


//    @ManyToOne
//    @JoinColumns({
//            @JoinColumn(name = "identifiant_b_e", referencedColumnName = "identifiant_b_e"),
//            @JoinColumn(name = "code_article_bon_entree", referencedColumnName = "code_article_bon_entree")
//    })
//    private BonEntree identifiantBE;

//    @ManyToOne
//    @JoinColumns({
//            @JoinColumn(name = "matricule_agent", referencedColumnName = "matricule_agent"),
//            @JoinColumn(name = "code_corps_agent", referencedColumnName = "code_corps_agent")
//    })
//    private Agent matriculeAgent;

//    @ManyToOne
//    @JoinColumn(name = "code_type_objet")
//    private TypeObjet codeTypeObjet;


}
