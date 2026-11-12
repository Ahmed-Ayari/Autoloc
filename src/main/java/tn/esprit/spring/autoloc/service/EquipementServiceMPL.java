package tn.esprit.spring.autoloc.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.autoloc.entity.Equipement;
import tn.esprit.spring.autoloc.repository.EquipementRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class EquipementServiceMPL implements IEquipementService {
    EquipementRepository equipementRepository;

    @Override
    public Equipement creer(Equipement equipement) {
        return equipementRepository.save(equipement);
    }

    @Override
    public Equipement obtenirParId(Long id) {
        return equipementRepository.findById(id).orElse(null);
    }

    @Override
    public List<Equipement> listerTous() {
        return (List<Equipement>) equipementRepository.findAll();
    }

    @Override
    public Equipement mettreAJour(Equipement equipement) {
        return equipementRepository.save(equipement);
    }

    @Override
    public void supprimer(Long id) {
        equipementRepository.deleteById(id);
    }
}
