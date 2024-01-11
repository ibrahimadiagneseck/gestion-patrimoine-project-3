package sn.douanes.gestionstockpostgres.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.douanes.gestionstockpostgres.entities.HttpResponse;
import sn.douanes.gestionstockpostgres.entities.Vehicule;
import sn.douanes.gestionstockpostgres.entities.Vidange;
import sn.douanes.gestionstockpostgres.services.VidangeService;

import static org.springframework.http.HttpStatus.OK;


@RestController
//@RequestMapping(path = { "/", "/user"})
@RequestMapping( "/")
@CrossOrigin("http://localhost:4200")
public class VidangeController {

    @Autowired
    VidangeService vidangeService;


    @GetMapping("/Vidanges")
    public ResponseEntity<List<Vidange>> getAllVidanges() {
        List<Vidange> vidange = vidangeService.getAllVidanges();
        return new ResponseEntity<>(vidange, OK);
    }

    @PostMapping("/AjouterVidange")
    @ResponseBody
    public Vidange AjouterVidange(@RequestBody Vidange v) {
        return vidangeService.saveVidange(v);
    }

    @PutMapping("/ModifierVidange")
    @ResponseBody
    public Vidange ModifierVidange(@RequestBody Vidange v) {
        return vidangeService.updateVidange(v);
    }

    @DeleteMapping("SupprimerVidangeById/{id}")
    public void SupprimerVidangeById(@PathVariable("id") String numeroImmatriculation) {
        vidangeService.deleteVidangeById(numeroImmatriculation);
    }


    private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
        return new ResponseEntity<>(
                new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(), message), httpStatus
        );
    }


}
