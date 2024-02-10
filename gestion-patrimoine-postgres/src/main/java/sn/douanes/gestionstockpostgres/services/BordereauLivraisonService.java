package sn.douanes.gestionstockpostgres.services;

import sn.douanes.gestionstockpostgres.entities.Agent;
import sn.douanes.gestionstockpostgres.entities.BordereauLivraison;
import sn.douanes.gestionstockpostgres.entities.Prestataires;
import sn.douanes.gestionstockpostgres.entities.Sections;

import java.sql.Date;
import java.util.List;

public interface BordereauLivraisonService {

    BordereauLivraison saveBordereauLivraison(BordereauLivraison b);
    BordereauLivraison updateBordereauLivraison(BordereauLivraison b);
    void deleteBordereauLivraison(BordereauLivraison b);
    void deleteBordereauLivraisonById(String id);
    BordereauLivraison getBordereauLivraisonById(String id);
    List<BordereauLivraison> getAllBordereauLivraisons();

    BordereauLivraison ajouterBordereauLivraison(String numeroBL, String descriptionBL, String lieuDeLivraison, Date dateBL, String conformiteBL, String representantPrestataire, Sections codeSection, Prestataires ninea, Agent matriculeAgent);

    List<BordereauLivraison> getAllBordereauByNinea(Prestataires ninea);
}
