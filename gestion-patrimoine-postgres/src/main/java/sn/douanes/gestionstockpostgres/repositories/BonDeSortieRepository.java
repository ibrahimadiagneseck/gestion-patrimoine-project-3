package sn.douanes.gestionstockpostgres.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.douanes.gestionstockpostgres.entities.BonDeSortie;


@Repository
public interface BonDeSortieRepository extends JpaRepository<BonDeSortie, String> {

}
