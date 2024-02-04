package sn.douanes.gestionstockpostgres.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.douanes.gestionstockpostgres.entities.*;
import sn.douanes.gestionstockpostgres.services.BonDeSortieService;
import sn.douanes.gestionstockpostgres.services.BordereauLivraisonService;

import java.sql.Date;
import java.util.List;

import static org.springframework.http.HttpStatus.OK;


@RestController
//@RequestMapping(path = { "/", "/user"})
@RequestMapping( "/")
@CrossOrigin("http://localhost:4200")
public class BonDeSortieController {

    @Autowired
    BonDeSortieService bonDeSortieService;

    @GetMapping("/BonDeSorties")
    public ResponseEntity<List<BonDeSortie>> getAllBonDeSorties() {
        List<BonDeSortie> BonDeSortie = bonDeSortieService.getAllBonDeSorties();
        return new ResponseEntity<>(BonDeSortie, OK);
    }



    @PostMapping("/AjouterBonDeSortie")
    @ResponseBody
    public BonDeSortie AjouterBonDeSortie(@RequestBody BonDeSortie bonDeSortie) {
        // return BonDeSortieService.saveBonDeSortie(BonDeSortie);
        return bonDeSortieService.ajouterBonDeSortie(bonDeSortie.getNumeroBS(), bonDeSortie.getDescriptionBS(), bonDeSortie.getDateBS(), bonDeSortie.getObservationBS(), bonDeSortie.getCodeUniteDouaniere(), bonDeSortie.getCodeSection(), bonDeSortie.getIdentifiantBP(), bonDeSortie.getMatriculeAgent());
    }


    @PutMapping("/ModifierBonDeSortie")
    @ResponseBody
    public BonDeSortie ModifierBonDeSortie(@RequestBody BonDeSortie b) {
        return bonDeSortieService.updateBonDeSortie(b);
    }

    @DeleteMapping("SupprimerBonDeSortieById/{id}")
    public void SupprimerBonDeSortieById(@PathVariable("id") String identifiantBS) {
        bonDeSortieService.deleteBonDeSortieById(identifiantBS);
    }

    @GetMapping("RecupererBonDeSortieById/{id}")
    public BonDeSortie RecupererBonDeSortieById(@PathVariable("id") String identifiantBS) {
        return bonDeSortieService.getBonDeSortieById(identifiantBS);
    }

    private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
        return new ResponseEntity<>(
                new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(), message), httpStatus
        );
    }
}
