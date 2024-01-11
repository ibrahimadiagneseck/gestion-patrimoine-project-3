package sn.douanes.gestionstockpostgres.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.douanes.gestionstockpostgres.entities.Carburant;


@Repository

public interface CarburantRepository extends JpaRepository<Carburant, String> {
}
