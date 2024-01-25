package sn.douanes.gestionstockpostgres.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.douanes.gestionstockpostgres.entities.ArticleBonPour;
import sn.douanes.gestionstockpostgres.entities.keys.ArticleBonPourId;


@Repository
public interface ArticleBonPourRepository extends JpaRepository<ArticleBonPour, ArticleBonPourId> {

}
