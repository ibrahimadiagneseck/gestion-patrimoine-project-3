package sn.douanes.gestionstockpostgres.services;

import sn.douanes.gestionstockpostgres.entities.ChangementPiece;

import java.util.List;

public interface ChangementPieceService {

    ChangementPiece saveChangementPiece(ChangementPiece c);
    ChangementPiece updateChangementPiece(ChangementPiece c);
    void deleteChangementPiece(ChangementPiece c);
    void deleteChangementPieceById(String id);
    ChangementPiece getChangementPiece(String id);
    List<ChangementPiece> getAllChangementPieces();


}
