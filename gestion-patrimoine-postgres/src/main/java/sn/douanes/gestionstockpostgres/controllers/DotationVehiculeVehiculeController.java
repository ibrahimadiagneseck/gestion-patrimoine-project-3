package sn.douanes.gestionstockpostgres.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.douanes.gestionstockpostgres.entities.DotationVehicule;
import sn.douanes.gestionstockpostgres.entities.DotationVehiculeVehicule;
import sn.douanes.gestionstockpostgres.entities.HttpResponse;
import sn.douanes.gestionstockpostgres.entities.Vehicule;
import sn.douanes.gestionstockpostgres.services.DotationVehiculeVehiculeService;
import sn.douanes.gestionstockpostgres.services.VehiculeService;


import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
//@RequestMapping(path = { "/", "/user"})
@RequestMapping( "/")
@CrossOrigin("http://localhost:4200")

public class DotationVehiculeVehiculeController {

    @Autowired
    DotationVehiculeVehiculeService dotationVehiculeVehiculeService;

    @Autowired
    VehiculeService vehiculeService;


    @GetMapping("/DotationVehiculeVehicules")
    public ResponseEntity<List<DotationVehiculeVehicule>> getAllDotationVehiculeVehiscules() {
        List<DotationVehiculeVehicule> dotationVehiculeVehicule = dotationVehiculeVehiculeService.getAllDotationVehiculeVehicule();
        return new ResponseEntity<>(dotationVehiculeVehicule, OK);
    }


    @GetMapping("RecupererDotationByVehiculeId/{numeroSerie}")
    public ResponseEntity<DotationVehiculeVehicule> RecupererDotationByVehiculeId(@PathVariable("numeroSerie") String numeroSerie) {

        Vehicule vehicule =  vehiculeService.getVehiculeById(numeroSerie);
        DotationVehiculeVehicule  dotationVehiculeVehicule =  dotationVehiculeVehiculeService.getDotationVehiculeVehiculeById(vehicule);
        return new ResponseEntity<>(dotationVehiculeVehicule, OK);
    }

    @PostMapping("/AjouterDotationVehiculeVehicule")
    @ResponseBody
    public DotationVehiculeVehicule AjouterDotationVehiculeVehicule(@RequestBody DotationVehiculeVehicule dotationVehiculeVehicule) {
        return dotationVehiculeVehiculeService.saveDotationVehiculeVehicule(dotationVehiculeVehicule);
    }

//    @PostMapping("/AjouterRequestParamPrestatairesSecteur")
//    public ResponseEntity<PrestatairesSecteur> ajouterPrestatairesSecteur (
//            @RequestParam("ninea") Prestataires ninea,
//            @RequestParam("codeSecteurActivite") SecteurActivite codeSecteurActivite
//    ) {
//        PrestatairesSecteur prestatairesSecteur = prestatairesSecteurService.ajouterPrestatairesSecteur(ninea, codeSecteurActivite);
//        return new ResponseEntity<>(prestatairesSecteur, OK);
//    }


    @PutMapping("/ModifierDotationVehiculeVehicule")
    @ResponseBody
    public DotationVehiculeVehicule ModifierDotationVehiculeVehicule(@RequestBody DotationVehiculeVehicule d) {

        return dotationVehiculeVehiculeService.updateDotationVehiculeVehicule(d);
    }

    @DeleteMapping("SupprimerDotationVehiculeVehiculeById/{id}")
    public void SupprimerDotationVehiculeVehiculeById(
            @PathVariable("numeroSerie") Vehicule numeroSerie,
            @PathVariable("identifiantDV") DotationVehicule identifiantDV
    ) {
        dotationVehiculeVehiculeService.deleteDotationVehiculeVehiculeById(numeroSerie, identifiantDV);
    }


    private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
        return new ResponseEntity<>(
                new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(), message), httpStatus
        );
    }

}
