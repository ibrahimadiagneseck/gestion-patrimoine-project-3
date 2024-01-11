package sn.douanes.gestionstockpostgres.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.douanes.gestionstockpostgres.entities.Armes;


@Repository
public interface ArmesRepository extends JpaRepository<Armes, String> {

}
