package sn.douanes.gestionstockpostgres.controllers;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.douanes.gestionstockpostgres.entities.*;
import sn.douanes.gestionstockpostgres.services.AgentService;

import static org.springframework.http.HttpStatus.OK;


@RestController
//@RequestMapping(path = { "/", "/user"})
@RequestMapping( "/")
@CrossOrigin("http://localhost:4200")
public class AgentController {

    @Autowired
    AgentService agentService;


    @GetMapping("/Agents")
    public ResponseEntity<List<Agent>> getAllAgents() {
        List<Agent> agents = agentService.getAllAgents();
        return new ResponseEntity<>(agents, OK);
    }

    @PostMapping("/AjouterAgent")
    @ResponseBody
    public Agent AjouterAgent(@RequestBody Agent agent) {
        return agentService.saveAgent(agent);
    }

    @PostMapping("/AjouterRequestParamAgent")
    public ResponseEntity<Agent> ajouterAgent (
            @RequestParam("matriculeAgent") String matriculeAgent,
            @RequestParam("codeAgent") String codeAgent,
            @RequestParam("nomAgent") String nomAgent,
            @RequestParam("prenomAgent") String prenomAgent,
            @RequestParam("numeroTelephoneAgent") Integer numeroTelephoneAgent,
            @RequestParam("codeFonctionAgent") FonctionAgent codeFonctionAgent,
            @RequestParam("codeUniteDouaniere") UniteDouaniere codeUniteDouaniere,
            @RequestParam("codeCorpsAgent") CorpsAgent codeCorpsAgent
    ) {
        Agent agent = agentService.ajouterAgent(matriculeAgent, codeAgent, nomAgent, prenomAgent, numeroTelephoneAgent, codeFonctionAgent, codeUniteDouaniere, codeCorpsAgent);
        return new ResponseEntity<>(agent, OK);
    }

    @PutMapping("/ModifierAgent")
    @ResponseBody
    public Agent ModifierAgent(@RequestBody Agent a) {
        return agentService.updateAgent(a);
    }

    @DeleteMapping("SupprimerAgentById/{id}")
    public void SupprimerAgentById(
            @PathVariable("matriculeAgent") String matriculeAgent,
            @PathVariable("codeCorpsAgent") CorpsAgent codeCorpsAgent
    ) {
        agentService.deleteAgentById(matriculeAgent, codeCorpsAgent);
    }


    private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
        return new ResponseEntity<>(
                new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(), message), httpStatus
        );
    }

}
