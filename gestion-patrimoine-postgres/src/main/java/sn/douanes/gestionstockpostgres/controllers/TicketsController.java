package sn.douanes.gestionstockpostgres.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.douanes.gestionstockpostgres.entities.HttpResponse;
import sn.douanes.gestionstockpostgres.entities.Sections;
import sn.douanes.gestionstockpostgres.entities.Tickets;
import sn.douanes.gestionstockpostgres.services.TicketsService;

import static org.springframework.http.HttpStatus.OK;


@RestController
//@RequestMapping(path = { "/", "/user"})
@RequestMapping( "/")
@CrossOrigin("http://localhost:4200")
public class TicketsController {

    @Autowired
    TicketsService ticketsService;


    @GetMapping("/Tickets")
    public ResponseEntity<List<Tickets>> getAllTickets() {
        List<Tickets> tickets = ticketsService.getAllTickets();
        return new ResponseEntity<>(tickets, OK);
    }

    @PostMapping("/AjouterTickets")
    @ResponseBody
    public Tickets AjouterTickets(@RequestBody Tickets t) {
        return ticketsService.saveTickets(t);
    }

    @PutMapping("/ModifierTickets")
    @ResponseBody
    public Tickets ModifierTickets(@RequestBody Tickets t) {

        return ticketsService.updateTickets(t);
    }

    @DeleteMapping("SupprimerTicketsById/{id}")
    public void SupprimerTicketsById(@PathVariable("id") Long numero_ticket) {
        ticketsService.deleteTicketsById(numero_ticket);
    }


    private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
        return new ResponseEntity<>(
                new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(), message), httpStatus
        );
    }



}
