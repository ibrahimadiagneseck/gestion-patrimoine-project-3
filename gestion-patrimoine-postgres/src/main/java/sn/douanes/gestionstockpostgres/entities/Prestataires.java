package sn.douanes.gestionstockpostgres.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "prestataires")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Prestataires {

    @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
    // @Column(name = "ninea", nullable = false, updatable = false)
    // @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "ninea", length = 20)
    private String ninea;

    @Column(name = "raison_sociale", length = 512)
    private String raisonSociale;

    @Column(name = "numero_telephone")
    private Integer numeroTelephone;

    @Column(name = "adresse_email", length = 100)
    private String adresseEmail;

    @Column(name = "adresse", length = 512)
    private String adresse;


//    fetch = FetchType.LAZY: Cela spécifie que la récupération
//    des données associées à cette relation doit être effectuée de manière
//    paresseuse (lazy). Cela signifie que les données de la relation ne seront chargées
//    que lorsque vous accéderez explicitement à la propriété prestataires. Cela peut améliorer
//    les performances en évitant le chargement précoce de données potentiellement inutiles.
//    cascade = {CascadeType.PERSIST, CascadeType.MERGE}: Ces options de cascade définissent
//    comment les opérations de persistante (enregistrement) et de fusion (mise à jour) doivent
//    être propagées de l'entité propriétaire

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(
            name = "prestataires_secteur",
            joinColumns = @JoinColumn(name = "ninea"),
            inverseJoinColumns = @JoinColumn(name = "code_secteur_activite")
    )
    private Set<SecteurActivite> secteurActivite = new HashSet<>();


//    https://www.bezkoder.com/jpa-many-to-many/
//    public void addTag(Tag tag) {
//        this.tags.add(tag);
//        tag.getTutorials().add(this);
//    }
//
//    public void removeTag(long tagId) {
//        Tag tag = this.tags.stream().filter(t -> t.getId() == tagId).findFirst().orElse(null);
//        if (tag != null) {
//            this.tags.remove(tag);
//            tag.getTutorials().remove(this);
//        }
//    }


//    // Création d'un prestataire
//    Prestataires prestataire = new Prestataires();
//    prestataire.setNinea("123456789");
//    prestataire.setRaisonSociale("Nom de l'entreprise");
//    prestataire.setNumeroTelephone("0123456789");
//    prestataire.setAdresseEmail("exemple@email.com");
//    prestataire.setAdresse("Adresse de l'entreprise");
//
//    // Création des secteurs d'activité
//    SecteurActivite secteur1 = new SecteurActivite();
//    secteur1.setCodeSecteurActivite("Code1");
//    secteur1.setLibelleSecteurActivite("Libellé 1");
//
//    SecteurActivite secteur2 = new SecteurActivite();
//    secteur2.setCodeSecteurActivite("Code2");
//    secteur2.setLibelleSecteurActivite("Libellé 2");
//
//    // Ajout des secteurs d'activité au prestataire
//    Set<SecteurActivite> secteursActivite = new HashSet<>();
//    secteursActivite.add(secteur1);
//    secteursActivite.add(secteur2);
//
//    prestataire.setSecteursActivite(secteursActivite);



}
