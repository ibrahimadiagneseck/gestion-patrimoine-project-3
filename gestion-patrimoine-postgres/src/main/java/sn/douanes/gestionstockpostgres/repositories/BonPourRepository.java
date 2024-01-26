package sn.douanes.gestionstockpostgres.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.douanes.gestionstockpostgres.entities.BonPour;


@Repository
public interface BonPourRepository extends JpaRepository<BonPour, String> {
}
