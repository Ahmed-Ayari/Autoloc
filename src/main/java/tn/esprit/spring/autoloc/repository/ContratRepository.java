package tn.esprit.spring.autoloc.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.autoloc.entity.Contrat;

@Repository
public interface ContratRepository extends JpaRepository<Contrat, Long> {
}