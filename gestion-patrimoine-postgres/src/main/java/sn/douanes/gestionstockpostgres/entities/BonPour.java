package sn.douanes.gestionstockpostgres.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.Date;


@Entity
@Table(name = "bon_pour")
public class BonPour {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    // @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "numero_bon_pour", nullable = false, updatable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String numeroBonPour;


    @Column(name = "numero_courrier_origine")
    private Integer numeroCourrierOrigine;

    @Column(name = "date_courrier_origine")
    private Date dateCourrierOrigine;


    @Column(name = "etat_bon_pour")
    private String etatBonPour;


    @Column(name = "object_courrier_origine")
    private String objectCourrierOrigine;

    @Column(name = "numero_arrive_d_l_f")
    private Integer numeroArriveDLF;

    @Column(name = "date_arrive_d_l_f")
    private Date dateArriveDLF;

    @Column(name = "numero_arrive_d_l_m")
    private Integer numeroArriveBLM;

    @Column(name = "date_arrive_d_l_m")
    private Date dateArriveBLM;

    @Column(name = "numero_arrive_section")
    private Integer numeroArriveSection;

    @Column(name = "date_arrive_section")
    private Date dateArriveSection;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "code_unite_douaniere", referencedColumnName = "code_unite_douaniere")
    private UniteDouaniere codeUniteDouaniere;


    public BonPour() {
    }

    public BonPour(String numeroBonPour, Integer numeroCourrierOrigine, Date dateCourrierOrigine, String etatBonPour, String objectCourrierOrigine, Integer numeroArriveDLF, Date dateArriveDLF, Integer numeroArriveBLM, Date dateArriveBLM, Integer numeroArriveSection, Date dateArriveSection, UniteDouaniere codeUniteDouaniere) {
        this.numeroBonPour = numeroBonPour;
        this.numeroCourrierOrigine = numeroCourrierOrigine;
        this.dateCourrierOrigine = dateCourrierOrigine;
        this.etatBonPour = etatBonPour;
        this.objectCourrierOrigine = objectCourrierOrigine;
        this.numeroArriveDLF = numeroArriveDLF;
        this.dateArriveDLF = dateArriveDLF;
        this.numeroArriveBLM = numeroArriveBLM;
        this.dateArriveBLM = dateArriveBLM;
        this.numeroArriveSection = numeroArriveSection;
        this.dateArriveSection = dateArriveSection;
        this.codeUniteDouaniere = codeUniteDouaniere;
    }

    public String getNumeroBonPour() {
        return numeroBonPour;
    }

    public void setNumeroBonPour(String numeroBonPour) {
        this.numeroBonPour = numeroBonPour;
    }

    public Integer getNumeroCourrierOrigine() {
        return numeroCourrierOrigine;
    }

    public void setNumeroCourrierOrigine(Integer numeroCourrierOrigine) {
        this.numeroCourrierOrigine = numeroCourrierOrigine;
    }

    public Date getDateCourrierOrigine() {
        return dateCourrierOrigine;
    }

    public void setDateCourrierOrigine(Date dateCourrierOrigine) {
        this.dateCourrierOrigine = dateCourrierOrigine;
    }

    public String getEtatBonPour() {
        return etatBonPour;
    }

    public void setEtatBonPour(String etatBonPour) {
        this.etatBonPour = etatBonPour;
    }

    public String getObjectCourrierOrigine() {
        return objectCourrierOrigine;
    }

    public void setObjectCourrierOrigine(String objectCourrierOrigine) {
        this.objectCourrierOrigine = objectCourrierOrigine;
    }

    public Integer getNumeroArriveDLF() {
        return numeroArriveDLF;
    }

    public void setNumeroArriveDLF(Integer numeroArriveDLF) {
        this.numeroArriveDLF = numeroArriveDLF;
    }

    public Date getDateArriveDLF() {
        return dateArriveDLF;
    }

    public void setDateArriveDLF(Date dateArriveDLF) {
        this.dateArriveDLF = dateArriveDLF;
    }

    public Integer getNumeroArriveBLM() {
        return numeroArriveBLM;
    }

    public void setNumeroArriveBLM(Integer numeroArriveBLM) {
        this.numeroArriveBLM = numeroArriveBLM;
    }

    public Date getDateArriveBLM() {
        return dateArriveBLM;
    }

    public void setDateArriveBLM(Date dateArriveBLM) {
        this.dateArriveBLM = dateArriveBLM;
    }

    public Integer getNumeroArriveSection() {
        return numeroArriveSection;
    }

    public void setNumeroArriveSection(Integer numeroArriveSection) {
        this.numeroArriveSection = numeroArriveSection;
    }

    public Date getDateArriveSection() {
        return dateArriveSection;
    }

    public void setDateArriveSection(Date dateArriveSection) {
        this.dateArriveSection = dateArriveSection;
    }

    public UniteDouaniere getCodeUniteDouaniere() {
        return codeUniteDouaniere;
    }

    public void setCodeUniteDouaniere(UniteDouaniere codeUniteDouaniere) {
        this.codeUniteDouaniere = codeUniteDouaniere;
    }

    @Override
    public String toString() {
        return "BonPour{" +
                "numeroBonPour='" + numeroBonPour + '\'' +
                ", numeroCourrierOrigine=" + numeroCourrierOrigine +
                ", dateCourrierOrigine=" + dateCourrierOrigine +
                ", etatBonPour='" + etatBonPour + '\'' +
                ", objectCourrierOrigine='" + objectCourrierOrigine + '\'' +
                ", numeroArriveDLF=" + numeroArriveDLF +
                ", dateArriveDLF=" + dateArriveDLF +
                ", numeroArriveBLM=" + numeroArriveBLM +
                ", dateArriveBLM=" + dateArriveBLM +
                ", numeroArriveSection=" + numeroArriveSection +
                ", dateArriveSection=" + dateArriveSection +
                ", codeUniteDouaniere=" + codeUniteDouaniere +
                '}';
    }
}