package sn.douanes.gestionstockpostgres.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.douanes.gestionstockpostgres.entities.ArticleBonSortie;
import sn.douanes.gestionstockpostgres.entities.BonDeSortie;
import sn.douanes.gestionstockpostgres.entities.HttpResponse;
import sn.douanes.gestionstockpostgres.services.BonDeSortieService;

import static org.springframework.http.HttpStatus.OK;


@RestController
//@RequestMapping(path = { "/", "/user"})
@RequestMapping( "/")
@CrossOrigin("http://localhost:4200")
public class BonDeSortieController {

    @Autowired
    BonDeSortieService bonDeSortieService;

    @GetMapping("/BonDeSorties")
    public ResponseEntity<List<BonDeSortie>> getAllBonDeSorties() {
        List<BonDeSortie> bonDeSortie = bonDeSortieService.getAllBonDeSorties();
        return new ResponseEntity<>(bonDeSortie, OK);
    }

    @PostMapping("/AjouterBonDeSortie")
    @ResponseBody
    public BonDeSortie AjouterBonDeSortie(@RequestBody BonDeSortie b) {
        return bonDeSortieService.saveBonDeSortie(b);
    }

    @PutMapping("/ModifierBonDeSortie")
    @ResponseBody
    public BonDeSortie ModifierBonDeSortie(@RequestBody BonDeSortie b) {

        return bonDeSortieService.updateBonDeSortie(b);
    }

    @DeleteMapping("SupprimerBonDeSortieById/{id}")
    public void SupprimerBonDeSortieById(@PathVariable("id") String numeroBonSortie) {
        bonDeSortieService.deleteBonDeSortieById(numeroBonSortie);
    }


    private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
        return new ResponseEntity<>(
                new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(), message), httpStatus
        );
    }


}
