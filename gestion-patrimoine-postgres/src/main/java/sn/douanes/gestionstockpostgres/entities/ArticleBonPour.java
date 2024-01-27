package sn.douanes.gestionstockpostgres.entities;

import jakarta.persistence.*;
import lombok.*;
import sn.douanes.gestionstockpostgres.entities.keys.ArticleBonPourId;


@Entity
@IdClass(ArticleBonPourId.class)
@Table(name = "article_bon_pour")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ArticleBonPour {

    @Id
    @Column(name = "code_article_bon_pour", length = 25)
    private String codeArticleBonPour;

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "identifiant_b_p")
    private BonPour identifiantBP;


    @Column(name = "libelle_article_bon_pour", length = 100)
    private String libelleArticleBonPour;

    @Column(name = "quantite_demandee")
    private Integer quantiteDemandee;


    @ManyToOne
    @JoinColumn(name = "code_type_objet")
    private TypeObjet codeTypeObjet;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "matricule_agent", referencedColumnName = "matricule_agent"),
            @JoinColumn(name = "code_corps_agent", referencedColumnName = "code_corps_agent")
    })
    private Agent matriculeAgent;


}