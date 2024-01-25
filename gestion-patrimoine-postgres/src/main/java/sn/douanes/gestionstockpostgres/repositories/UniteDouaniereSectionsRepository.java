package sn.douanes.gestionstockpostgres.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.douanes.gestionstockpostgres.entities.UniteDouaniereSections;
import sn.douanes.gestionstockpostgres.entities.keys.UniteDouaniereSectionsId;


@Repository
public interface UniteDouaniereSectionsRepository extends JpaRepository<UniteDouaniereSections, UniteDouaniereSectionsId> {

}
