package sn.douanes.gestionstockpostgres.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.Date;


@Entity
@Table(name = "bon_de_sortie")
public class BonDeSortie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    // @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "numero_bon_de_sortie", nullable = false, updatable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String numeroBonDeSortie;


    @Column(name = "libelleBonDeSortie")
    private String libelleBonDeSortie;

    @Column(name = "date_bon_de_sortie")
    private Date dateBonDeSortie;

    @Column(name = "observation_bon_de_sortie")
    private String observationBonDeSortie;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "code_unite_douaniere", referencedColumnName = "code_unite_douaniere")
    private UniteDouaniere codeUniteDouaniere;


    public BonDeSortie() {
    }

    public BonDeSortie(String numeroBonDeSortie, String libelleBonDeSortie, Date dateBonDeSortie, String observationBonDeSortie, UniteDouaniere codeUniteDouaniere) {
        this.numeroBonDeSortie = numeroBonDeSortie;
        this.libelleBonDeSortie = libelleBonDeSortie;
        this.dateBonDeSortie = dateBonDeSortie;
        this.observationBonDeSortie = observationBonDeSortie;
        this.codeUniteDouaniere = codeUniteDouaniere;
    }

    public String getNumeroBonDeSortie() {
        return numeroBonDeSortie;
    }

    public void setNumeroBonDeSortie(String numeroBonDeSortie) {
        this.numeroBonDeSortie = numeroBonDeSortie;
    }

    public String getLibelleBonDeSortie() {
        return libelleBonDeSortie;
    }

    public void setLibelleBonDeSortie(String libelleBonDeSortie) {
        this.libelleBonDeSortie = libelleBonDeSortie;
    }

    public Date getDateBonDeSortie() {
        return dateBonDeSortie;
    }

    public void setDateBonDeSortie(Date dateBonDeSortie) {
        this.dateBonDeSortie = dateBonDeSortie;
    }

    public String getObservationBonDeSortie() {
        return observationBonDeSortie;
    }

    public void setObservationBonDeSortie(String observationBonDeSortie) {
        this.observationBonDeSortie = observationBonDeSortie;
    }

    public UniteDouaniere getCodeUniteDouaniere() {
        return codeUniteDouaniere;
    }

    public void setCodeUniteDouaniere(UniteDouaniere codeUniteDouaniere) {
        this.codeUniteDouaniere = codeUniteDouaniere;
    }

    @Override
    public String toString() {
        return "BonDeSortie{" +
                "numeroBonDeSortie='" + numeroBonDeSortie + '\'' +
                ", libelleBonDeSortie='" + libelleBonDeSortie + '\'' +
                ", dateBonDeSortie=" + dateBonDeSortie +
                ", observationBonDeSortie='" + observationBonDeSortie + '\'' +
                ", codeUniteDouaniere=" + codeUniteDouaniere +
                '}';
    }
}