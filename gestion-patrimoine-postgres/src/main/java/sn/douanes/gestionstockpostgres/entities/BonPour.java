package sn.douanes.gestionstockpostgres.entities;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.sql.Timestamp;


@Entity
@Table(name = "bon_pour")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class BonPour {

    @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
    // @Column(name = "identifiant_b_l", nullable = false, updatable = false)
    // @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "identifiant_b_p", length = 25)
    private String identifiantBP;

    @Column(name = "description_b_p", length = 100)
    private String descriptionBP;

    @Column(name = "numero_courriel_origine")
    private Integer numeroCourrielOrigine;

    @Column(name = "date_courriel_origine")
    private Date dateCourrielOrigine;

    @Column(name = "etat_b_p", length = 10)
    private String etatBP;

    @Column(name = "object_courriel_origine")
    private String objectCourrielOrigine;

    @Column(name = "numero_arrive_d_l_f")
    private Integer numeroArriveDLF;

    @Column(name = "date_arrive_d_l_f")
    private Date dateArriveDLF;

    @Column(name = "observation_d_l_f")
    private String observationDLF;

    @Column(name = "numero_arrive_b_l_m")
    private Integer numeroArriveBLM;

    @Column(name = "date_arrive_b_l_m")
    private Date dateArriveBLM;

    @Column(name = "observation_b_l_m")
    private String observationBLM;

    @Column(name = "numero_arrive_section")
    private Integer numeroArriveSection;

    @Column(name = "date_arrive_section")
    private Date dateArriveSection;

    @Column(name = "observation_section")
    private String observationSection;


    @ManyToOne
    @JoinColumn(name = "code_unite_douaniere")
    private UniteDouaniere codeUniteDouaniere;

    @ManyToOne
    @JoinColumn(name = "code_section")
    private Sections codeSection;


    @Column(name = "date_enregistrement")
    private Timestamp dateEnregistrement;


    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "matricule_agent", referencedColumnName = "matricule_agent"),
            @JoinColumn(name = "code_corps_agent", referencedColumnName = "code_corps_agent")
    })
    private Agent matriculeAgent;




}