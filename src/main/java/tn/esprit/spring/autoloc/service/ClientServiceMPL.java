package tn.esprit.spring.autoloc.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.autoloc.entity.CategorieVehicule;
import tn.esprit.spring.autoloc.entity.Client;
import tn.esprit.spring.autoloc.repository.ClientRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ClientServiceMPL implements IClientService {
    ClientRepository clientRepository;

    @Override
    public Client creer(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client obtenirParId(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    @Override
    public List<Client> listerTous() {
        return (List<Client>) clientRepository.findAll();
    }

    @Override
    public Client mettreAJour(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public void supprimer(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public List<Client> recupererParNomPrenomEtCategorieVehicule(String nom, String prenom, CategorieVehicule cv){
        return clientRepository.findDistinctByNomAndPrenomAndReservations_Vehicule_Categorie(nom, prenom, cv);
    }
}
