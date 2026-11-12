package tn.esprit.spring.autoloc.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.autoloc.entity.CategorieVehicule;
import tn.esprit.spring.autoloc.entity.Client;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    List<Client> findDistinctByNomAndPrenomAndReservations_Vehicule_Categorie(
            String nom, String prenom, CategorieVehicule cv);
}
