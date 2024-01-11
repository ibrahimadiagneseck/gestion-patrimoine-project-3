package sn.douanes.gestionstockpostgres.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;


@Entity
@Table(name = "fournisseurs")
public class Fournisseurs {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    // @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "code_fournisseur", nullable = false, updatable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String codeFournisseur;


    @Column(name = "raison_sociale")
    private String raisonSociale;

    @Column(name = "numero_telephone")
    private Integer numeroTelephone;

    @Column(name = "n_i_n_e_a")
    private String ninea;

    @Column(name = "adresse")
    private String adresse;

    @Column(name = "secteur_activite")
    private String secteurActivite;


    public Fournisseurs() {
    }

    public Fournisseurs(String codeFournisseur, String raisonSociale, Integer numeroTelephone, String ninea, String adresse, String secteurActivite) {
        this.codeFournisseur = codeFournisseur;
        this.raisonSociale = raisonSociale;
        this.numeroTelephone = numeroTelephone;
        this.ninea = ninea;
        this.adresse = adresse;
        this.secteurActivite = secteurActivite;
    }

    public String getCodeFournisseur() {
        return codeFournisseur;
    }

    public void setCodeFournisseur(String codeFournisseur) {
        this.codeFournisseur = codeFournisseur;
    }

    public String getRaisonSociale() {
        return raisonSociale;
    }

    public void setRaisonSociale(String raisonSociale) {
        this.raisonSociale = raisonSociale;
    }

    public Integer getNumeroTelephone() {
        return numeroTelephone;
    }

    public void setNumeroTelephone(Integer numeroTelephone) {
        this.numeroTelephone = numeroTelephone;
    }

    public String getNinea() {
        return ninea;
    }

    public void setNinea(String ninea) {
        this.ninea = ninea;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getSecteurActivite() {
        return secteurActivite;
    }

    public void setSecteurActivite(String secteurActivite) {
        this.secteurActivite = secteurActivite;
    }

    @Override
    public String toString() {
        return "Fournisseurs{" +
                "codeFournisseur='" + codeFournisseur + '\'' +
                ", raisonSociale='" + raisonSociale + '\'' +
                ", numeroTelephone=" + numeroTelephone +
                ", ninea='" + ninea + '\'' +
                ", adresse='" + adresse + '\'' +
                ", secteurActivite='" + secteurActivite + '\'' +
                '}';
    }
}