package tn.esprit.springproject.services;

import tn.esprit.springproject.entities.Departement;
import tn.esprit.springproject.entities.DetailEquipe;

import java.util.List;

public interface DetailEquipeService {
    List<DetailEquipe> retrieveAllDetails();

    DetailEquipe addDetailEquipe(DetailEquipe d);

    void deleteDetailEquipe(int id);

    DetailEquipe updateDetailEquipe(DetailEquipe d);

    DetailEquipe retrieveDetailEquipe(int id);

    List<DetailEquipe> afficherListeDetailEquipeTriee();
}
