package sn.douanes.gestionstockpostgres.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.douanes.gestionstockpostgres.entities.HttpResponse;
import sn.douanes.gestionstockpostgres.entities.Sections;
import sn.douanes.gestionstockpostgres.entities.TypeMateriel;
import sn.douanes.gestionstockpostgres.entities.TypeObjet;
import sn.douanes.gestionstockpostgres.services.TypeObjetService;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;


@RestController
//@RequestMapping(path = { "/", "/user"})
@RequestMapping( "/")
@CrossOrigin("http://localhost:4200")
public class TypeObjetController {

    @Autowired
    TypeObjetService typeObjetService;


    @GetMapping("/TypeObjets")
    public ResponseEntity<List<TypeObjet>> getAllTypeObjets() {
        List<TypeObjet> typeObjet = typeObjetService.getAllTypeObjets();
        return new ResponseEntity<>(typeObjet, OK);
    }

    @PostMapping("/AjouterTypeObjet")
    @ResponseBody
    public TypeObjet AjouterTypeObjet(@RequestBody TypeObjet typeObjet) {
        return typeObjetService.saveTypeObjet(typeObjet);
    }

    @PostMapping("/AjouterRequestParamTypeObjet")
    public ResponseEntity<TypeObjet> ajouterTypeObjet (
            @RequestParam("codeTypeObjet") String codeTypeObjet,
            @RequestParam("libelleTypeObjet") String libelleTypeObjet,
            @RequestParam("codeSection") Sections codeSection
    ) {
        TypeObjet typeObjet = typeObjetService.ajouterTypeObjet(codeTypeObjet, libelleTypeObjet, codeSection);
        return new ResponseEntity<>(typeObjet, OK);
    }

    @PutMapping("/ModifierTypeObjet")
    @ResponseBody
    public TypeObjet ModifierTypeObjet(@RequestBody TypeObjet t) {

        return typeObjetService.updateTypeObjet(t);
    }

    @DeleteMapping("SupprimerTypeObjetById/{id}")
    public void SupprimerTypeObjetById(@PathVariable("id") String codeTypeObjet) {
        typeObjetService.deleteTypeObjetById(codeTypeObjet);
    }


    private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
        return new ResponseEntity<>(
                new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(), message), httpStatus
        );
    }


}
