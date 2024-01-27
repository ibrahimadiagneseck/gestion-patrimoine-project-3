package sn.douanes.gestionstockpostgres.services;

import jakarta.persistence.*;
import sn.douanes.gestionstockpostgres.entities.Agent;
import sn.douanes.gestionstockpostgres.entities.ArticleBonPour;
import sn.douanes.gestionstockpostgres.entities.BonPour;
import sn.douanes.gestionstockpostgres.entities.TypeObjet;

import java.util.List;

public interface ArticleBonPourService {

    ArticleBonPour saveArticleBonPour(ArticleBonPour a);
    ArticleBonPour updateArticleBonPour(ArticleBonPour a);
    void deleteArticleBonPour(ArticleBonPour a);
    void deleteArticleBonPourById(String codeArticleBonPour, BonPour identifiantBP);
    ArticleBonPour getArticleBonPourById(String codeArticleBonPour, BonPour identifiantBP);
    List<ArticleBonPour> getAllArticleBonPours();

    ArticleBonPour ajouterArticleBonPour(BonPour identifiantBP, String codeArticleBonPour, String libelleArticleBonPour, Integer quantiteDemandee, TypeObjet codeTypeObjet, Agent matriculeAgent);

}
