package sn.douanes.gestionstockpostgres.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.douanes.gestionstockpostgres.entities.ArticleBonSortie;
import sn.douanes.gestionstockpostgres.entities.keys.ArticleBonSortieId;


@Repository
public interface ArticleBonSortieRepository extends JpaRepository<ArticleBonSortie, ArticleBonSortieId> {

}
