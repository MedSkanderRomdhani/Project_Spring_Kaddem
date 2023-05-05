package tn.esprit.springproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.springproject.entities.Contrat;
import tn.esprit.springproject.entities.DetailEquipe;

import java.util.List;

public interface DetailEquipeRepository extends JpaRepository<DetailEquipe, Integer> {
    @Query("select d from DetailEquipe d order by d.idDetailEquipe ASC ")
    List<DetailEquipe> getAllOrderByIdDetailEquipe();
}
