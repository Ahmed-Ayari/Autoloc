package tn.esprit.spring.autoloc.service;

import tn.esprit.spring.autoloc.entity.Maintenance;
import java.util.List;

public interface IMaintenanceService {
    Maintenance creer(Maintenance maintenance);
    Maintenance obtenirParId(Long id);
    List<Maintenance> listerTous();
    Maintenance mettreAJour(Maintenance maintenance);
    void supprimer(Long id);

    Maintenance affecterVehiculeMaintenance(long idM, long idV);
}
