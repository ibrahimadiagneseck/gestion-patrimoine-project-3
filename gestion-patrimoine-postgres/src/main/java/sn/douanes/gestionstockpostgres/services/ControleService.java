package sn.douanes.gestionstockpostgres.services;

import sn.douanes.gestionstockpostgres.entities.Controle;

import java.util.List;

public interface ControleService {

    Controle saveControle(Controle c);
    Controle updateControle(Controle c);
    void deleteControle(Controle c);
    void deleteControleById(String id);
    Controle getControle(String id);
    List<Controle> getAllControles();


}
