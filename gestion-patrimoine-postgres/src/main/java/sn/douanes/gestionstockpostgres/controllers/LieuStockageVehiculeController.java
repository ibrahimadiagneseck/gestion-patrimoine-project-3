package sn.douanes.gestionstockpostgres.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.douanes.gestionstockpostgres.entities.HttpResponse;
import sn.douanes.gestionstockpostgres.entities.LieuStockageVehicule;
import sn.douanes.gestionstockpostgres.services.LieuStockageVehiculeService;


import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
//@RequestMapping(path = { "/", "/user"})
@RequestMapping( "/")
@CrossOrigin("http://localhost:4200")
public class LieuStockageVehiculeController {

    @Autowired
    LieuStockageVehiculeService lieuStockageVehiculeService;

    @GetMapping("/LieuStockageVehicules")
    public ResponseEntity<List<LieuStockageVehicule>> getAllTypeEnergies() {
        List<LieuStockageVehicule> lieuStockageVehicule = lieuStockageVehiculeService.getAllLieuStockageVehicules();
        return new ResponseEntity<>(lieuStockageVehicule, OK);
    }

    @PostMapping("/AjouterLieuStockageVehicule")
    @ResponseBody
    public LieuStockageVehicule AjouterLieuStockageVehicule(@RequestBody LieuStockageVehicule lieuStockageVehicule) {
        return lieuStockageVehiculeService.saveLieuStockageVehicule(lieuStockageVehicule);
    }

    //@PostMapping("/AjouterRequestParamTypeEnergie")
    //public ResponseEntity<TypeEnergie> ajouterTypeEnergie (
            //@RequestParam("codeTypeEnergie") String codeTypeEnergie,
            //@RequestParam("libelleTypeEnergie") String libelleTypeEnergie
    //) {
        //TypeEnergie typeEnergie = typeEnergieService.ajouterTypeEnergie(codeTypeEnergie, libelleTypeEnergie);
        //return new ResponseEntity<>(typeEnergie, OK);
    //}

    @PutMapping("/ModifierLieuStockageVehicule")
    @ResponseBody
    public LieuStockageVehicule ModifierLieuStockageVehicule(@RequestBody LieuStockageVehicule l) {
        return lieuStockageVehiculeService.updateLieuStockageVehicule(l);
    }

    @DeleteMapping("SupprimerLieuStockageVehiculeById/{id}")
    public void SupprimerLieuStockageVehiculeById(@PathVariable("id") String codeLieuVH) {
        lieuStockageVehiculeService.deleteLieuStockageVehiculeById(codeLieuVH);
    }


    private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
        return new ResponseEntity<>(
                new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(), message), httpStatus
        );
    }



}
