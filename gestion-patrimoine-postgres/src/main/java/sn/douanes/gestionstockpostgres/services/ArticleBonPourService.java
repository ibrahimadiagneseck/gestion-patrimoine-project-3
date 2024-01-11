package sn.douanes.gestionstockpostgres.services;

import sn.douanes.gestionstockpostgres.entities.ArticleBonPour;

import java.util.List;

public interface ArticleBonPourService {

    ArticleBonPour saveArticleBonPour(ArticleBonPour a);
    ArticleBonPour updateArticleBonPour(ArticleBonPour a);
    void deleteArticleBonPour(ArticleBonPour a);
    void deleteArticleBonPourById(String id);
    ArticleBonPour getArticleBonPour(String id);
    List<ArticleBonPour> getAllArticleBonPours();


}
