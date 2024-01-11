package sn.douanes.gestionstockpostgres.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.douanes.gestionstockpostgres.entities.ArticleBonEntree;
import sn.douanes.gestionstockpostgres.entities.ArticleBonPour;
import sn.douanes.gestionstockpostgres.entities.HttpResponse;
import sn.douanes.gestionstockpostgres.services.ArticleBonPourService;

import static org.springframework.http.HttpStatus.OK;


@RestController
//@RequestMapping(path = { "/", "/user"})
@RequestMapping( "/")
@CrossOrigin("http://localhost:4200")
public class ArticleBonPourController {

    @Autowired
    ArticleBonPourService articleBonPourService;


    @GetMapping("/ArticleBonPours")
    public ResponseEntity<List<ArticleBonPour>> getAllArticleBonPours() {
        List<ArticleBonPour> articleBonPour = articleBonPourService.getAllArticleBonPours();
        return new ResponseEntity<>(articleBonPour, OK);
    }

    @PostMapping("/AjouterArticleBonPour")
    @ResponseBody
    public ArticleBonPour AjouterArticleBonPour(@RequestBody ArticleBonPour a) {
        return articleBonPourService.saveArticleBonPour(a);
    }

    @PutMapping("/ModifierArticleBonPour")
    @ResponseBody
    public ArticleBonPour ModifierArticleBonPour(@RequestBody ArticleBonPour a) {
        return articleBonPourService.updateArticleBonPour(a);
    }

    @DeleteMapping("SupprimerArticleBonPourById/{id}")
    public void SupprimerArticleBonPourById(@PathVariable("id") String  numeroBonPour  ) {
        articleBonPourService.deleteArticleBonPourById(numeroBonPour);
    }


    private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
        return new ResponseEntity<>(
                new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(), message), httpStatus
        );
    }


}
