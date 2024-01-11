package sn.douanes.gestionstockpostgres.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.douanes.gestionstockpostgres.entities.HttpResponse;
import sn.douanes.gestionstockpostgres.entities.TypeUniteDouaniere;
import sn.douanes.gestionstockpostgres.entities.TypeVehicule;
import sn.douanes.gestionstockpostgres.services.TypeVehiculeService;

import static org.springframework.http.HttpStatus.OK;


@RestController
//@RequestMapping(path = { "/", "/user"})
@RequestMapping( "/")
@CrossOrigin("http://localhost:4200")
public class TypeVehiculeController {

    @Autowired
    TypeVehiculeService typeVehiculeService;


    @GetMapping("/TypeVehicules")
    public ResponseEntity<List<TypeVehicule>> getAllTypeVehicules() {
        List<TypeVehicule> typeVehicule = typeVehiculeService.getAllTypeVehicules();
        return new ResponseEntity<>(typeVehicule, OK);
    }

    @PostMapping("/AjouterTypeVehicule")
    @ResponseBody
    public TypeVehicule AjouterTypeVehicule(@RequestBody TypeVehicule typeVehicule) {
        return typeVehiculeService.saveTypeVehicule(typeVehicule);
    }

    @PostMapping("/AjouterRequestParamTypeVehicule")
    public ResponseEntity<TypeVehicule> ajouterTypeVehicule (
            @RequestParam("codeTypeVehicule") String codeTypeVehicule,
            @RequestParam("libelleTypeVehicule") String libelleTypeVehicule
    ) {
        TypeVehicule typeVehicule = typeVehiculeService.ajouterTypeVehicule(codeTypeVehicule, libelleTypeVehicule);
        return new ResponseEntity<>(typeVehicule, OK);
    }

    @PutMapping("/ModifierTypeVehicule")
    @ResponseBody
    public TypeVehicule ModifierTypeVehicule(@RequestBody TypeVehicule t) {
        return typeVehiculeService.updateTypeVehicule(t);
    }

    @DeleteMapping("SupprimerTypeVehiculeById/{id}")
    public void SupprimerTypeVehiculeById(@PathVariable("id") String codeTypeVehicule) {
        typeVehiculeService.deleteTypeVehiculeById(codeTypeVehicule);
    }


    private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
        return new ResponseEntity<>(
                new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(), message), httpStatus
        );
    }


}
