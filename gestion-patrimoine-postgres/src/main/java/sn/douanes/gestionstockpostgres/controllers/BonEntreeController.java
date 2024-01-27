package sn.douanes.gestionstockpostgres.controllers;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.douanes.gestionstockpostgres.entities.*;
import sn.douanes.gestionstockpostgres.services.BonEntreeService;
import sn.douanes.gestionstockpostgres.services.BordereauLivraisonService;

import static org.springframework.http.HttpStatus.OK;


@RestController
//@RequestMapping(path = { "/", "/user"})
@RequestMapping( "/")
@CrossOrigin("http://localhost:4200")
public class BonEntreeController {

    @Autowired
    BonEntreeService bonEntreeService;
    @Autowired
    BordereauLivraisonService bordereauLivraisonService;


    @GetMapping("/BonEntrees")
    public ResponseEntity<List<BonEntree>> getAllBonEntrees() {
        List<BonEntree> bonEntree = bonEntreeService.getAllBonEntrees();
        return new ResponseEntity<>(bonEntree, OK);
    }


    @PostMapping("/AjouterBonEntree")
    @ResponseBody
    public BonEntree AjouterBonEntree(@RequestBody BonEntree bonEntree) {
        // return bonEntreeService.saveBonEntree(bonEntree);
        return bonEntreeService.ajouterBonEntree(bonEntree.getNumeroBE(), bonEntree.getLibelleBonEntree(), bonEntree.getDateBonEntree(), bonEntree.getObservationBonEntree(), bonEntree.getIdentifiantBL());
    }


//    @PostMapping("/AjouterRequestParamBonEntree")
//    public ResponseEntity<BonEntree> ajouterBonEntree (
//        @RequestParam("numeroBE") String numeroBE,
//        @RequestParam("libelleBonEntree") String libelleBonEntree,
//        @RequestParam("dateBonEntree") String dateBonEntree,
//        @RequestParam("observationBonEntree") String observationBonEntree,
//        @RequestParam("identifiantBL") String identifiantBL
//    ) {
//        BordereauLivraison bordereauLivraison = bordereauLivraisonService.getBordereauLivraisonById(identifiantBL);
//
//        BonEntree bonEntree = bonEntreeService.ajouterBonEntree(numeroBE,  libelleBonEntree,  Date.valueOf(dateBonEntree), observationBonEntree, bordereauLivraison);
//        return new ResponseEntity<>(bonEntree, OK);
//    }


    @PutMapping("/ModifierBonEntree")
    @ResponseBody
    public BonEntree ModifierBonEntree(@RequestBody BonEntree b) {
        return bonEntreeService.updateBonEntree(b);
    }

    @DeleteMapping("SupprimerBonEntreeById/{id}")
    public void SupprimerBonEntreeById(@PathVariable("id") String identifiantBE) {
        bonEntreeService.deleteBonEntreeById(identifiantBE);
    }

    @GetMapping("RecupererBonEntreeById/{id}")
    public BonEntree RecupererBonEntreeById(@PathVariable("id") String identifiantBE) {
        return bonEntreeService.getBonEntreeById(identifiantBE);
    }

    private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
        return new ResponseEntity<>(
                new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(), message), httpStatus
        );
    }
}
