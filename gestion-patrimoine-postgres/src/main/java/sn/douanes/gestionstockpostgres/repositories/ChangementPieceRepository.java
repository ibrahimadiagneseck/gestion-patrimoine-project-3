package sn.douanes.gestionstockpostgres.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.douanes.gestionstockpostgres.entities.ChangementPiece;


@Repository
public interface ChangementPieceRepository extends JpaRepository<ChangementPiece, String> {
}
