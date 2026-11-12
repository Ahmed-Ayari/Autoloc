package tn.esprit.spring.autoloc.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.autoloc.entity.Equipement;

@Repository
public interface EquipementRepository extends JpaRepository<Equipement, Long> {
}
