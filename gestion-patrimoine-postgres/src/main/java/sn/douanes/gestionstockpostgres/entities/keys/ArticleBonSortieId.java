package sn.douanes.gestionstockpostgres.entities.keys;

import sn.douanes.gestionstockpostgres.entities.BonDeSortie;
import sn.douanes.gestionstockpostgres.entities.BonEntree;

import java.io.Serializable;

public class ArticleBonSortieId implements Serializable {

    private String codeArticleBonSortie;


    private BonDeSortie identifiantBS;

    public ArticleBonSortieId() {
    }

    public ArticleBonSortieId(String codeArticleBonSortie, BonDeSortie identifiantBS) {
        this.codeArticleBonSortie = codeArticleBonSortie;
        this.identifiantBS = identifiantBS;
    }
}
