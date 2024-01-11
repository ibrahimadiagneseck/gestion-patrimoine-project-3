package sn.douanes.gestionstockpostgres.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.douanes.gestionstockpostgres.entities.HttpResponse;
import sn.douanes.gestionstockpostgres.entities.TypeArme;
import sn.douanes.gestionstockpostgres.entities.TypeMateriel;
import sn.douanes.gestionstockpostgres.services.TypeMaterielService;

import static org.springframework.http.HttpStatus.OK;


@RestController
//@RequestMapping(path = { "/", "/user"})
@RequestMapping( "/")
@CrossOrigin("http://localhost:4200")
public class TypeMaterielController {

    @Autowired
    TypeMaterielService typeMaterielService;


    @GetMapping("/TypeMateriels")
    public ResponseEntity<List<TypeMateriel>> getAllTypeMateriels() {
        List<TypeMateriel> typeMateriel = typeMaterielService.getAllTypeMateriels();
        return new ResponseEntity<>(typeMateriel, OK);
    }

    @PostMapping("/AjouterTypeMateriel")
    @ResponseBody
    public TypeMateriel AjouterTypeMateriel(@RequestBody TypeMateriel t) {
        return typeMaterielService.saveTypeMateriel(t);
    }

    @PutMapping("/ModifierTypeMateriel")
    @ResponseBody
    public TypeMateriel ModifierTypeMateriel(@RequestBody TypeMateriel t) {

        return typeMaterielService.updateTypeMateriel(t);
    }

    @DeleteMapping("SupprimerTypeMaterielById/{id}")
    public void SupprimerTypeMaterielById(@PathVariable("id") String code_type_materiel) {
        typeMaterielService.deleteTypeMaterielById( code_type_materiel);
    }


    private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
        return new ResponseEntity<>(
                new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(), message), httpStatus
        );
    }

}
