package sn.douanes.gestionstockpostgres.services;

import sn.douanes.gestionstockpostgres.entities.Agent;
import sn.douanes.gestionstockpostgres.entities.ArticleBonEntree;
import sn.douanes.gestionstockpostgres.entities.BonEntree;
import sn.douanes.gestionstockpostgres.entities.TypeObjet;

import java.text.SimpleDateFormat;
import java.util.List;

public interface ArticleBonEntreeService {

    ArticleBonEntree saveArticleBonEntree(ArticleBonEntree a);
    ArticleBonEntree updateArticleBonEntree(ArticleBonEntree a);
    void deleteArticleBonEntree(ArticleBonEntree a);
    void deleteArticleBonEntreeById(String codeArticleBonEntree, BonEntree identifiantBE);
    ArticleBonEntree getArticleBonEntreeById(String codeArticleBonEntree, BonEntree identifiantBE);
    List<ArticleBonEntree> getAllArticleBonEntrees();

    ArticleBonEntree ajouterArticleBonEntree(BonEntree identifiantBE, String codeArticleBonEntree, String libelleArticleBonEntree, Integer quantiteEntree, TypeObjet codeTypeObjet, Agent matriculeAgent);
}
