package sn.douanes.gestionstockpostgres.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;


@Entity
@Table(name = "type_arme")
public class TypeArme {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    // @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "code_type_arme", nullable = false, updatable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String codeTypeArme;


    @Column(name = "libelle_type_arme")
    private String libelleTypeArme;


    public TypeArme() {
    }

    public TypeArme(String codeTypeArme, String libelleTypeArme) {
        this.codeTypeArme = codeTypeArme;
        this.libelleTypeArme = libelleTypeArme;
    }

    public String getCodeTypeArme() {
        return codeTypeArme;
    }

    public void setCodeTypeArme(String codeTypeArme) {
        this.codeTypeArme = codeTypeArme;
    }

    public String getLibelleTypeArme() {
        return libelleTypeArme;
    }

    public void setLibelleTypeArme(String libelleTypeArme) {
        this.libelleTypeArme = libelleTypeArme;
    }

    @Override
    public String toString() {
        return "TypeArme{" +
                "codeTypeArme='" + codeTypeArme + '\'' +
                ", libelleTypeArme='" + libelleTypeArme + '\'' +
                '}';
    }
}