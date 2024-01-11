package sn.douanes.gestionstockpostgres.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "fonction_agent")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FonctionAgent {

    @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
    // @Column(name = "code_fonction_agent", nullable = false, updatable = false)
    // @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "code_fonction_agent", length = 10)
    private String codeFonctionAgent;

    @Column(name = "libelle_fonction_agent", length = 100)
    private String libelleFonctionAgent;

}