package tn.esprit.spring.autoloc.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.autoloc.entity.Agence;
import tn.esprit.spring.autoloc.entity.Employe;
import tn.esprit.spring.autoloc.repository.AgenceRepository;
import tn.esprit.spring.autoloc.repository.EmployeRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeServiceMPL implements IEmployeService {
    EmployeRepository employeRepository;
    AgenceRepository agenceRepository;

    @Override
    public Employe affecterEmployeAgence(Long idAg, Long idEmp) {
        //Récupération des données
        Employe employe = employeRepository.findById(idEmp).orElse(null);
        Agence agence = agenceRepository.findById(idAg).orElse(null);
        //Affectation
        assert employe != null;
        employe.setAgence(agence);
        //Sauvegarder les modifications
        return employeRepository.save(employe);
    }

    @Override
    public Employe creer(Employe employe) {
        return employeRepository.save(employe);
    }

    @Override
    public Employe obtenirParId(Long id) {
        return employeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Employe> listerTous() {
        return (List<Employe>) employeRepository.findAll();
    }

    @Override
    public Employe mettreAJour(Employe employe) {
        return employeRepository.save(employe);
    }

    @Override
    public void supprimer(Long id) {
        employeRepository.deleteById(id);
    }
}