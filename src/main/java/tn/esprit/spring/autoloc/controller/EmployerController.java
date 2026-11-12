package tn.esprit.spring.autoloc.controller;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.autoloc.entity.Employe;
import tn.esprit.spring.autoloc.service.IEmployeService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/Employer")
@Tag(name = "Gestion Employés")
public class EmployerController {
    IEmployeService employerService;

    @PostMapping("/create")
    public Employe creer(@RequestBody Employe employe) {
        return employerService.creer(employe);
    }

    @GetMapping("get-by-id")
    public Employe obtenirParId(Long id) {
        return employerService.obtenirParId(id);
    }

    @GetMapping("/getAll")
    public List<Employe> listerTous() {
        return employerService.listerTous();
    }

    @PutMapping("/update")
    public Employe mettreAJour(@RequestBody Employe employe) {
        return employerService.mettreAJour(employe);
    }

    @DeleteMapping("/delete/{id}")
    public void supprimer(@PathVariable Long id) {
        employerService.supprimer(id);
    }

    @PutMapping("/affecter/{idAg}/{idEmp}")
    public Employe affecterEmployeAgence(@PathVariable Long idAg, @PathVariable Long idEmp) {
        return employerService.affecterEmployeAgence(idAg, idEmp);
    }
}
