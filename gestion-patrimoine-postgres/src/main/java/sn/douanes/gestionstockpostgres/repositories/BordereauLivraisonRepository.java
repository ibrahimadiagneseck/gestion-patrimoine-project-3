package sn.douanes.gestionstockpostgres.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.douanes.gestionstockpostgres.entities.BordereauLivraison;
import sn.douanes.gestionstockpostgres.entities.Prestataires;

import java.util.List;


@Repository
public interface BordereauLivraisonRepository extends JpaRepository<BordereauLivraison, String> {
    List<BordereauLivraison> findAllByNinea(Prestataires ninea);
}
