package sn.douanes.gestionstockpostgres.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.douanes.gestionstockpostgres.entities.Carburant;
import sn.douanes.gestionstockpostgres.entities.ChangementPiece;
import sn.douanes.gestionstockpostgres.entities.HttpResponse;
import sn.douanes.gestionstockpostgres.services.ChangementPieceService;

import static org.springframework.http.HttpStatus.OK;


@RestController
//@RequestMapping(path = { "/", "/user"})
@RequestMapping( "/")
@CrossOrigin("http://localhost:4200")
public class ChangementPieceController {

    @Autowired
    ChangementPieceService changementPieceService;

    @GetMapping("/ChangementPieces")
    public ResponseEntity<List<ChangementPiece>> getAllChangementPieces() {
        List<ChangementPiece> changementPiece = changementPieceService.getAllChangementPieces();
        return new ResponseEntity<>(changementPiece, OK);
    }

    @PostMapping("/AjouterChangementPiece")
    @ResponseBody
    public ChangementPiece AjouterChangementPiece(@RequestBody ChangementPiece c) {
        return changementPieceService.saveChangementPiece(c);
    }

    @PutMapping("/ModifierChangementPiece")
    @ResponseBody
    public ChangementPiece ModifierChangementPiece(@RequestBody ChangementPiece c) {
        return changementPieceService.updateChangementPiece(c);
    }

    @DeleteMapping("SupprimerChangementPieceById/{id}")
    public void SupprimerChangementPieceById(@PathVariable("id") String numeroImmatriculation) {
        changementPieceService.deleteChangementPieceById(numeroImmatriculation );
    }


    private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
        return new ResponseEntity<>(
                new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(), message), httpStatus
        );
    }

}
