package tn.esprit.spring.autoloc.service;

import tn.esprit.spring.autoloc.entity.Paiement;
import java.util.List;

public interface IPaiementService {
    Paiement creer(Paiement paiement);
    Paiement obtenirParId(Long id);
    List<Paiement> listerTous();
    Paiement mettreAJour(Paiement paiement);
    void supprimer(Long id);
}
