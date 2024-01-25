package sn.douanes.gestionstockpostgres.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "sections")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Sections {

    @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
    // @Column(name = "code_section", nullable = false, updatable = false)
    // @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "code_section", length = 3)
    private String codeSection;

    @Column(name = "libelle_section", length = 100)
    private String libelleSection;

//    @ManyToOne
//    @JoinColumn(name = "code_unite_douaniere")
//    private UniteDouaniere codeUniteDouaniere;

    // @OneToMany(mappedBy = "sections", cascade = CascadeType.ALL, orphanRemoval = true)
//    @OneToMany(mappedBy = "sections", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<UniteDouaniere> uniteDouanieres = new ArrayList<>();
}
