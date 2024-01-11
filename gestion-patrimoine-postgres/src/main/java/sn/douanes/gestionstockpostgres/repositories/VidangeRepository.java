package sn.douanes.gestionstockpostgres.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.douanes.gestionstockpostgres.entities.Vidange;


@Repository
public interface VidangeRepository extends JpaRepository<Vidange, String> {
}
