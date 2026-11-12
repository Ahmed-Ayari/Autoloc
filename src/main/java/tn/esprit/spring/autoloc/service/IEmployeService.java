package tn.esprit.spring.autoloc.service;

import tn.esprit.spring.autoloc.entity.Employe;
import java.util.List;

public interface IEmployeService {
    Employe affecterEmployeAgence(Long idAg, Long idEmp);

    Employe creer(Employe employe);
    Employe obtenirParId(Long id);
    List<Employe> listerTous();
    Employe mettreAJour(Employe employe);
    void supprimer(Long id);

}