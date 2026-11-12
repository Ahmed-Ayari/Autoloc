package tn.esprit.spring.autoloc.service;

import tn.esprit.spring.autoloc.entity.CategorieVehicule;
import tn.esprit.spring.autoloc.entity.Client;
import java.util.List;

public interface IClientService {
    Client creer(Client client);
    Client obtenirParId(Long id);
    List<Client> listerTous();
    Client mettreAJour(Client client);
    void supprimer(Long id);

    List<Client> recupererParNomPrenomEtCategorieVehicule (String nom, String prenom, CategorieVehicule cv);
}
