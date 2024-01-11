package sn.douanes.gestionstockpostgres.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.douanes.gestionstockpostgres.entities.ArticleBonPour;
import sn.douanes.gestionstockpostgres.repositories.ArticleBonPourRepository;
import sn.douanes.gestionstockpostgres.services.ArticleBonPourService;


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
    public void deleteArticleBonPourById(String id) {
        articleBonPourRepository.deleteById(id);
    }

    @Override
    public ArticleBonPour getArticleBonPour(String id) {
        return articleBonPourRepository.findById(id).get();
    }

    @Override
    public List<ArticleBonPour> getAllArticleBonPours() {
        return articleBonPourRepository.findAll();
    }



}
