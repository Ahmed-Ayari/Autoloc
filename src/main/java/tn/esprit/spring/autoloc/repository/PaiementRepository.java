package tn.esprit.spring.autoloc.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.autoloc.entity.Paiement;

@Repository
public interface PaiementRepository extends JpaRepository<Paiement, Long> {
}