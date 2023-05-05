package tn.esprit.springproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.springproject.entities.Contrat;
import tn.esprit.springproject.entities.Equipe;
import tn.esprit.springproject.entities.Niveau;

import java.util.List;

public interface EquipeRepository extends JpaRepository<Equipe, Integer> {

    Equipe findEquipeByIdEquipe(Integer id);
    //@Query("select eq from Equipe eq group by eq.niveau")
    List<Equipe> findEquipesByNiveau(Niveau niveau);


    @Query("select et.equipes from Etudiant et ")
    List<Equipe> findEquipesByIdEtudiant();

    //------------Fida ------------------
    List<Equipe> findByEncadrant_IdEncadrant(int idEncadrant);
}
