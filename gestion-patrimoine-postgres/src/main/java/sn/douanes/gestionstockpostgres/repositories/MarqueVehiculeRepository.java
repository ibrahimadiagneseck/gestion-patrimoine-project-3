package sn.douanes.gestionstockpostgres.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.douanes.gestionstockpostgres.entities.MarqueVehicule;


@Repository
public interface MarqueVehiculeRepository extends JpaRepository<MarqueVehicule, String> {

}
