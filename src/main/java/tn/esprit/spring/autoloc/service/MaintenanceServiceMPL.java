package tn.esprit.spring.autoloc.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.autoloc.entity.Maintenance;
import tn.esprit.spring.autoloc.entity.Vehicule;
import tn.esprit.spring.autoloc.repository.MaintenanceRepository;
import tn.esprit.spring.autoloc.repository.VehiculeRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class MaintenanceServiceMPL implements IMaintenanceService {
    MaintenanceRepository maintenanceRepository;
    VehiculeRepository vehiculeRepository;

    @Override
    public Maintenance affecterVehiculeMaintenance(long idM, long idV){
        Maintenance maintenance = maintenanceRepository.findById(idM).orElse(null);
        Vehicule vehicule = vehiculeRepository.findById(idV).orElse(null);

        assert maintenance !=  null;

        maintenance.setVehicule(vehicule);

        return maintenanceRepository.save(maintenance);
    }

    @Override
    public Maintenance creer(Maintenance maintenance) {
        return maintenanceRepository.save(maintenance);
    }

    @Override
    public Maintenance obtenirParId(Long id) {
        return maintenanceRepository.findById(id).orElse(null);
    }

    @Override
    public List<Maintenance> listerTous() {
        return (List<Maintenance>) maintenanceRepository.findAll();
    }

    @Override
    public Maintenance mettreAJour(Maintenance maintenance) {
        return maintenanceRepository.save(maintenance);
    }

    @Override
    public void supprimer(Long id) {
        maintenanceRepository.deleteById(id);
    }
}
