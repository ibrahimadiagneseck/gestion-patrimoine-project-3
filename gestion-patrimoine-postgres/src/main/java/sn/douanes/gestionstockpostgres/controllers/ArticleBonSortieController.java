package sn.douanes.gestionstockpostgres.controllers;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.douanes.gestionstockpostgres.entities.*;
import sn.douanes.gestionstockpostgres.services.ArticleBonSortieService;

import static org.springframework.http.HttpStatus.OK;


@RestController
//@RequestMapping(path = { "/", "/user"})
@RequestMapping( "/")
@CrossOrigin("http://localhost:4200")
public class ArticleBonSortieController {

    @Autowired
    ArticleBonSortieService articleBonSortieService;


    @GetMapping("/ArticleBonSorties")
    public ResponseEntity<List<ArticleBonSortie>> getAllArticleBonSorties() {
        List<ArticleBonSortie> articleBonSortie = articleBonSortieService.getAllArticleBonSorties();
        return new ResponseEntity<>(articleBonSortie, OK);
    }

    @PostMapping("/AjouterArticleBonSortie")
    @ResponseBody
    public ArticleBonSortie AjouterArticleBonEntree(@RequestBody ArticleBonSortie articleBonSortie) {
        return articleBonSortieService.ajouterArticleBonSortie(articleBonSortie.getIdentifiantBS(), articleBonSortie.getCodeArticleBonSortie(), articleBonSortie.getLibelleArticleBonSortie(), articleBonSortie.getQuantiteAccordee(),  articleBonSortie.getMatriculeAgent());
    }

    @PutMapping("/ModifierArticleBonSortie")
    @ResponseBody
    public ArticleBonSortie ModifierArticleBonSortie(@RequestBody ArticleBonSortie a) {
        return articleBonSortieService.updateArticleBonSortie(a);
    }

    @DeleteMapping("SupprimerArticleBonSortieById/{codeArticleBonSortie}/{identifiantBS}")
    public void SupprimerArticleBonSortie(
            @PathVariable("codeArticleBonSorties") String codeArticleBonSortie,
            @PathVariable("identifiantBS") BonDeSortie identifiantBS
    ) {
        articleBonSortieService.deleteArticleBonSortieById(codeArticleBonSortie, identifiantBS);
    }


    private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
        return new ResponseEntity<>(
                new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(), message), httpStatus
        );
    }

}
