package sn.douanes.gestionstockpostgres.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.Date;


@Entity
@Table(name = "controle")
public class Controle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    // @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "numero_immatriculation", nullable = false, updatable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String numeroImmatriculation;


    @Column(name = "date_controle")
    private Date dateControle;

    @Column(name = "observation_controle")
    private String observationControle;


    public Controle() {
    }

    public Controle(String numeroImmatriculation, Date dateControle, String observationControle) {
        this.numeroImmatriculation = numeroImmatriculation;
        this.dateControle = dateControle;
        this.observationControle = observationControle;
    }

    public String getNumeroImmatriculation() {
        return numeroImmatriculation;
    }

    public void setNumeroImmatriculation(String numeroImmatriculation) {
        this.numeroImmatriculation = numeroImmatriculation;
    }

    public Date getDateControle() {
        return dateControle;
    }

    public void setDateControle(Date dateControle) {
        this.dateControle = dateControle;
    }

    public String getObservationControle() {
        return observationControle;
    }

    public void setObservationControle(String observationControle) {
        this.observationControle = observationControle;
    }

    @Override
    public String toString() {
        return "Controle{" +
                "numeroImmatriculation='" + numeroImmatriculation + '\'' +
                ", dateControle=" + dateControle +
                ", observationControle='" + observationControle + '\'' +
                '}';
    }
}