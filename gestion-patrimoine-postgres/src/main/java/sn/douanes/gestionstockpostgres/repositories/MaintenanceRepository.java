package sn.douanes.gestionstockpostgres.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.douanes.gestionstockpostgres.entities.Maintenance;


@Repository
public interface MaintenanceRepository extends JpaRepository<Maintenance, String> {

}
