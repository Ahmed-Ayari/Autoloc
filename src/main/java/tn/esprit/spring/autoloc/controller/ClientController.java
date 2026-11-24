package tn.esprit.spring.autoloc.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.autoloc.entity.CategorieVehicule;
import tn.esprit.spring.autoloc.entity.Client;
import tn.esprit.spring.autoloc.entity.Contrat;
import tn.esprit.spring.autoloc.service.IClientService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/Client")
@Tag(name = "Gestion Client")
public class ClientController {
    private IClientService clientService;

    @PostMapping("/Create")
    public Client creer(@RequestBody Client client) {
        return clientService.creer(client);
    }

    @GetMapping("Get-By-id")
    public Client obtenirParId(Long id) {
        return clientService.obtenirParId(id);
    }

    @GetMapping("/GetAll")
    public List<Client> listerTous() {
        return clientService.listerTous();
    }

    @PutMapping("/Update")
    public Client mettreAJour(Client client) {
        return clientService.mettreAJour(client);
    }

    @DeleteMapping("/Delete")
    public void supprimer(Long id) {
        clientService.supprimer(id);
    }

    @GetMapping("/getByNomPrenomCv/{nom}/{prenom}/{cv}")
    public List<Client> recupererParNomEtCategorieVehicule(@PathVariable String nom, @PathVariable String prenom, @PathVariable CategorieVehicule cv){
        return clientService.recupererParNomPrenomEtCategorieVehicule(nom, prenom, cv);
    }

    @PostMapping("/ajouterClientEtReservation")
    public Client ajouterClientEtReservation(@RequestBody Client client) {
        return clientService.ajouterClientEtReservation(client);
    }
}
