package sn.douanes.gestionstockpostgres.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.douanes.gestionstockpostgres.entities.*;
import sn.douanes.gestionstockpostgres.entities.keys.AgentId;
import sn.douanes.gestionstockpostgres.repositories.AgentRepository;
import sn.douanes.gestionstockpostgres.services.AgentService;


@Service
public class AgentServiceImpl implements AgentService {

    @Autowired
    AgentRepository agentRepository;

    @Override
    public Agent saveAgent(Agent a) {
        return agentRepository.save(a);
    }

    @Override
    public Agent updateAgent(Agent a) {
        return agentRepository.save(a);
    }

    @Override
    public void deleteAgent(Agent a) {
        agentRepository.delete(a);
    }

    @Override
    public void deleteAgentById(String matriculeAgent, CorpsAgent codeCorpsAgent) {
        agentRepository.deleteById(new AgentId(matriculeAgent, codeCorpsAgent));
    }

    @Override
    public Agent getAgentById(String matriculeAgent, CorpsAgent codeCorpsAgent) {
        return agentRepository.findById(new AgentId(matriculeAgent, codeCorpsAgent)).isPresent() ? agentRepository.findById(new AgentId(matriculeAgent, codeCorpsAgent)).get() : null;
    }

    @Override
    public List<Agent> getAllAgents() {
        return agentRepository.findAll();
    }


    @Override
    public Agent ajouterAgent(
            String matriculeAgent,
            String codeAgent,
            String nomAgent,
            String prenomAgent,
            Integer numeroTelephoneAgent,
            FonctionAgent codeFonctionAgent,
            UniteDouaniere codeUniteDouaniere,
            CorpsAgent codeCorpsAgent
    ) {

        Agent agent = new Agent();

        agent.setMatriculeAgent(matriculeAgent);
        agent.setCodeAgent(codeAgent);
        agent.setNomAgent(nomAgent);
        agent.setPrenomAgent(prenomAgent);
        agent.setNumeroTelephoneAgent(numeroTelephoneAgent);
        agent.setCodeFonctionAgent(codeFonctionAgent);
        agent.setCodeUniteDouaniere(codeUniteDouaniere);
        agent.setCodeCorpsAgent(codeCorpsAgent);

        return agentRepository.save(agent);
    }


}
