package sn.douanes.gestionstockpostgres.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.douanes.gestionstockpostgres.entities.HttpResponse;
import sn.douanes.gestionstockpostgres.entities.TypeObjet;
import sn.douanes.gestionstockpostgres.entities.TypeUniteDouaniere;
import sn.douanes.gestionstockpostgres.services.TypeUniteDouaniereService;

import static org.springframework.http.HttpStatus.OK;


@RestController
//@RequestMapping(path = { "/", "/user"})
@RequestMapping( "/")
@CrossOrigin("http://localhost:4200")
public class TypeUniteDouaniereController {

    @Autowired
    TypeUniteDouaniereService typeUniteDouaniereService;


    @GetMapping("/TypeUniteDouanieres")
    public ResponseEntity<List<TypeUniteDouaniere>> getAllTypeUniteDouanieres() {
        List<TypeUniteDouaniere> typeUniteDouaniere = typeUniteDouaniereService.getAllTypeUniteDouanieres();
        return new ResponseEntity<>(typeUniteDouaniere, OK);
    }

    @PostMapping("/AjouterTypeUniteDouaniere")
    @ResponseBody
    public TypeUniteDouaniere AjouterTypeUniteDouaniere(@RequestBody TypeUniteDouaniere typeUniteDouaniere) {
        return typeUniteDouaniereService.saveTypeUniteDouaniere(typeUniteDouaniere);
    }

    @PostMapping("/AjouterRequestParamTypeUniteDouaniere")
    public ResponseEntity<TypeUniteDouaniere> ajouterTypeUniteDouaniere (
            @RequestParam("codeTypeUniteDouaniere") String codeTypeUniteDouaniere,
            @RequestParam("libelleTypeUniteDouaniere") String libelleTypeUniteDouaniere
    ) {
        TypeUniteDouaniere typeUniteDouaniere = typeUniteDouaniereService.ajouterTypeUniteDouaniere(codeTypeUniteDouaniere, libelleTypeUniteDouaniere);
        return new ResponseEntity<>(typeUniteDouaniere, OK);
    }

    @PutMapping("/ModifierTypeUniteDouaniere")
    @ResponseBody
    public TypeUniteDouaniere ModifierTypeUniteDouaniere(@RequestBody TypeUniteDouaniere t) {

        return typeUniteDouaniereService.updateTypeUniteDouaniere(t);
    }

    @DeleteMapping("SupprimerTypeUniteDouaniereById/{id}")
    public void SupprimerTypeUniteDouaniereById(@PathVariable("id") String codeTypeUniteDouaniere) {
        typeUniteDouaniereService.deleteTypeUniteDouaniereById(codeTypeUniteDouaniere);
    }


    private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
        return new ResponseEntity<>(
                new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(), message), httpStatus
        );
    }


}
