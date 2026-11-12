package tn.esprit.spring.autoloc.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.autoloc.entity.Contrat;
import tn.esprit.spring.autoloc.repository.ContratRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ContratServiceMPL implements IContratService {
    ContratRepository contratRepository;

    @Override
    public Contrat creer(Contrat contrat) {
        return contratRepository.save(contrat);
    }

    @Override
    public Contrat obtenirParId(Long id) {
        return contratRepository.findById(id).orElse(null);
    }

    @Override
    public List<Contrat> listerTous() {
        return (List<Contrat>) contratRepository.findAll();
    }

    @Override
    public Contrat mettreAJour(Contrat contrat) {
        return contratRepository.save(contrat);
    }

    @Override
    public void supprimer(Long id) {
        contratRepository.deleteById(id);
    }
}
