package sn.douanes.gestionstockpostgres.entities.keys;

import sn.douanes.gestionstockpostgres.entities.CorpsAgent;

import java.io.Serializable;

public class AgentId implements Serializable {

    private String matriculeAgent;

    private CorpsAgent codeCorpsAgent;

    public AgentId() {
    }

    public AgentId(String matriculeAgent, CorpsAgent codeCorpsAgent) {
        this.matriculeAgent = matriculeAgent;
        this.codeCorpsAgent = codeCorpsAgent;
    }
}
