package sn.douanes.gestionstockpostgres.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.douanes.gestionstockpostgres.entities.HttpResponse;
import sn.douanes.gestionstockpostgres.entities.TypeEnergie;
import sn.douanes.gestionstockpostgres.services.TypeEnergieService;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;


@RestController
//@RequestMapping(path = { "/", "/user"})
@RequestMapping( "/")
@CrossOrigin("http://localhost:4200")
public class TypeEnergieController {

    @Autowired
    TypeEnergieService typeEnergieService;

    @GetMapping("/TypeEnergies")
    public ResponseEntity<List<TypeEnergie>> getAllTypeEnergies() {
        List<TypeEnergie> typeEnergie = typeEnergieService.getAllTypeEnergies();
        return new ResponseEntity<>(typeEnergie, OK);
    }

    @PostMapping("/AjouterTypeEnergie")
    @ResponseBody
    public TypeEnergie AjouterTypeEnergie(@RequestBody TypeEnergie typeEnergie) {
        return typeEnergieService.saveTypeEnergie(typeEnergie);
    }

    @PostMapping("/AjouterRequestParamTypeEnergie")
    public ResponseEntity<TypeEnergie> ajouterTypeEnergie (
            @RequestParam("codeTypeEnergie") String codeTypeEnergie,
            @RequestParam("libelleTypeEnergie") String libelleTypeEnergie
    ) {
        TypeEnergie typeEnergie = typeEnergieService.ajouterTypeEnergie(codeTypeEnergie, libelleTypeEnergie);
        return new ResponseEntity<>(typeEnergie, OK);
    }

    @PutMapping("/ModifierTypeEnergie")
    @ResponseBody
    public TypeEnergie ModifierTypeEnergie(@RequestBody TypeEnergie t) {
        return typeEnergieService.updateTypeEnergie(t);
    }

    @DeleteMapping("SupprimerTypeEnergieById/{id}")
    public void SupprimerTypeEnergieById(@PathVariable("id") String codeTypeEnergie) {
        typeEnergieService.deleteTypeEnergieById(codeTypeEnergie);
    }


    private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
        return new ResponseEntity<>(
                new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(), message), httpStatus
        );
    }


}
