package tn.esprit.spring.autoloc.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.autoloc.entity.Contrat;
import tn.esprit.spring.autoloc.entity.Employe;
import tn.esprit.spring.autoloc.service.IContratService;

import java.util.List;
@RestController
@AllArgsConstructor
@RequestMapping("/Contrat")
@Tag(name = "Gestion Contrat")
public class ContratController {
    IContratService contratService;
    @PostMapping("/create")
    public Contrat creer(@RequestBody Contrat contrat) {
        return contratService.creer(contrat);
    }

    @GetMapping("/Get-By-Id")
    public Contrat obtenirParId(Long id) {
        return contratService.obtenirParId(id);
    }

    @GetMapping("/getAll")
    public List<Contrat> listerTous() {
        return contratService.listerTous();
    }

    @PutMapping("/Update")
    public Contrat mettreAJour(Contrat contrat) {
        return contratService.mettreAJour(contrat);
    }

    @DeleteMapping("/Delete")
    public void supprimer(Long id) {
        contratService.supprimer(id);
    }
}
