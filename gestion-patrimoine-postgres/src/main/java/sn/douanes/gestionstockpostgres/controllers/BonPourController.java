package sn.douanes.gestionstockpostgres.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.douanes.gestionstockpostgres.entities.*;
import sn.douanes.gestionstockpostgres.services.BonPourService;
import sn.douanes.gestionstockpostgres.services.BordereauLivraisonService;

import java.sql.Date;
import java.util.List;

import static org.springframework.http.HttpStatus.OK;


@RestController
//@RequestMapping(path = { "/", "/user"})
@RequestMapping( "/")
@CrossOrigin("http://localhost:4200")
public class BonPourController {

    @Autowired
    BonPourService bonPourService;


    @GetMapping("/BonPours")
    public ResponseEntity<List<BonPour>> getAllBonPours() {
        List<BonPour> bonPour = bonPourService.getAllBonPours();
        return new ResponseEntity<>(bonPour, OK);
    }


    @PostMapping("/AjouterBonPour")
    @ResponseBody
    public BonPour AjouterBonPour(@RequestBody BonPour bonPour) {
        // return BonPourService.saveBonPour(BonPour);
        return bonPourService.ajouterBonPour(bonPour.getDescriptionBP(), bonPour.getNumeroCourrielOrigine(), bonPour.getDateCourrielOrigine(), bonPour.getEtatBP(), bonPour.getObjectCourrielOrigine(), bonPour.getNumeroArriveDLF(), bonPour.getDateArriveDLF(), bonPour.getObservationDLF(), bonPour.getNumeroArriveBLM(), bonPour.getDateArriveBLM(),bonPour.getObservationBLM() , bonPour.getNumeroArriveSection(), bonPour.getDateArriveSection(), bonPour.getObservationSection(), bonPour.getCodeUniteDouaniere(), bonPour.getCodeSection(), bonPour.getMatriculeAgent());
    }


    @PutMapping("/ModifierBonPour")
    @ResponseBody
    public BonPour ModifierBonPour(@RequestBody BonPour b) {
        return bonPourService.updateBonPour(b);
    }

    @DeleteMapping("SupprimerBonPourById/{id}")
    public void SupprimerBonPourById(@PathVariable("id") String identifiantBP) {
        bonPourService.deleteBonPourById(identifiantBP);
    }

    @GetMapping("RecupererBonPourById/{id}")
    public BonPour RecupererBonPourById(@PathVariable("id") String identifiantBP) {
        return bonPourService.getBonPourById(identifiantBP);
    }

    private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
        return new ResponseEntity<>(
                new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(), message), httpStatus
        );
    }
}
