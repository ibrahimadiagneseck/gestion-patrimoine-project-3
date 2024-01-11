package sn.douanes.gestionstockpostgres.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;


@Entity
@Table(name = "vidange")
public class Vidange {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "numero_immatriculation", nullable = false, updatable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String numeroImmatriculation;

}