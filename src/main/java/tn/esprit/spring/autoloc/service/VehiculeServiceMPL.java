package tn.esprit.spring.autoloc.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.autoloc.entity.Equipement;
import tn.esprit.spring.autoloc.entity.StatutVehicule;
import tn.esprit.spring.autoloc.entity.Vehicule;
import tn.esprit.spring.autoloc.repository.EquipementRepository;
import tn.esprit.spring.autoloc.repository.VehiculeRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class VehiculeServiceMPL implements IVehiculeService {
    VehiculeRepository vehiculeRepository;
    EquipementRepository equipementRepository;

    @Override
    public Vehicule affecterVehiculeEquipement(long idV, long idEq) {
        Vehicule vehicule = vehiculeRepository.findById(idV)
                .orElseThrow(() -> new IllegalArgumentException("Vehicule introuvable : " + idV));
        Equipement equipement = equipementRepository.findById(idEq)
                .orElseThrow(() -> new IllegalArgumentException("Equipement introuvable : " + idEq));

        if (vehicule.getEquipements() == null) {
            vehicule.setEquipements(new ArrayList<>());
        }
        if (!vehicule.getEquipements().contains(equipement)) {
            vehicule.getEquipements().add(equipement);
        }
        return vehiculeRepository.save(vehicule);
    }

    @Override
    public Vehicule creer(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }

    @Override
    public Vehicule obtenirParId(Long id) {
        return vehiculeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Vehicule> listerTous() {
        return vehiculeRepository.findAll();
    }

    @Override
    public Vehicule mettreAJour(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }

    @Override
    public void supprimer(Long id) {
        vehiculeRepository.deleteById(id);
    }

    @Override
    public List<Vehicule> rechercherParMarque(String marque) {
        return vehiculeRepository.findByMarque(marque);
    }

    @Override
    public List<Vehicule> rechercherParMarqueContenant(String mot) {
        return vehiculeRepository.findByMarqueContaining(mot);
    }

    @Override
    public List<Vehicule> rechercherParMarqueCommencantPar(String prefixe) {
        return vehiculeRepository.findByMarqueStartingWith(prefixe);
    }

    @Override
    public List<Vehicule> rechercherParMarqueTerminantPar(String suffixe) {
        return vehiculeRepository.findByMarqueEndingWith(suffixe);
    }

    @Override
    public List<Vehicule> rechercherParMarqueIgnoreCase(String marque) {
        return vehiculeRepository.findByMarqueIgnoreCase(marque);
    }

    @Override
    public List<Vehicule> rechercherParModele(String modele) {
        return vehiculeRepository.findByModele(modele);
    }

    @Override
    public boolean existeParImmatriculation(String immatriculation) {
        return vehiculeRepository.existsByImmatriculation(immatriculation);
    }

    @Override
    public long compterParMarque(String marque) {
        return vehiculeRepository.countByMarque(marque);
    }

    @Override
    public List<Vehicule> tarifSuperieurA(BigDecimal tarif) {
        return vehiculeRepository.findByTarifJournalierGreaterThan(tarif);
    }

    @Override
    public List<Vehicule> tarifInferieurA(BigDecimal tarif) {
        return vehiculeRepository.findByTarifJournalierLessThan(tarif);
    }

    @Override
    public List<Vehicule> tarifSuperieurOuEgalA(BigDecimal tarif) {
        return vehiculeRepository.findByTarifJournalierGreaterThanEqual(tarif);
    }

    @Override
    public List<Vehicule> tarifEntre(BigDecimal min, BigDecimal max) {
        return vehiculeRepository.findByTarifJournalierBetween(min, max);
    }

    @Override
    public List<Vehicule> trierParTarifAsc() {
        return vehiculeRepository.findAllByOrderByTarifJournalierAsc();
    }

    @Override
    public List<Vehicule> trierParTarifDesc() {
        return vehiculeRepository.findAllByOrderByTarifJournalierDesc();
    }

    @Override
    public List<Vehicule> marqueTriesParTarifAsc(String marque) {
        return vehiculeRepository.findByMarqueOrderByTarifJournalierAsc(marque);
    }

    @Override
    public List<Vehicule> marqueTarifSuperieurA(String marque, BigDecimal tarif) {
        return vehiculeRepository.findByMarqueAndTarifJournalierGreaterThan(marque, tarif);
    }

    @Override
    public List<Vehicule> marqueOuModele(String marque, String modele) {
        return vehiculeRepository.findByMarqueOrModele(marque, modele);
    }

    @Override
    public List<Vehicule> marqueDansListe(List<String> marques) {
        return vehiculeRepository.findByMarqueIn(marques);
    }

    @Override
    public List<Vehicule> marqueHorsListe(List<String> marques) {
        return vehiculeRepository.findByMarqueNotIn(marques);
    }

    @Override
    public List<Vehicule> parStatut(StatutVehicule statut) {
        return vehiculeRepository.findByStatut(statut);
    }

    @Override
    public List<Vehicule> disponiblesTriesParTarifAsc() {
        return vehiculeRepository.findByStatutOrderByTarifJournalierAsc(StatutVehicule.DISPONIBLE);
    }

    @Override
    public List<Vehicule> parAgence(Long idAgence) {
        return vehiculeRepository.findByAgence_IdAgence(idAgence);
    }

    @Override
    public List<Vehicule> parVilleAgence(String ville) {
        return vehiculeRepository.findByAgence_Ville(ville);
    }

    @Override
    public List<Vehicule> parNomAgenceContenant(String nom) {
        return vehiculeRepository.findByAgence_NomContaining(nom);
    }

    @Override
    public List<Vehicule> parAgenceEtMarque(Long idAgence, String marque) {
        return vehiculeRepository.findByAgence_IdAgenceAndMarque(idAgence, marque);
    }

    @Override
    public List<Vehicule> sansAgence() {
        return vehiculeRepository.findByAgenceIsNull();
    }

    @Override
    public List<Vehicule> avecAgence() {
        return vehiculeRepository.findByAgenceIsNotNull();
    }

    @Override
    public long compterParAgence(Long idAgence) {
        return vehiculeRepository.countByAgence_IdAgence(idAgence);
    }

    @Override
    public boolean agenceADesVehicules(Long idAgence) {
        return vehiculeRepository.existsByAgence_IdAgence(idAgence);
    }
}