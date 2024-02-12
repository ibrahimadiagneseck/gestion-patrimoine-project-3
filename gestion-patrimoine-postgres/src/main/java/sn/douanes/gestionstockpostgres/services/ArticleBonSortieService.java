package sn.douanes.gestionstockpostgres.services;

import jakarta.persistence.*;
import sn.douanes.gestionstockpostgres.entities.*;

import java.sql.Date;
import java.util.List;

public interface ArticleBonSortieService {

    ArticleBonSortie saveArticleBonSortie(ArticleBonSortie a);
    ArticleBonSortie updateArticleBonSortie(ArticleBonSortie a);
    void deleteArticleBonSortie(ArticleBonSortie a);
    void deleteArticleBonSortieById(String codeArticleBonSortie, BonDeSortie identifiantBS);
    ArticleBonSortie getArticleBonSortieById(String codeArticleBonSortie, BonDeSortie identifiantBS);
    List<ArticleBonSortie> getAllArticleBonSorties();

    ArticleBonSortie ajouterArticleBonSortie(BonDeSortie identifiantBS, String codeArticleBonSortie, String libelleArticleBonSortie, Integer quantiteAccordee, Agent matriculeAgent);

}
