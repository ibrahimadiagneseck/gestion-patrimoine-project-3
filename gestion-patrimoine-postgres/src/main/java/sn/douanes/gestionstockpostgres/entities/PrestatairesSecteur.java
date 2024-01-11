package sn.douanes.gestionstockpostgres.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sn.douanes.gestionstockpostgres.entities.keys.PrestatairesSecteurId;


@Entity
@IdClass(PrestatairesSecteurId.class)
@Table(name = "prestataires_secteur")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PrestatairesSecteur {


    @Id
    @ManyToOne
    @JoinColumn(name = "ninea")
    private Prestataires ninea;

    @Id
    @ManyToOne
    @JoinColumn(name = "code_secteur_activite")
    private SecteurActivite codeSecteurActivite;

}
