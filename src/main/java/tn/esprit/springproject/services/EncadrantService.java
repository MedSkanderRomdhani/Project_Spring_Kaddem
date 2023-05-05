package tn.esprit.springproject.services;

import tn.esprit.springproject.entities.Encadrant;

import java.util.List;

public interface EncadrantService {
    List<Encadrant> retrieveAllEncadrants();

    Encadrant addEncadrant(Encadrant e);

    void deleteEncadrant(int id);

    Encadrant updateEncadrant(Encadrant e);

    Encadrant retrieveEncadrant(int id);
}
