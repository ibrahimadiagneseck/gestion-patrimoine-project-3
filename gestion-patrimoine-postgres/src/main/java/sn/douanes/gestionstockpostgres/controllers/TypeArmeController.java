package sn.douanes.gestionstockpostgres.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.douanes.gestionstockpostgres.entities.HttpResponse;
import sn.douanes.gestionstockpostgres.entities.Tickets;
import sn.douanes.gestionstockpostgres.entities.TypeArme;
import sn.douanes.gestionstockpostgres.services.TypeArmeService;

import static org.springframework.http.HttpStatus.OK;


@RestController
//@RequestMapping(path = { "/", "/user"})
@RequestMapping( "/")
@CrossOrigin("http://localhost:4200")
public class TypeArmeController {

    @Autowired
    TypeArmeService typeArmeService;

    @GetMapping("/TypeArmes")
    public ResponseEntity<List<TypeArme>> getAllTypeArmes() {
        List<TypeArme> typeArme = typeArmeService.getAllTypeArmes();
        return new ResponseEntity<>(typeArme, OK);
    }

    @PostMapping("/AjouterTypeArme")
    @ResponseBody
    public TypeArme AjouterTypeArme(@RequestBody TypeArme t) {
        return typeArmeService.saveTypeArme(t);
    }

    @PutMapping("/ModifierTypeArme")
    @ResponseBody
    public TypeArme ModifierTypeArme(@RequestBody TypeArme t) {

        return typeArmeService.updateTypeArme(t);
    }

    @DeleteMapping("SupprimerTypeArmeById/{id}")
    public void SupprimerTypeArmeById(@PathVariable("id") String code_type_arme) {
        typeArmeService.deleteTypeArmeById(code_type_arme);
    }


    private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
        return new ResponseEntity<>(
                new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(), message), httpStatus
        );
    }


}
