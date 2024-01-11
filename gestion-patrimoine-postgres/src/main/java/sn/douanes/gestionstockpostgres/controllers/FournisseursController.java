package sn.douanes.gestionstockpostgres.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.douanes.gestionstockpostgres.entities.FonctionAgent;
import sn.douanes.gestionstockpostgres.entities.Fournisseurs;
import sn.douanes.gestionstockpostgres.entities.HttpResponse;
import sn.douanes.gestionstockpostgres.services.FournisseursService;

import static org.springframework.http.HttpStatus.OK;


@RestController
//@RequestMapping(path = { "/", "/user"})
@RequestMapping( "/")
@CrossOrigin("http://localhost:4200")
public class FournisseursController {

    @Autowired
    FournisseursService fournisseursService;

    @GetMapping("/Fournisseurs")
    public ResponseEntity<List<Fournisseurs>> getAllFournisseurs() {
        List<Fournisseurs> fournisseurs = fournisseursService.getAllFournisseurs();
        return new ResponseEntity<>(fournisseurs, OK);
    }

    @PostMapping("/AjouterFournisseurs")
    @ResponseBody
    public Fournisseurs AjouterFournisseurs(@RequestBody Fournisseurs f) {
        return fournisseursService.saveFournisseurs(f);
    }

    @PutMapping("/ModifierFournisseurs")
    @ResponseBody
    public Fournisseurs ModifierFournisseurs(@RequestBody Fournisseurs f) {
        return fournisseursService.updateFournisseurs(f);
    }

    @DeleteMapping("SupprimerFournisseursById/{id}")
    public void SupprimerFournisseursById(@PathVariable("id") String codeFournisseur) {
        fournisseursService.deleteFournisseursById(codeFournisseur);
    }


    private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
        return new ResponseEntity<>(
                new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(), message), httpStatus
        );
    }

}
