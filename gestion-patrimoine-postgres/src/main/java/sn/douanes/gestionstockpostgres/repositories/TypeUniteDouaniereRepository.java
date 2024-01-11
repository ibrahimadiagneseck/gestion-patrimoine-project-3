package sn.douanes.gestionstockpostgres.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.douanes.gestionstockpostgres.entities.TypeUniteDouaniere;


@Repository
public interface TypeUniteDouaniereRepository extends JpaRepository<TypeUniteDouaniere, String> {

}
