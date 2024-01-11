package sn.douanes.gestionstockpostgres.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.douanes.gestionstockpostgres.entities.TypeObjet;
import sn.douanes.gestionstockpostgres.entities.TypeVehicule;


@Repository
public interface TypeObjetRepository extends JpaRepository<TypeObjet, String> {

}
