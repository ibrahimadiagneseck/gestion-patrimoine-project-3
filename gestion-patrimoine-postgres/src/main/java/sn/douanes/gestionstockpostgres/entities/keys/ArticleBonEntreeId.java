package sn.douanes.gestionstockpostgres.entities.keys;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import sn.douanes.gestionstockpostgres.entities.BonEntree;

import java.io.Serializable;

public class ArticleBonEntreeId implements Serializable {

    private String codeArticleBonEntree;


    private BonEntree identifiantBE;

    public ArticleBonEntreeId() {
    }

    public ArticleBonEntreeId(String codeArticleBonEntree, BonEntree identifiantBE) {
        this.codeArticleBonEntree = codeArticleBonEntree;
        this.identifiantBE = identifiantBE;
    }
}
