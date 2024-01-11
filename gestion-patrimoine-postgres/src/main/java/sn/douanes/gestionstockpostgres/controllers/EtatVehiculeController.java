package sn.douanes.gestionstockpostgres.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.douanes.gestionstockpostgres.entities.HttpResponse;
import sn.douanes.gestionstockpostgres.entities.EtatVehicule;
import sn.douanes.gestionstockpostgres.services.EtatVehiculeService;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;


@RestController
//@RequestMapping(path = { "/", "/user"})
@RequestMapping( "/")
@CrossOrigin("http://localhost:4200")
public class EtatVehiculeController {

    @Autowired
    EtatVehiculeService etatVehiculeService;

    @GetMapping("/EtatVehicules")
    public ResponseEntity<List<EtatVehicule>> getAllEtatVehicules() {
        List<EtatVehicule> etatVehicule = etatVehiculeService.getAllEtatVehicules();
        return new ResponseEntity<>(etatVehicule, OK);
    }

    @PostMapping("/AjouterEtatVehicule")
    @ResponseBody
    public EtatVehicule AjouterEtatVehicule(@RequestBody EtatVehicule etatVehicule) {
        return etatVehiculeService.saveEtatVehicule(etatVehicule);
    }

    @PostMapping("/AjouterRequestParamEtatVehicule")
    public ResponseEntity<EtatVehicule> ajouterEtatVehicule (
            @RequestParam("codeEtat") String codeEtat,
            @RequestParam("libelleEtat") String libelleEtat
    ) {
        EtatVehicule etatVehicule = etatVehiculeService.ajouterEtatVehicule(codeEtat, libelleEtat);
        return new ResponseEntity<>(etatVehicule, OK);
    }

    @PutMapping("/ModifierEtatVehicule")
    @ResponseBody
    public EtatVehicule ModifierEtatVehicule(@RequestBody EtatVehicule t) {
        return etatVehiculeService.updateEtatVehicule(t);
    }

    @DeleteMapping("SupprimerEtatVehiculeById/{id}")
    public void SupprimerEtatVehiculeById(@PathVariable("id") String codeEtat) {
        etatVehiculeService.deleteEtatVehiculeById(codeEtat);
    }


    private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
        return new ResponseEntity<>(
                new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(), message), httpStatus
        );
    }


}
