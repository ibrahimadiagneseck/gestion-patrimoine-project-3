package sn.douanes.gestionstockpostgres.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;


@Entity
@Table(name = "unite_hierarchique")
public class UniteHierarchique {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    // @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "code_unite_hierarchique", nullable = false, updatable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String codeUniteHierarchique;


    @Column(name = "libelle_unite_hierarchique")
    private String libelleUniteHierarchique;

    @Column(name = "sigle_unite_hierarchique")
    private String sigleUniteHierarchique;

    public UniteHierarchique() {
    }

    public UniteHierarchique(String codeUniteHierarchique, String libelleUniteHierarchique, String sigleUniteHierarchique) {
        this.codeUniteHierarchique = codeUniteHierarchique;
        this.libelleUniteHierarchique = libelleUniteHierarchique;
        this.sigleUniteHierarchique = sigleUniteHierarchique;
    }

    public String getCodeUniteHierarchique() {
        return codeUniteHierarchique;
    }

    public void setCodeUniteHierarchique(String codeUniteHierarchique) {
        this.codeUniteHierarchique = codeUniteHierarchique;
    }

    public String getLibelleUniteHierarchique() {
        return libelleUniteHierarchique;
    }

    public void setLibelleUniteHierarchique(String libelleUniteHierarchique) {
        this.libelleUniteHierarchique = libelleUniteHierarchique;
    }

    public String getSigleUniteHierarchique() {
        return sigleUniteHierarchique;
    }

    public void setSigleUniteHierarchique(String sigleUniteHierarchique) {
        this.sigleUniteHierarchique = sigleUniteHierarchique;
    }

    @Override
    public String toString() {
        return "UniteHierarchique{" +
                "codeUniteHierarchique='" + codeUniteHierarchique + '\'' +
                ", libelleUniteHierarchique='" + libelleUniteHierarchique + '\'' +
                ", sigleUniteHierarchique='" + sigleUniteHierarchique + '\'' +
                '}';
    }
}