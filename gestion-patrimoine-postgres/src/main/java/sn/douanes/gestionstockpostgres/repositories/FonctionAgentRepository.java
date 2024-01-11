package sn.douanes.gestionstockpostgres.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.douanes.gestionstockpostgres.entities.FonctionAgent;


@Repository
public interface FonctionAgentRepository extends JpaRepository<FonctionAgent, String> {

}
