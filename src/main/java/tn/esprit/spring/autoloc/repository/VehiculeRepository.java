package tn.esprit.spring.autoloc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.autoloc.entity.StatutVehicule;
import tn.esprit.spring.autoloc.entity.Vehicule;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface VehiculeRepository extends JpaRepository<Vehicule, Long> {

    // Marque
    List<Vehicule> findByMarque(String marque);                          // 1
    List<Vehicule> findByMarqueContaining(String mot);                   // 2
    List<Vehicule> findByMarqueStartingWith(String prefixe);             // 3
    List<Vehicule> findByMarqueEndingWith(String suffixe);               // 4
    List<Vehicule> findByMarqueIgnoreCase(String marque);                // 5

    // Modele, immatriculation
    List<Vehicule> findByModele(String modele);                          // 6
    boolean existsByImmatriculation(String immatriculation);             // 7
    long countByMarque(String marque);                                   // 8

    // Tarif
    List<Vehicule> findByTarifJournalierGreaterThan(BigDecimal tarif);               // 9
    List<Vehicule> findByTarifJournalierLessThan(BigDecimal tarif);                  // 10
    List<Vehicule> findByTarifJournalierGreaterThanEqual(BigDecimal tarif);          // 11
    List<Vehicule> findByTarifJournalierBetween(BigDecimal min, BigDecimal max);     // 12
    List<Vehicule> findAllByOrderByTarifJournalierAsc();                             // 13
    List<Vehicule> findAllByOrderByTarifJournalierDesc();                            // 14
    List<Vehicule> findByMarqueOrderByTarifJournalierAsc(String marque);             // 15
    List<Vehicule> findByMarqueAndTarifJournalierGreaterThan(String marque, BigDecimal tarif); // 16

    // Combinaisons
    List<Vehicule> findByMarqueOrModele(String marque, String modele);   // 17
    List<Vehicule> findByMarqueIn(List<String> marques);                 // 18
    List<Vehicule> findByMarqueNotIn(List<String> marques);              // 19

    // Statut
    List<Vehicule> findByStatut(StatutVehicule statut);                  // 20
    List<Vehicule> findByStatutOrderByTarifJournalierAsc(StatutVehicule statut); // 21

    // Agence
    List<Vehicule> findByAgence_IdAgence(Long idAgence);                 // 22
    List<Vehicule> findByAgence_Ville(String ville);                     // 23
    List<Vehicule> findByAgence_NomContaining(String nom);               // 24
    List<Vehicule> findByAgence_IdAgenceAndMarque(Long idAgence, String marque); // 25
    List<Vehicule> findByAgenceIsNull();                                 // 26
    List<Vehicule> findByAgenceIsNotNull();                              // 27
    long countByAgence_IdAgence(Long idAgence);                          // 28
    boolean existsByAgence_IdAgence(Long idAgence);                      // 29
}