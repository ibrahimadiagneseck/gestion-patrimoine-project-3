package sn.douanes.gestionstockpostgres.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.douanes.gestionstockpostgres.entities.TypeArme;


@Repository
public interface TypeArmeRepository extends JpaRepository<TypeArme, String> {
}
