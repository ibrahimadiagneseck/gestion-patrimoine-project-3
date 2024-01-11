package sn.douanes.gestionstockpostgres.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "type_unite_douaniere")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TypeUniteDouaniere {

    @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
    // @Column(name = "code_type_unite_douaniere", nullable = false, updatable = false)
    // @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "code_type_unite_douaniere", length = 5)
    private String codeTypeUniteDouaniere;


    @Column(name = "libelle_type_unite_douaniere", length = 100)
    private String libelleTypeUniteDouaniere;

}
