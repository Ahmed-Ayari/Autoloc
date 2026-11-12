package tn.esprit.spring.autoloc.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.autoloc.entity.Agence;
import tn.esprit.spring.autoloc.repository.AgenceRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class AgenceServiceMPL implements IAgenceService {
    AgenceRepository agenceRepository;

    @Override
    public Agence creer(Agence agence) {
        return agenceRepository.save(agence);
    }

    @Override
    public Agence obtenirParId(Long id) {
        return agenceRepository.findById(id).orElse(null);
    }

    @Override
    public List<Agence> listerTous() {
        return (List<Agence>) agenceRepository.findAll();
    }

    @Override
    public Agence mettreAJour(Agence agence) {
        return agenceRepository.save(agence);
    }

    @Override
    public void supprimer(Long id) {
        agenceRepository.deleteById(id);
    }
}
