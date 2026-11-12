package tn.esprit.spring.autoloc.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.autoloc.entity.StatutVehicule;
import tn.esprit.spring.autoloc.entity.Vehicule;
import tn.esprit.spring.autoloc.service.IVehiculeService;

import java.math.BigDecimal;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/Vehicule")
@Tag(name = "Gestion Vehicule")
public class VehiculeController {
    IVehiculeService vehiculeService;

    @PostMapping("/create")
    public Vehicule creer(@RequestBody Vehicule vehicule) {
        return vehiculeService.creer(vehicule);
    }

    @GetMapping("/Get-By-Id")
    public Vehicule obtenirParId(@RequestParam Long id) {
        return vehiculeService.obtenirParId(id);
    }

    @GetMapping("/getAll")
    public List<Vehicule> listerTous() {
        return vehiculeService.listerTous();
    }

    @PutMapping("/Update")
    public Vehicule mettreAJour(@RequestBody Vehicule vehicule) {
        return vehiculeService.mettreAJour(vehicule);
    }

    @DeleteMapping("/Delete")
    public void supprimer(@RequestParam Long id) {
        vehiculeService.supprimer(id);
    }

    @PutMapping("/affecter/{idV}/{idEq}")
    public Vehicule affecterVehiculeEquipement(@PathVariable long idV, @PathVariable long idEq) {
        return vehiculeService.affecterVehiculeEquipement(idV, idEq);
    }

    // Marque
    @GetMapping("/marque")
    public List<Vehicule> parMarque(@RequestParam String marque) {
        return vehiculeService.rechercherParMarque(marque);
    }

    @GetMapping("/marque/contient")
    public List<Vehicule> marqueContient(@RequestParam String mot) {
        return vehiculeService.rechercherParMarqueContenant(mot);
    }

    @GetMapping("/marque/commence")
    public List<Vehicule> marqueCommence(@RequestParam String prefixe) {
        return vehiculeService.rechercherParMarqueCommencantPar(prefixe);
    }

    @GetMapping("/marque/termine")
    public List<Vehicule> marqueTermine(@RequestParam String suffixe) {
        return vehiculeService.rechercherParMarqueTerminantPar(suffixe);
    }

    @GetMapping("/marque/ignore-case")
    public List<Vehicule> marqueIgnoreCase(@RequestParam String marque) {
        return vehiculeService.rechercherParMarqueIgnoreCase(marque);
    }

    @GetMapping("/modele")
    public List<Vehicule> parModele(@RequestParam String modele) {
        return vehiculeService.rechercherParModele(modele);
    }

    @GetMapping("/existe")
    public boolean existe(@RequestParam String immatriculation) {
        return vehiculeService.existeParImmatriculation(immatriculation);
    }

    @GetMapping("/marque/count")
    public long compterParMarque(@RequestParam String marque) {
        return vehiculeService.compterParMarque(marque);
    }

    // Tarif
    @GetMapping("/tarif/superieur")
    public List<Vehicule> tarifSuperieur(@RequestParam BigDecimal tarif) {
        return vehiculeService.tarifSuperieurA(tarif);
    }

    @GetMapping("/tarif/inferieur")
    public List<Vehicule> tarifInferieur(@RequestParam BigDecimal tarif) {
        return vehiculeService.tarifInferieurA(tarif);
    }

    @GetMapping("/tarif/superieur-egal")
    public List<Vehicule> tarifSuperieurEgal(@RequestParam BigDecimal tarif) {
        return vehiculeService.tarifSuperieurOuEgalA(tarif);
    }

    @GetMapping("/tarif/entre")
    public List<Vehicule> tarifEntre(@RequestParam BigDecimal min, @RequestParam BigDecimal max) {
        return vehiculeService.tarifEntre(min, max);
    }

    @GetMapping("/tarif/asc")
    public List<Vehicule> triAsc() {
        return vehiculeService.trierParTarifAsc();
    }

    @GetMapping("/tarif/desc")
    public List<Vehicule> triDesc() {
        return vehiculeService.trierParTarifDesc();
    }

    @GetMapping("/marque/tarif/asc")
    public List<Vehicule> marqueTriAsc(@RequestParam String marque) {
        return vehiculeService.marqueTriesParTarifAsc(marque);
    }

    @GetMapping("/marque/tarif/superieur")
    public List<Vehicule> marqueTarifSuperieur(@RequestParam String marque, @RequestParam BigDecimal tarif) {
        return vehiculeService.marqueTarifSuperieurA(marque, tarif);
    }

    // Combinaisons
    @GetMapping("/marque-ou-modele")
    public List<Vehicule> marqueOuModele(@RequestParam String marque, @RequestParam String modele) {
        return vehiculeService.marqueOuModele(marque, modele);
    }

    @GetMapping("/marque/in")
    public List<Vehicule> marqueIn(@RequestParam List<String> marques) {
        return vehiculeService.marqueDansListe(marques);
    }

    @GetMapping("/marque/not-in")
    public List<Vehicule> marqueNotIn(@RequestParam List<String> marques) {
        return vehiculeService.marqueHorsListe(marques);
    }

    // Statut
    @GetMapping("/statut")
    public List<Vehicule> parStatut(@RequestParam StatutVehicule statut) {
        return vehiculeService.parStatut(statut);
    }

    @GetMapping("/disponibles/tarif/asc")
    public List<Vehicule> disponiblesTriAsc() {
        return vehiculeService.disponiblesTriesParTarifAsc();
    }

    // Agence
    @GetMapping("/agence/{idAgence}")
    public List<Vehicule> parAgence(@PathVariable Long idAgence) {
        return vehiculeService.parAgence(idAgence);
    }

    @GetMapping("/agence/ville")
    public List<Vehicule> parVille(@RequestParam String ville) {
        return vehiculeService.parVilleAgence(ville);
    }

    @GetMapping("/agence/nom")
    public List<Vehicule> parNomAgence(@RequestParam String nom) {
        return vehiculeService.parNomAgenceContenant(nom);
    }

    @GetMapping("/agence/{idAgence}/marque")
    public List<Vehicule> parAgenceEtMarque(@PathVariable Long idAgence, @RequestParam String marque) {
        return vehiculeService.parAgenceEtMarque(idAgence, marque);
    }

    @GetMapping("/sans-agence")
    public List<Vehicule> sansAgence() {
        return vehiculeService.sansAgence();
    }

    @GetMapping("/avec-agence")
    public List<Vehicule> avecAgence() {
        return vehiculeService.avecAgence();
    }

    @GetMapping("/agence/{idAgence}/count")
    public long compterParAgence(@PathVariable Long idAgence) {
        return vehiculeService.compterParAgence(idAgence);
    }

    @GetMapping("/agence/{idAgence}/possede")
    public boolean agenceAVehicules(@PathVariable Long idAgence) {
        return vehiculeService.agenceADesVehicules(idAgence);
    }
}