package sn.douanes.gestionstockpostgres.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.douanes.gestionstockpostgres.entities.ArticleBonSortie;
import sn.douanes.gestionstockpostgres.entities.DotationVehicule;
import sn.douanes.gestionstockpostgres.entities.keys.ArticleBonSortieId;
import sn.douanes.gestionstockpostgres.entities.keys.DotationVehiculeId;


@Repository
public interface DotationVehiculeRepository extends JpaRepository<DotationVehicule, String> {

}
