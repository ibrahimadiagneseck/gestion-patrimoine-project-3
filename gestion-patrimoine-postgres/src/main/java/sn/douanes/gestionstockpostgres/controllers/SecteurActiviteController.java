package sn.douanes.gestionstockpostgres.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.douanes.gestionstockpostgres.entities.HttpResponse;
import sn.douanes.gestionstockpostgres.entities.SecteurActivite;
import sn.douanes.gestionstockpostgres.services.SecteurActiviteService;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;


@RestController
//@RequestMapping(path = { "/", "/user"})
@RequestMapping( "/")
@CrossOrigin("http://localhost:4200")
public class SecteurActiviteController {

    @Autowired
    SecteurActiviteService secteurActiviteService;


    @GetMapping("/SecteurActivites")
    public ResponseEntity<List<SecteurActivite>> getAllSecteurActivite() {
        List<SecteurActivite> secteurActivite = secteurActiviteService.getAllSecteurActivites();
        return new ResponseEntity<>(secteurActivite, OK);
    }

    @PostMapping("/AjouterSecteurActivite")
    @ResponseBody
    public SecteurActivite AjouterSecteurActivite(@RequestBody SecteurActivite secteurActivite) {
        return secteurActiviteService.saveSecteurActivite(secteurActivite);
    }

    @PostMapping("/AjouterRequestParamSecteurActivite")
    public ResponseEntity<SecteurActivite> ajouterSecteurActivite (
            @RequestParam("codeSecteurActivite") String codeSecteurActivite,
            @RequestParam("libelleSecteurActivite") String libelleSecteurActivite
    ) {
        SecteurActivite secteurActivite = secteurActiviteService.ajouterSecteurActivite(codeSecteurActivite, libelleSecteurActivite);
        return new ResponseEntity<>(secteurActivite, OK);
    }


    @PutMapping("/ModifierSecteurActivite")
    @ResponseBody
    public SecteurActivite ModifierSecteurActivite(@RequestBody SecteurActivite p) {

        return secteurActiviteService.updateSecteurActivite(p);
    }

    @DeleteMapping("SupprimerSecteurActiviteById/{id}")
    public void SupprimerSecteurActiviteById(@PathVariable("id") String codeSecteurActivite) {
        secteurActiviteService.deleteSecteurActiviteById(codeSecteurActivite);
    }


    private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
        return new ResponseEntity<>(
                new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(), message), httpStatus
        );
    }


}
