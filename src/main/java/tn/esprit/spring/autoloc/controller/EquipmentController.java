package tn.esprit.spring.autoloc.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.autoloc.entity.Equipement;
import tn.esprit.spring.autoloc.service.IEquipementService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/Equipment")
@Tag(name = "Gestion Equipement")
public class EquipmentController {
    IEquipementService equipementService;
    @PostMapping("/create")
    public Equipement creer(@RequestBody Equipement equipement) {
        return equipementService.creer(equipement);
    }

    @GetMapping("/Get-By-Id")
    public Equipement obtenirParId(Long id) {
        return equipementService.obtenirParId(id);
    }
    @GetMapping("/getAll")
    public List<Equipement> listerTous() {
        return equipementService.listerTous();
    }

    @PutMapping("/Update")
    public Equipement mettreAJour(Equipement equipement) {
        return equipementService.mettreAJour(equipement);
    }

    @DeleteMapping("/Delete")
    public void supprimer(Long id) {
        equipementService.supprimer(id);
    }
}
