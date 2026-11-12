package tn.esprit.spring.autoloc.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.autoloc.entity.Employe;

import java.sql.Connection;
import java.sql.DriverManager;

@Repository
public interface EmployeRepository extends JpaRepository<Employe, Long> {
}