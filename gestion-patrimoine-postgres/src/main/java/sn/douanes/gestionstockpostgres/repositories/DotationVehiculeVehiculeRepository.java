package sn.douanes.gestionstockpostgres.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.douanes.gestionstockpostgres.entities.DotationVehiculeVehicule;
import sn.douanes.gestionstockpostgres.entities.Vehicule;
import sn.douanes.gestionstockpostgres.entities.keys.DotationVehiculeVehiculeId;

@Repository
public interface DotationVehiculeVehiculeRepository extends JpaRepository<DotationVehiculeVehicule, DotationVehiculeVehiculeId> {

    DotationVehiculeVehicule findByNumeroSerie(Vehicule numeroSerie);
}
