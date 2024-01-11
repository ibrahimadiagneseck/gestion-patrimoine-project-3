package sn.douanes.gestionstockpostgres.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.douanes.gestionstockpostgres.entities.CorpsAgent;


@Repository
public interface CorpsAgentRepository extends JpaRepository<CorpsAgent, String> {

}