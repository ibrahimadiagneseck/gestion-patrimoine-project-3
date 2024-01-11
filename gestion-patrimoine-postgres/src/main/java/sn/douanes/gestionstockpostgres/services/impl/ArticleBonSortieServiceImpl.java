package sn.douanes.gestionstockpostgres.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.douanes.gestionstockpostgres.entities.ArticleBonSortie;
import sn.douanes.gestionstockpostgres.repositories.ArticleBonSortieRepository;
import sn.douanes.gestionstockpostgres.services.ArticleBonSortieService;


@Service
public class ArticleBonSortieServiceImpl implements ArticleBonSortieService {

    @Autowired
    ArticleBonSortieRepository articleBonSortieRepository;

    @Override
    public ArticleBonSortie saveArticleBonSortie(ArticleBonSortie a) {
        return articleBonSortieRepository.save(a);
    }

    @Override
    public ArticleBonSortie updateArticleBonSortie(ArticleBonSortie a) {
        return articleBonSortieRepository.save(a);
    }

    @Override
    public void deleteArticleBonSortie(ArticleBonSortie a) {
        articleBonSortieRepository.delete(a);
    }

    @Override
    public void deleteArticleBonSortieById(String id) {
        articleBonSortieRepository.deleteById(id);
    }

    @Override
    public ArticleBonSortie getArticleBonSortie(String id) {
        return articleBonSortieRepository.findById(id).get();
    }

    @Override
    public List<ArticleBonSortie> getAllArticleBonSorties() {
        return articleBonSortieRepository.findAll();
    }



}
