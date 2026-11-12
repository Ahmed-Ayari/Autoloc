package tn.esprit.spring.autoloc.service;

import tn.esprit.spring.autoloc.entity.StatutVehicule;
import tn.esprit.spring.autoloc.entity.Vehicule;

import java.math.BigDecimal;
import java.util.List;

public interface IVehiculeService {
    Vehicule affecterVehiculeEquipement(long idV, long idEq);

    Vehicule creer(Vehicule vehicule);
    Vehicule obtenirParId(Long id);
    List<Vehicule> listerTous();
    Vehicule mettreAJour(Vehicule vehicule);
    void supprimer(Long id);

    List<Vehicule> rechercherParMarque(String marque);
    List<Vehicule> rechercherParMarqueContenant(String mot);
    List<Vehicule> rechercherParMarqueCommencantPar(String prefixe);
    List<Vehicule> rechercherParMarqueTerminantPar(String suffixe);
    List<Vehicule> rechercherParMarqueIgnoreCase(String marque);
    List<Vehicule> rechercherParModele(String modele);
    boolean existeParImmatriculation(String immatriculation);
    long compterParMarque(String marque);

    List<Vehicule> tarifSuperieurA(BigDecimal tarif);
    List<Vehicule> tarifInferieurA(BigDecimal tarif);
    List<Vehicule> tarifSuperieurOuEgalA(BigDecimal tarif);
    List<Vehicule> tarifEntre(BigDecimal min, BigDecimal max);
    List<Vehicule> trierParTarifAsc();
    List<Vehicule> trierParTarifDesc();
    List<Vehicule> marqueTriesParTarifAsc(String marque);
    List<Vehicule> marqueTarifSuperieurA(String marque, BigDecimal tarif);

    List<Vehicule> marqueOuModele(String marque, String modele);
    List<Vehicule> marqueDansListe(List<String> marques);
    List<Vehicule> marqueHorsListe(List<String> marques);

    List<Vehicule> parStatut(StatutVehicule statut);
    List<Vehicule> disponiblesTriesParTarifAsc();

    List<Vehicule> parAgence(Long idAgence);
    List<Vehicule> parVilleAgence(String ville);
    List<Vehicule> parNomAgenceContenant(String nom);
    List<Vehicule> parAgenceEtMarque(Long idAgence, String marque);
    List<Vehicule> sansAgence();
    List<Vehicule> avecAgence();
    long compterParAgence(Long idAgence);
    boolean agenceADesVehicules(Long idAgence);
}