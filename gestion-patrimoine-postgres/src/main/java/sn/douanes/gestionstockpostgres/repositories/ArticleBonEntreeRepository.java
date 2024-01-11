package sn.douanes.gestionstockpostgres.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.douanes.gestionstockpostgres.entities.ArticleBonEntree;
import sn.douanes.gestionstockpostgres.entities.keys.ArticleBonEntreeId;


@Repository
public interface ArticleBonEntreeRepository extends JpaRepository<ArticleBonEntree, ArticleBonEntreeId> {

}
