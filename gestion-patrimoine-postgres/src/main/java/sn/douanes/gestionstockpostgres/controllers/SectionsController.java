package sn.douanes.gestionstockpostgres.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.douanes.gestionstockpostgres.entities.*;
import sn.douanes.gestionstockpostgres.services.SectionsService;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;


@RestController
//@RequestMapping(path = { "/", "/user"})
@RequestMapping( "/")
@CrossOrigin("http://localhost:4200")
public class SectionsController {

    @Autowired
    SectionsService sectionsService;


    @GetMapping("/Sections")
    public ResponseEntity<List<Sections>> getAllSectionss() {
        List<Sections> sections = sectionsService.getAllSectionss();
        return new ResponseEntity<>(sections, OK);
    }

    @PostMapping("/AjouterSections")
    @ResponseBody
    public Sections AjouterSections(@RequestBody Sections sections) {
        return sectionsService.saveSections(sections);
    }

    @PostMapping("/AjouterRequestParamSections")
    public ResponseEntity<Sections> ajouterSections (
            @RequestParam("numeroBE") String codeSection,
            @RequestParam("numeroBE") String libelleSection,
            @RequestParam("numeroBE") UniteDouaniere codeUniteDouaniere
    ) {
        Sections sections = sectionsService.ajouterSections(codeSection, libelleSection, codeUniteDouaniere);
        return new ResponseEntity<>(sections, OK);
    }

    @PutMapping("/ModifierSections")
    @ResponseBody
    public Sections ModifierSections(@RequestBody Sections t) {

        return sectionsService.updateSections(t);
    }

    @DeleteMapping("SupprimerSectionsById/{id}")
    public void SupprimerSectionsById(@PathVariable("id") String codeSection) {
        sectionsService.deleteSectionsById(codeSection);
    }


    private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
        return new ResponseEntity<>(
                new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(), message), httpStatus
        );
    }


}
