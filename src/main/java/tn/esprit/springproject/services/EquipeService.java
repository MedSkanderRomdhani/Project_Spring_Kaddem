package tn.esprit.springproject.services;

import tn.esprit.springproject.entities.Contrat;
import tn.esprit.springproject.entities.DetailEquipe;
import tn.esprit.springproject.entities.Equipe;
import tn.esprit.springproject.entities.Niveau;

import java.util.List;

public interface EquipeService {
    List<Equipe> retrieveAllEquipes();

    Equipe addEquipe(Equipe eq);

    void deleteEquipe(int id);

    Equipe updateEquipe(Equipe eq);

    Equipe retrieveEquipe(int id);

    public int countEtudiantByEquipe(int id);

    public Boolean compareEquipes(Integer id1, Integer id2);

    public void assignDetailsEquipeToEquipe(Integer idEquipe, DetailEquipe detailsEquipe);


    public List<Equipe> retrieveEquipesDeLetudiant(Integer id);

    Equipe affectEquipeToEncadrant(int idEquipe, int idEncadrant);

    List<Equipe> getEquipesParEncadrant(int idEncadrant);
    List<Equipe>  trierListeEquipes();
    Integer countEquipesParNiveau(Niveau niveau);

}
