package sn.douanes.gestionstockpostgres.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import sn.douanes.gestionstockpostgres.entities.keys.AgentId;

import java.util.List;


@Entity
@IdClass(AgentId.class)
@Table(name = "agent")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Agent {

    @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
    // @Column(name = "matricule_agent", nullable = false, updatable = false)
    // @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "matricule_agent", length = 7)
    private String matriculeAgent;

    @Column(name = "code_agent", unique = true, length = 5)
    private String codeAgent;

    @Column(name = "nom_agent", length = 100)
    private String nomAgent;

    @Column(name = "prenom_agent")
    private String prenomAgent;


    @Column(name = "numero_telephone_agent")
    private Integer numeroTelephoneAgent;


    @ManyToOne
    @JoinColumn(name = "code_fonction_agent")
    private FonctionAgent codeFonctionAgent;

    @ManyToOne
    @JoinColumn(name = "code_unite_douaniere")
    private UniteDouaniere codeUniteDouaniere;

    @Id
    @ManyToOne
    @JoinColumn(name = "code_corps_agent")
    private CorpsAgent codeCorpsAgent;

}
