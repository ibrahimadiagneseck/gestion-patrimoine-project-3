package sn.douanes.gestionstockpostgres.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.douanes.gestionstockpostgres.entities.HttpResponse;
import sn.douanes.gestionstockpostgres.entities.Maintenance;
import sn.douanes.gestionstockpostgres.entities.MarqueArme;
import sn.douanes.gestionstockpostgres.services.MarqueArmeService;

import static org.springframework.http.HttpStatus.OK;


@RestController
//@RequestMapping(path = { "/", "/user"})
@RequestMapping( "/")
@CrossOrigin("http://localhost:4200")
public class MarqueArmeController {

    @Autowired
    MarqueArmeService marqueArmeService;


    @GetMapping("/MarqueArmes")
    public ResponseEntity<List<MarqueArme>> getAllMarqueArmes() {
        List<MarqueArme> marqueArme = marqueArmeService.getAllMarqueArmes();
        return new ResponseEntity<>(marqueArme, OK);
    }

    @PostMapping("/AjouterMarqueArme")
    @ResponseBody
    public MarqueArme AjouterMarqueArme(@RequestBody MarqueArme m) {
        return marqueArmeService.saveMarqueArme(m);
    }

    @PutMapping("/ModifierMarqueArme")
    @ResponseBody
    public MarqueArme ModifierMarqueArme(@RequestBody MarqueArme m) {

        return marqueArmeService.updateMarqueArme(m);
    }

    @DeleteMapping("SupprimerMarqueArmeById/{id}")
    public void SupprimerMarqueArmeById(@PathVariable("id") String code_marque_arme) {
        marqueArmeService.deleteMarqueArmeById(code_marque_arme);
    }


    private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
        return new ResponseEntity<>(
                new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(), message), httpStatus
        );
    }


}
