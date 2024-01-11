package sn.douanes.gestionstockpostgres.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.douanes.gestionstockpostgres.entities.TypeEnergie;


@Repository
public interface TypeEnergieRepository extends JpaRepository<TypeEnergie, String> {

}
