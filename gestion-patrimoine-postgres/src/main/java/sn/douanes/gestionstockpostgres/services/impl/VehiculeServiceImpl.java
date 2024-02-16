package sn.douanes.gestionstockpostgres.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.douanes.gestionstockpostgres.entities.*;
import sn.douanes.gestionstockpostgres.repositories.VehiculeRepository;
import sn.douanes.gestionstockpostgres.services.VehiculeService;

import java.sql.Date;
import java.util.List;
import java.util.Set;


@Service
public class VehiculeServiceImpl implements VehiculeService {

    @Autowired
    VehiculeRepository vehiculeRepository;

    @Override
    public Vehicule saveVehicule(Vehicule v) {
        return vehiculeRepository.save(v);
    }

    @Override
    public Vehicule updateVehicule(Vehicule v) {
        return vehiculeRepository.save(v);
    }

    @Override
    public void deleteVehicule(Vehicule v) {
        vehiculeRepository.delete(v);
    }

    @Override
    public void deleteVehiculeById(String id) {
        vehiculeRepository.deleteById(id);
    }

    @Override
    public Vehicule getVehiculeById(String id) {
        return vehiculeRepository.findById(id).isPresent() ? vehiculeRepository.findById(id).get() : null;
    }

    @Override
    public List<Vehicule> getAllVehicules() {
        return vehiculeRepository.findAll();
    }


    @Override
    public Vehicule ajouterVehicule(
            String numeroSerie,
            String numeroImmatriculation,
            String modele,
            EtatVehicule codeEtat,
            TypeEnergie codeTypeEnergie,
            String numeroCarteGrise,
            Date dateMiseEnCirculation,
            Pays codePays,
            TypeVehicule codeTypeVehicule,
            MarqueVehicule codeMarque,
            ArticleBonEntree identifiantBE

    ) {

        Vehicule vehicule = new Vehicule();

        vehicule.setNumeroSerie(numeroSerie);
        vehicule.setNumeroImmatriculation(numeroImmatriculation);
        vehicule.setModele(modele);
        vehicule.setCodeEtat(codeEtat);
        vehicule.setCodeTypeEnergie(codeTypeEnergie);
        vehicule.setNumeroCarteGrise(numeroCarteGrise);
        vehicule.setDateMiseEnCirculation(dateMiseEnCirculation);
        vehicule.setCodePays(codePays);
        vehicule.setCodeTypeVehicule(codeTypeVehicule);
        vehicule.setCodeMarque(codeMarque);
        vehicule.setIdentifiantBE(identifiantBE);


        vehiculeRepository.save(vehicule);
        return vehicule;
    }

    @Override
    public Vehicule ajouterVehiculeDotation(

            Vehicule vehicule,
            Set<DotationVehicule> dotationVehicule
    ) {


        vehicule.setDotationVehicule(dotationVehicule);

        vehiculeRepository.save(vehicule);
        return vehicule;
    }

}
