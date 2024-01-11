package sn.douanes.gestionstockpostgres.services;

import sn.douanes.gestionstockpostgres.entities.ArticleBonSortie;

import java.util.List;

public interface ArticleBonSortieService {

    ArticleBonSortie saveArticleBonSortie(ArticleBonSortie a);
    ArticleBonSortie updateArticleBonSortie(ArticleBonSortie a);
    void deleteArticleBonSortie(ArticleBonSortie a);
    void deleteArticleBonSortieById(String id);
    ArticleBonSortie getArticleBonSortie(String id);
    List<ArticleBonSortie> getAllArticleBonSorties();


}
