package sn.douanes.gestionstockpostgres.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;


@Entity
@Table(name = "type_materiel")
public class TypeMateriel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    // @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "code_type_materiel", nullable = false, updatable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String codeTypeMateriel;


    @Column(name = "libelle_type_materiel")
    private String libelle_type_materiel;


    public TypeMateriel() {
    }

    public TypeMateriel(String codeTypeMateriel, String libelle_type_materiel) {
        this.codeTypeMateriel = codeTypeMateriel;
        this.libelle_type_materiel = libelle_type_materiel;
    }

    public String getCodeTypeMateriel() {
        return codeTypeMateriel;
    }

    public void setCodeTypeMateriel(String codeTypeMateriel) {
        this.codeTypeMateriel = codeTypeMateriel;
    }

    public String getLibelle_type_materiel() {
        return libelle_type_materiel;
    }

    public void setLibelle_type_materiel(String libelle_type_materiel) {
        this.libelle_type_materiel = libelle_type_materiel;
    }

    @Override
    public String toString() {
        return "TypeMateriel{" +
                "codeTypeMateriel='" + codeTypeMateriel + '\'' +
                ", libelle_type_materiel='" + libelle_type_materiel + '\'' +
                '}';
    }
}