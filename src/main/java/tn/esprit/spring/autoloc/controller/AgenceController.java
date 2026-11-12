package tn.esprit.spring.autoloc.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.autoloc.entity.Agence;
import tn.esprit.spring.autoloc.service.IAgenceService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/Agence")
@Tag(name = "Gestion Agence")
public class AgenceController {
    IAgenceService agenceService;
    @PostMapping("/create")
    public Agence creer(@RequestBody Agence agence) {
        return agenceService.creer(agence);
    }
    @GetMapping("/get-by-id")
    public Agence obtenirParId(Long id) {
        return agenceService.obtenirParId(id);
    }
    @GetMapping("/getAll")
    public List<Agence> listerTous() {
        return agenceService.listerTous();
    }
    @PutMapping("/update")
    public Agence mettreAJour(Agence agence) {
        return agenceService.mettreAJour(agence);
    }
    @DeleteMapping("/delete")
    public void supprimer(Long id) {
        agenceService.supprimer(id);
    }
}
