package sn.douanes.gestionstockpostgres.controllers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.douanes.gestionstockpostgres.entities.HttpResponse;
import sn.douanes.gestionstockpostgres.entities.Prestataires;
import sn.douanes.gestionstockpostgres.entities.SecteurActivite;
import sn.douanes.gestionstockpostgres.services.PrestatairesService;

import static org.springframework.http.HttpStatus.OK;


@RestController
//@RequestMapping(path = { "/", "/user"})
@RequestMapping( "/")
@CrossOrigin("http://localhost:4200")
public class PrestatairesController {

    public static final String PRESTATAIRES_DELETED_SUCCESSFULLY = "Suppression réussie de ";

    @Autowired
    PrestatairesService prestatairesService;


    @GetMapping("/Prestataires")
    public ResponseEntity<List<Prestataires>> getAllPrestataires() {

        // METHODE 1
        // List<Prestataires> prestataires = prestatairesService.getAllPrestataires();
        // if (prestataires.isEmpty()) {
        //     return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        // } else {
        //     for (Prestataires prestataire : prestataires) {
        //         Set<SecteurActivite> secteursActivite = prestatairesService.getSecteurActiviteByPrestataires(prestataire);
        //         prestataire.setSecteurActivite(secteursActivite);
        //    }
        //    return new ResponseEntity<>(prestataires, HttpStatus.OK);
        // }



        // METHODE 2
//        List<Prestataires> prestataires = prestatairesService.getAllPrestataires();
//        // Charger les secteurs d'activité de manière paresseuse (lazy) avant de retourner la réponse
//        prestataires.forEach(prestataire -> prestataire.getSecteurActivite().size());
//        return new ResponseEntity<>(prestataires, HttpStatus.OK);

        // METHODE 3
         List<Prestataires> prestataires = prestatairesService.getAllPrestatairesWithSecteursActivite();

         return new ResponseEntity<>(prestataires, HttpStatus.OK);
    }

    @PostMapping("/AjouterPrestataires")
    @ResponseBody
    public ResponseEntity<Prestataires> AjouterPrestataires(@RequestBody Prestataires prestataires) {
        // Assurez-vous que SecteurActivite n'est pas null pour éviter la NullPointerException
//        if (prestataires.getSecteurActivite() != null) {
//            // Récupérer les entités SecteurActivite associées à Prestataires
//            Set<SecteurActivite> secteurActivites = prestataires.getSecteurActivite();
//
//            // Associer Prestataires avec chaque SecteurActivite
//            for (SecteurActivite secteurActivite : secteurActivites) {
//                // Assurez-vous que l'ensemble Prestataires dans SecteurActivite n'est pas null
//                if (secteurActivite.getPrestataires() == null) {
//                    secteurActivite.setPrestataires(new HashSet<>());
//                }
//
//                // Associer Prestataires avec SecteurActivite
//                secteurActivite.getPrestataires().add(prestataires);
//            }
//
//            // Mettre à jour l'ensemble de SecteurActivite associé à l'entité Prestataires
//            prestataires.setSecteurActivite(secteurActivites);
//        }

        // Enregistrer l'entité Prestataires avec ses associations
        Prestataires savedPrestataires = prestatairesService.savePrestataires(prestataires);

        // Retourner l'entité Prestataires avec le statut 201 Created
        return new ResponseEntity<>(savedPrestataires, HttpStatus.CREATED);
    }


    @PostMapping("/AjouterRequestParamPrestataires")
    public ResponseEntity<Prestataires> ajouterPrestataires (
            @RequestParam("ninea") String ninea,
            @RequestParam("raisonSociale") String raisonSociale,
            @RequestParam("numeroTelephone") Integer numeroTelephone,
            @RequestParam("adresseEmail") String adresseEmail,
            @RequestParam("adresse") String adresse
    ) {
        Set<SecteurActivite> secteurActivite = new HashSet<>();
        Prestataires prestataires = prestatairesService.ajouterPrestataires(ninea, raisonSociale, numeroTelephone, adresseEmail, adresse, secteurActivite);
        return new ResponseEntity<>(prestataires, OK);
    }


    @PutMapping("/ModifierPrestataires")
    @ResponseBody
    public ResponseEntity<Prestataires> ModifierPrestataires(@RequestBody Prestataires prestataires) {

        Prestataires updatePrestataires = prestatairesService.updatePrestataires(prestataires);
        // Retourner l'entité Prestataires avec le statut 201 Created
        return new ResponseEntity<>(updatePrestataires, OK);
    }

    @DeleteMapping("SupprimerPrestatairesById/{ninea}")
    public ResponseEntity<HttpResponse> SupprimerPrestatairesById(@PathVariable("ninea") String ninea) {

        prestatairesService.deletePrestatairesById(ninea);
        return response(OK, PRESTATAIRES_DELETED_SUCCESSFULLY + ninea);
    }


    private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
        return new ResponseEntity<>(
                new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(), message), httpStatus
        );
    }


}
