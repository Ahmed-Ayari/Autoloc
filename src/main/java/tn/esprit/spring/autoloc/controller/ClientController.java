package tn.esprit.spring.autoloc.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.autoloc.entity.CategorieVehicule;
import tn.esprit.spring.autoloc.entity.Client;
import tn.esprit.spring.autoloc.entity.Contrat;
import tn.esprit.spring.autoloc.service.IClientService;
import tn.esprit.spring.autoloc.service.IContratService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/Client")
@Tag(name = "Gestion Client")
public class ClientController {
    private IContratService contratService;
    private IClientService clientService;

    @PostMapping("/Create")
    public Contrat creer(@RequestBody Contrat contrat) {
        return contratService.creer(contrat);
    }

    @GetMapping("Get-By-id")
    public Contrat obtenirParId(Long id) {
        return contratService.obtenirParId(id);
    }

    @GetMapping("/GetAll")
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

    @GetMapping("/getByNomPrenomCv/{nom}/{prenom}/{cv}")
    public List<Client> recupererParNomEtCategorieVehicule(@PathVariable String nom, @PathVariable String prenom, @PathVariable CategorieVehicule cv){
        return clientService.recupererParNomPrenomEtCategorieVehicule(nom, prenom, cv);
    }
}
