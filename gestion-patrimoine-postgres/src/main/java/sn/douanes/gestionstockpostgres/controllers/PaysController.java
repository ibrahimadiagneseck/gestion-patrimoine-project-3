package sn.douanes.gestionstockpostgres.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.douanes.gestionstockpostgres.entities.HttpResponse;
import sn.douanes.gestionstockpostgres.entities.Materiels;
import sn.douanes.gestionstockpostgres.entities.Pays;
import sn.douanes.gestionstockpostgres.services.PaysService;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;


@RestController
//@RequestMapping(path = { "/", "/user"})
@RequestMapping( "/")
@CrossOrigin("http://localhost:4200")
public class PaysController {

    @Autowired
    PaysService paysService;


    @GetMapping("/Pays")
    public ResponseEntity<List<Pays>> getAllPays() {
        List<Pays> pays = paysService.getAllPays();
        return new ResponseEntity<>(pays, OK);
    }


    @PostMapping("/AjouterPays")
    @ResponseBody
    public Pays AjouterPays(@RequestBody Pays pays) {
        return paysService.savePays(pays);
    }


    @PostMapping("/AjouterRequestParamPays")
    public ResponseEntity<Pays> ajouterPays (
            @RequestParam("codePays") String codePays,
            @RequestParam("libellePays") String libellePays
    ) {
        Pays pays = paysService.ajouterPays(codePays, libellePays);
        return new ResponseEntity<>(pays, OK);
    }


    @PutMapping("/ModifierPays")
    @ResponseBody
    public Pays ModifierPays(@RequestBody Pays p) {
        return paysService.updatePays(p);
    }

    @DeleteMapping("SupprimerPaysById/{id}")
    public void SupprimerPaysById(@PathVariable("id") String codePays) {
        paysService.deletePaysById(codePays);
    }

    private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
        return new ResponseEntity<>(
                new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(), message), httpStatus
        );
    }



}
