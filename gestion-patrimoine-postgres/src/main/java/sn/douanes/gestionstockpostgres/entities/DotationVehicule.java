package sn.douanes.gestionstockpostgres.entities;

import jakarta.persistence.*;
import lombok.*;
import sn.douanes.gestionstockpostgres.entities.keys.ArticleBonSortieId;
import sn.douanes.gestionstockpostgres.entities.keys.DotationVehiculeId;

import java.sql.Date;
import java.sql.Timestamp;

@Entity
@IdClass(DotationVehiculeId.class)
@Table(name = "dotation_vehicule")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class DotationVehicule {

    @Id
    @Column(name = "date_dotation")
    private Timestamp dateDotation;

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "numero_serie")
    private Vehicule numeroSerie;


    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "identifiant_b_s", referencedColumnName = "identifiant_b_s"),
            @JoinColumn(name = "code_article_bon_sortie", referencedColumnName = "code_article_bon_sortie")
    })
    private ArticleBonSortie identifiantBS;



    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "matricule_agent", referencedColumnName = "matricule_agent"),
            @JoinColumn(name = "code_corps_agent", referencedColumnName = "code_corps_agent")
    })
    private Agent matriculeAgent;


}