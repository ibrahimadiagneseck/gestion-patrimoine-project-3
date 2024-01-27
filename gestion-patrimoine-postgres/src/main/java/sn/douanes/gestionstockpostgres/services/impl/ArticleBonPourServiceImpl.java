package sn.douanes.gestionstockpostgres.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.douanes.gestionstockpostgres.entities.*;
import sn.douanes.gestionstockpostgres.entities.keys.ArticleBonPourId;
import sn.douanes.gestionstockpostgres.repositories.ArticleBonPourRepository;
import sn.douanes.gestionstockpostgres.services.ArticleBonPourService;

import java.sql.Timestamp;
import java.util.List;


@Service
public class ArticleBonPourServiceImpl implements ArticleBonPourService {

    @Autowired
    ArticleBonPourRepository articleBonPourRepository;

    @Override
    public ArticleBonPour saveArticleBonPour(ArticleBonPour a) {
        return articleBonPourRepository.save(a);
    }

    @Override
    public ArticleBonPour updateArticleBonPour(ArticleBonPour a) {
        return articleBonPourRepository.save(a);
    }

    @Override
    public void deleteArticleBonPour(ArticleBonPour a) {
        articleBonPourRepository.delete(a);
    }

    @Override
    public void deleteArticleBonPourById(String codeArticleBonPour, BonPour identifiantBP) {
        articleBonPourRepository.deleteById(new ArticleBonPourId(codeArticleBonPour, identifiantBP));
    }

    @Override
    public ArticleBonPour getArticleBonPourById(String codeArticleBonPour, BonPour identifiantBP) {
        return articleBonPourRepository.findById(new ArticleBonPourId(codeArticleBonPour, identifiantBP)).isPresent() ? articleBonPourRepository.findById(new ArticleBonPourId(codeArticleBonPour, identifiantBP)).get() : null;
    }



    @Override
    public List<ArticleBonPour> getAllArticleBonPours() {
        return articleBonPourRepository.findAll();
    }


    @Override
    public ArticleBonPour ajouterArticleBonPour(
            BonPour identifiantBP, 
            String codeArticleBonPour, 
            String libelleArticleBonPour, 
            Integer quantiteDemandee, 
            TypeObjet codeTypeObjet, 
            Agent matriculeAgent
    ) {

        ArticleBonPour articleBonPour = new ArticleBonPour();

        articleBonPour.setIdentifiantBP(identifiantBP);
        articleBonPour.setCodeArticleBonPour(codeArticleBonPour);
        articleBonPour.setLibelleArticleBonPour(libelleArticleBonPour);
        articleBonPour.setQuantiteDemandee(quantiteDemandee);
        articleBonPour.setCodeTypeObjet(codeTypeObjet);
        articleBonPour.setMatriculeAgent(matriculeAgent);

        return articleBonPourRepository.save(articleBonPour);
    }




}
