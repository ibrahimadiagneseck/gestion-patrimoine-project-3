package sn.douanes.gestionstockpostgres.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.douanes.gestionstockpostgres.entities.Fournisseurs;
import sn.douanes.gestionstockpostgres.entities.HttpResponse;
import sn.douanes.gestionstockpostgres.entities.Maintenance;
import sn.douanes.gestionstockpostgres.services.MaintenanceService;

import static org.springframework.http.HttpStatus.OK;


@RestController
//@RequestMapping(path = { "/", "/user"})
@RequestMapping( "/")
@CrossOrigin("http://localhost:4200")
public class MaintenanceController {

    @Autowired
    MaintenanceService maintenanceService;


    @GetMapping("/Maintenances")
    public ResponseEntity<List<Maintenance>> getAllMaintenances() {
        List<Maintenance> maintenance = maintenanceService.getAllMaintenances();
        return new ResponseEntity<>(maintenance, OK);
    }

    @PostMapping("/AjouterMaintenance")
    @ResponseBody
    public Maintenance AjouterMaintenance(@RequestBody Maintenance m) {
        return maintenanceService.saveMaintenance(m);
    }

    @PutMapping("/ModifierMaintenance")
    @ResponseBody
    public Maintenance ModifierMaintenance(@RequestBody Maintenance m) {
        return maintenanceService.updateMaintenance(m);
    }

    @DeleteMapping("SupprimerMaintenanceById/{id}")
    public void SupprimerMaintenanceById(@PathVariable("id") String maintenance ) {
        maintenanceService.deleteMaintenanceById(maintenance);
    }


    private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
        return new ResponseEntity<>(
                new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(), message), httpStatus
        );
    }


}
