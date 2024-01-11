package sn.douanes.gestionstockpostgres.services.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.douanes.gestionstockpostgres.entities.BonEntree;
import sn.douanes.gestionstockpostgres.entities.BordereauLivraison;
import sn.douanes.gestionstockpostgres.entities.FonctionAgent;
import sn.douanes.gestionstockpostgres.repositories.FonctionAgentRepository;
import sn.douanes.gestionstockpostgres.services.FonctionAgentService;


@Service
public class FonctionAgentServiceImpl implements FonctionAgentService {

    @Autowired
    FonctionAgentRepository fonctionAgentRepository;

    @Override
    public FonctionAgent saveFonctionAgent(FonctionAgent f) {
        return fonctionAgentRepository.save(f);
    }

    @Override
    public FonctionAgent updateFonctionAgent(FonctionAgent f) {
        return fonctionAgentRepository.save(f);
    }

    @Override
    public void deleteFonctionAgent(FonctionAgent f) {
        fonctionAgentRepository.delete(f);
    }

    @Override
    public void deleteFonctionAgentById(String id) {
        fonctionAgentRepository.deleteById(id);
    }

    @Override
    public FonctionAgent getFonctionAgentById(String id) {
        return fonctionAgentRepository.findById(id).isPresent() ? fonctionAgentRepository.findById(id).get() : null;
    }

    @Override
    public List<FonctionAgent> getAllFonctionAgents() {
        return fonctionAgentRepository.findAll();
    }


    @Override
    public FonctionAgent ajouterFonctionAgent(
            String codeFonctionAgent,
            String libelleFonctionAgent
    ) {

        FonctionAgent fonctionAgent = new FonctionAgent();

        fonctionAgent.setCodeFonctionAgent(codeFonctionAgent);
        fonctionAgent.setLibelleFonctionAgent(libelleFonctionAgent);


        return fonctionAgentRepository.save(fonctionAgent);
    }


}
