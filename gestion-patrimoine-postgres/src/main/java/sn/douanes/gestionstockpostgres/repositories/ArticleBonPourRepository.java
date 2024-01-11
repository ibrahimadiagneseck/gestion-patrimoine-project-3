package sn.douanes.gestionstockpostgres.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.douanes.gestionstockpostgres.entities.ArticleBonPour;


@Repository
public interface ArticleBonPourRepository extends JpaRepository<ArticleBonPour, String> {

}
