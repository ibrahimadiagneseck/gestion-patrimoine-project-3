package sn.douanes.gestionstockpostgres.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.douanes.gestionstockpostgres.entities.Maintenance;
import sn.douanes.gestionstockpostgres.repositories.MaintenanceRepository;
import sn.douanes.gestionstockpostgres.services.MaintenanceService;


@Service
public class MaintenanceServiceImpl implements MaintenanceService {

    @Autowired
    MaintenanceRepository maintenanceRepository;

    @Override
    public Maintenance saveMaintenance(Maintenance m) {
        return maintenanceRepository.save(m);
    }

    @Override
    public Maintenance updateMaintenance(Maintenance m) {
        return maintenanceRepository.save(m);
    }

    @Override
    public void deleteMaintenance(Maintenance m) {
        maintenanceRepository.delete(m);
    }

    @Override
    public void deleteMaintenanceById(String id) {
        maintenanceRepository.deleteById(id);
    }

    @Override
    public Maintenance getMaintenance(String id) {
        return maintenanceRepository.findById(id).get();
    }

    @Override
    public List<Maintenance> getAllMaintenances() {
        return maintenanceRepository.findAll();
    }



}
