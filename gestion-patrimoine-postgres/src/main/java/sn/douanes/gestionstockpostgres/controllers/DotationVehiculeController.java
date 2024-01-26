package sn.douanes.gestionstockpostgres.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.douanes.gestionstockpostgres.entities.*;
import sn.douanes.gestionstockpostgres.services.DotationVehiculeService;
import sn.douanes.gestionstockpostgres.services.BordereauLivraisonService;

import java.sql.Date;
import java.util.List;

import static org.springframework.http.HttpStatus.OK;


@RestController
//@RequestMapping(path = { "/", "/user"})
@RequestMapping( "/")
@CrossOrigin("http://localhost:4200")
public class DotationVehiculeController {

    @Autowired
    DotationVehiculeService dotationVehiculeService;


    @GetMapping("/DotationVehicules")
    public ResponseEntity<List<DotationVehicule>> getAllDotationVehicules() {
        List<DotationVehicule> dotationVehicule = dotationVehiculeService.getAllDotationVehicules();
        return new ResponseEntity<>(dotationVehicule, OK);
    }


    @PostMapping("/AjouterDotationVehicule")
    @ResponseBody
    public DotationVehicule AjouterDotationVehicule(@RequestBody DotationVehicule dotationVehicule) {
        // return DotationVehiculeService.saveDotationVehicule(dotationVehicule);
        return dotationVehiculeService.ajouterDotationVehicule(dotationVehicule.getNumeroSerie(), dotationVehicule.getIdentifiantBS(), dotationVehicule.getMatriculeAgent());
    }


//    @PostMapping("/AjouterRequestParamDotationVehicule")
//    public ResponseEntity<DotationVehicule> ajouterDotationVehicule (
//        @RequestParam("numeroBE") String numeroBE,
//        @RequestParam("libelleDotationVehicule") String libelleDotationVehicule,
//        @RequestParam("dateDotationVehicule") String dateDotationVehicule,
//        @RequestParam("observationDotationVehicule") String observationDotationVehicule,
//        @RequestParam("identifiantBL") String identifiantBL
//    ) {
//        BordereauLivraison bordereauLivraison = bordereauLivraisonService.getBordereauLivraisonById(identifiantBL);
//
//        DotationVehicule DotationVehicule = DotationVehiculeService.ajouterDotationVehicule(numeroBE,  libelleDotationVehicule,  Date.valueOf(dateDotationVehicule), observationDotationVehicule, bordereauLivraison);
//        return new ResponseEntity<>(DotationVehicule, OK);
//    }


    @PutMapping("/ModifierDotationVehicule")
    @ResponseBody
    public DotationVehicule ModifierDotationVehicule(@RequestBody DotationVehicule b) {
        return dotationVehiculeService.updateDotationVehicule(b);
    }

    @DeleteMapping("SupprimerDotationVehiculeById/{dateDotation}/{numeroSerie}")
    public void SupprimerArticleBonEntree(
            @PathVariable("codeArticleBonEntree") Date dateDotation,
            @PathVariable("identifiantBE") Vehicule numeroSerie
    ) {
        dotationVehiculeService.deleteDotationVehiculeById(dateDotation, numeroSerie);
    }

    @GetMapping("RecupererDotationVehiculeById/{dateDotation}/{numeroSerie}")
    public DotationVehicule RecupererDotationVehiculeById(
            @PathVariable("codeArticleBonEntree") Date dateDotation,
            @PathVariable("identifiantBE") Vehicule numeroSerie
    ) {
        return dotationVehiculeService.getDotationVehiculeById(dateDotation, numeroSerie);
    }

    private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
        return new ResponseEntity<>(
                new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(), message), httpStatus
        );
    }
}
