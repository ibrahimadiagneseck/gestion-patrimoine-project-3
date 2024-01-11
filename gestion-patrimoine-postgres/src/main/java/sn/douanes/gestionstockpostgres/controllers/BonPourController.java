package sn.douanes.gestionstockpostgres.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.douanes.gestionstockpostgres.entities.BonEntree;
import sn.douanes.gestionstockpostgres.entities.BonPour;
import sn.douanes.gestionstockpostgres.entities.HttpResponse;
import sn.douanes.gestionstockpostgres.services.BonPourService;

import static org.springframework.http.HttpStatus.OK;


@RestController
//@RequestMapping(path = { "/", "/user"})
@RequestMapping( "/")
@CrossOrigin("http://localhost:4200")
public class BonPourController {

    @Autowired
    BonPourService bonPourService;

    @GetMapping("/BonPours")
    public ResponseEntity<List<BonPour>> getAllBonPours() {
        List<BonPour> bonPour = bonPourService.getAllBonPours();
        return new ResponseEntity<>(bonPour, OK);
    }

    @PostMapping("/AjouterBonPour")
    @ResponseBody
    public BonPour AjouterBonPour(@RequestBody BonPour b) {
        return bonPourService.saveBonPour(b);
    }

    @PutMapping("/ModifierBonPour")
    @ResponseBody
    public BonPour ModifierBonPour(@RequestBody BonPour b) {
        return bonPourService.updateBonPour(b);
    }

    @DeleteMapping("SupprimerBonPourById/{id}")
    public void SupprimerBonPourById(@PathVariable("id") String numeroBonPour) {
        bonPourService.deleteBonPourById(numeroBonPour);
    }


    private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
        return new ResponseEntity<>(
                new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(), message), httpStatus
        );
    }


}
