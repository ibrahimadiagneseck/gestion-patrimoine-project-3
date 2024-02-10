package sn.douanes.gestionstockpostgres.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sn.douanes.gestionstockpostgres.entities.keys.AgentId;
import sn.douanes.gestionstockpostgres.entities.keys.ArticleBonEntreeId;

import java.sql.Timestamp;


@Entity
@IdClass(ArticleBonEntreeId.class)
@Table(name = "article_bon_entree")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArticleBonEntree {

    @Id
    @Column(name = "code_article_bon_entree", length = 25)
    private String codeArticleBonEntree;

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "identifiant_b_e")
    private BonEntree identifiantBE;

    @Column(name = "libelle_article_bon_entree")
    private String libelleArticleBonEntree;

    @Column(name = "quantite_entree")
    private Integer quantiteEntree;

    @Column(name = "date_enregistrement")
    private Timestamp dateEnregistrement;

    @ManyToOne
    @JoinColumn(name = "code_type_objet")
    private TypeObjet codeTypeObjet;

    @ManyToOne
    @JoinColumn(name = "code_lieu_vh")
    private LieuStockageVehicule codeLieuVH;


    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "matricule_agent", referencedColumnName = "matricule_agent"),
            @JoinColumn(name = "code_corps_agent", referencedColumnName = "code_corps_agent")
    })
    private Agent matriculeAgent;


}