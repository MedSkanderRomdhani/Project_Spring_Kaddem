package tn.esprit.springproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.springproject.entities.Encadrant;

public interface EncadrantRepository extends JpaRepository<Encadrant, Integer> {
}
