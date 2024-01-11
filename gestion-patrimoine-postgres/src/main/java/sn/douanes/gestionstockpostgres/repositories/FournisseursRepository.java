package sn.douanes.gestionstockpostgres.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.douanes.gestionstockpostgres.entities.Fournisseurs;


@Repository
public interface FournisseursRepository extends JpaRepository<Fournisseurs, String> {

}
