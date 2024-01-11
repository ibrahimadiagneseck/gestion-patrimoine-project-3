package sn.douanes.gestionstockpostgres.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.douanes.gestionstockpostgres.entities.UniteDouaniere;


@Repository
public interface UniteDouaniereRepository extends JpaRepository<UniteDouaniere, String> {

}
