package sn.douanes.gestionstockpostgres.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.douanes.gestionstockpostgres.entities.TypeMateriel;


@Repository
public interface TypeMaterielRepository extends JpaRepository<TypeMateriel, String> {
}
