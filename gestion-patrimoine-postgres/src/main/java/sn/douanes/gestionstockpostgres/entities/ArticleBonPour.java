package sn.douanes.gestionstockpostgres.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;


@Entity
@Table(name = "article_bon_pour")
public class ArticleBonPour {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "numero_bon_pour", nullable = false, updatable = false)
    private String numeroBonPour;

    @Column(name = "code_article_bon_pour")
    private String codeArticleBonPour;

    @Column(name = "libelle_article_bon_pour")
    private String libelleArticleBonPour;

    @Column(name = "quantite_demandee")
    private Integer quantiteDemandee;

    @Column(name = "categorie_bon_pour")
    private String categorieBonPour;

}

