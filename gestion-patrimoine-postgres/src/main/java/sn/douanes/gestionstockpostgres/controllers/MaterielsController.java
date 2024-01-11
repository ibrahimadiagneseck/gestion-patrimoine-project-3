package sn.douanes.gestionstockpostgres.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.douanes.gestionstockpostgres.entities.HttpResponse;
import sn.douanes.gestionstockpostgres.entities.MarqueVehicule;
import sn.douanes.gestionstockpostgres.entities.Materiels;
import sn.douanes.gestionstockpostgres.services.MaterielsService;

import static org.springframework.http.HttpStatus.OK;


@RestController
//@RequestMapping(path = { "/", "/user"})
@RequestMapping( "/")
@CrossOrigin("http://localhost:4200")
public class MaterielsController {

    @Autowired
    MaterielsService materielsService;


    @GetMapping("/Materiels")
    public ResponseEntity<List<Materiels>> getAllMateriels() {
        List<Materiels> materiels = materielsService.getAllMateriels();
        return new ResponseEntity<>(materiels, OK);
    }

    @PostMapping("/AjouterMateriels")
    @ResponseBody
    public Materiels AjouterMateriels(@RequestBody Materiels m) {
        return materielsService.saveMateriels(m);
    }

    @PutMapping("/ModifierMateriels")
    @ResponseBody
    public Materiels ModifierMateriels(@RequestBody Materiels m) {

        return materielsService.updateMateriels(m);
    }

    @DeleteMapping("SupprimerMaterielsById/{id}")
    public void SupprimerMaterielsById(@PathVariable("id") String code_materiel) {
        materielsService.deleteMaterielsById( code_materiel );
    }


    private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
        return new ResponseEntity<>(
                new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(), message), httpStatus
        );
    }


}
