package sn.douanes.gestionstockpostgres.services;

import jakarta.persistence.*;
import sn.douanes.gestionstockpostgres.entities.*;
import sn.douanes.gestionstockpostgres.entities.BonSortie;

import java.sql.Date;
import java.util.List;

public interface ArticleBonSortieService {

    ArticleBonSortie saveArticleBonSortie(ArticleBonSortie a);
    ArticleBonSortie updateArticleBonSortie(ArticleBonSortie a);
    void deleteArticleBonSortie(ArticleBonSortie a);
    void deleteArticleBonSortieById(String codeArticleBonSortie, BonDeSortie identifiantBE);
    ArticleBonSortie getArticleBonSortieById(String codeArticleBonSortie, BonDeSortie identifiantBE);
    List<ArticleBonSortie> getAllArticleBonSorties();

    ArticleBonSortie ajouterArticleBonSortie(BonDeSortie identifiantBS, String codeArticleBonSortie, String libelleArticleBonSortie, Integer quantiteAccordee, Date dateArticleBonSortie, ArticleBonEntree identifiantBE, Agent matriculeAgent);

}
