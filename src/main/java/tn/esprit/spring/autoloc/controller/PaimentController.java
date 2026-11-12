package tn.esprit.spring.autoloc.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.autoloc.entity.Paiement;
import tn.esprit.spring.autoloc.service.IPaiementService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/Paiement")
@Tag(name = "Gestion Paiement")
public class PaimentController {
    IPaiementService paiementService;
    @PostMapping("/create")
    public Paiement creer(@RequestBody Paiement paiement) {
        return paiementService.creer(paiement);
    }
    @GetMapping("/Get-By-id")
    public Paiement obtenirParId(Long id) {
        return paiementService.obtenirParId(id);
    }
    @GetMapping("/getAll")
    public List<Paiement> listerTous() {
        return paiementService.listerTous();
    }
    @PutMapping("/Update")
    public Paiement mettreAJour(Paiement paiement) {
        return paiementService.mettreAJour(paiement);
    }
    @DeleteMapping("/Delete")
    public void supprimer(Long id) {
        paiementService.supprimer(id);
    }
}
