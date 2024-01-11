package sn.douanes.gestionstockpostgres.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.douanes.gestionstockpostgres.entities.BordereauLivraison;
import sn.douanes.gestionstockpostgres.entities.Carburant;
import sn.douanes.gestionstockpostgres.entities.HttpResponse;
import sn.douanes.gestionstockpostgres.services.CarburantService;

import static org.springframework.http.HttpStatus.OK;


@RestController
//@RequestMapping(path = { "/", "/user"})
@RequestMapping( "/")
@CrossOrigin("http://localhost:4200")
public class CarburantController {

    @Autowired
    CarburantService carburantService;

    @GetMapping("/Carburants")
    public ResponseEntity<List<Carburant>> getAllCarburants() {
        List<Carburant> carburant = carburantService.getAllCarburants();
        return new ResponseEntity<>(carburant, OK);
    }

    @PostMapping("/AjouterCarburant")
    @ResponseBody
    public Carburant AjouterCarburant(@RequestBody Carburant c) {
        return carburantService.saveCarburant(c);
    }

    @PutMapping("/ModifierCarburant")
    @ResponseBody
    public Carburant ModifierCarburant(@RequestBody Carburant c) {
        return carburantService.updateCarburant(c);
    }

    @DeleteMapping("SupprimerCarburantById/{id}")
    public void SupprimerCarburantById(@PathVariable("id") String numeroCarte) {
        carburantService.deleteCarburantById(numeroCarte);
    }


    private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
        return new ResponseEntity<>(
                new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(), message), httpStatus
        );
    }
}
