package tn.esprit.spring.autoloc.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.autoloc.entity.Agence;

@Repository
public interface AgenceRepository extends JpaRepository<Agence, Long> {
}
