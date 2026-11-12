package tn.esprit.spring.autoloc.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.autoloc.entity.Maintenance;
import tn.esprit.spring.autoloc.service.IMaintenanceService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/Maintenance")
@Tag(name = "Gestion Maintenance")
public class MaintenanceController {
    IMaintenanceService maintenanceService;
    @PostMapping("/create")
    public Maintenance creer(@RequestBody Maintenance maintenance) {
        return maintenanceService.creer(maintenance);
    }
    @GetMapping("/Get-By-Id")
    public Maintenance obtenirParId(Long id) {
        return maintenanceService.obtenirParId(id);
    }
    @GetMapping("/getAll")
    public List<Maintenance> listerTous() {
        return maintenanceService.listerTous();
    }
    @PutMapping("/Update")
    public Maintenance mettreAJour(Maintenance maintenance) {
        return maintenanceService.mettreAJour(maintenance);
    }
    @DeleteMapping("/Delete")
    public void supprimer(Long id) {
        maintenanceService.supprimer(id);
    }

    @PutMapping("/affecter/{idM}{idV}")
    public Maintenance AffecterVehiculeMaintenance(@PathVariable long idM, @PathVariable long idV){
        return maintenanceService.affecterVehiculeMaintenance(idM, idV);
    }
}
