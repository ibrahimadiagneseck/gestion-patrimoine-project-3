package sn.douanes.gestionstockpostgres.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.douanes.gestionstockpostgres.entities.Agent;
import sn.douanes.gestionstockpostgres.entities.Armes;
import sn.douanes.gestionstockpostgres.entities.HttpResponse;
import sn.douanes.gestionstockpostgres.services.ArmesService;

import static org.springframework.http.HttpStatus.OK;


@RestController
//@RequestMapping(path = { "/", "/user"})
@RequestMapping( "/")
@CrossOrigin("http://localhost:4200")
public class ArmesController {

    @Autowired
    ArmesService armesService;

    @GetMapping("/Armes")
    public ResponseEntity<List<Armes>> getAllArmes() {
        List<Armes> armes = armesService.getAllArmes();
        return new ResponseEntity<>(armes, OK);
    }

    @PostMapping("/AjouterArmes")
    @ResponseBody
    public Armes AjouterArmes(@RequestBody Armes a) {
        return armesService.saveArmes(a);
    }

    @PutMapping("/ModifierArmes")
    @ResponseBody
    public Armes ModifierArmes(@RequestBody Armes a) {
        return armesService.updateArmes(a);
    }

    @DeleteMapping("SupprimerArmesById/{id}")
    public void SupprimerArmesById(@PathVariable("id") String numeroArme ) {
        armesService.deleteArmesById(numeroArme);
    }


    private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
        return new ResponseEntity<>(
                new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(), message), httpStatus
        );
    }


}
