package sn.douanes.gestionstockpostgres.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sn.douanes.gestionstockpostgres.entities.Prestataires;

import java.util.List;


@Repository
public interface PrestatairesRepository extends JpaRepository<Prestataires, String> {



//    @Query : C'est une annotation de Spring Data JPA qui permet
//    de définir une requête JPQL (Java Persistence Query Language).
//    JPQL est un langage de requête orienté objet utilisé dans le contexte de la persistance Java.
//    "SELECT DISTINCT p FROM Prestataires p LEFT JOIN FETCH p.secteurActivite" :
//    SELECT DISTINCT p : Indique que vous voulez sélectionner distinctement
//    l'objet Prestataires (représenté par la variable p dans cette requête).
//    FROM Prestataires p : Spécifie la classe d'entité à partir de laquelle
//    vous récupérez les données (dans ce cas, la classe Prestataires).
//    LEFT JOIN FETCH p.secteurActivite : Indique une jointure gauche (LEFT JOIN)
//    entre la table des prestataires et la table des secteurs d'activité (secteurActivite).
//    La clause FETCH est utilisée pour charger les secteurs d'activité en même temps
//    que les prestataires, évitant ainsi le problème du chargement paresseux.
//    La jointure permet de récupérer les secteurs d'activité associés à chaque prestataire.
    @Query("SELECT DISTINCT p FROM Prestataires p LEFT JOIN FETCH p.secteurActivite")
    List<Prestataires> findAllWithSecteursActivite();
}
