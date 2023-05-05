package tn.esprit.springproject.services;


import tn.esprit.springproject.entities.Departement;
import tn.esprit.springproject.entities.MaxRecruDepart;

import java.util.Date;
import java.util.List;
import java.util.Set;

public interface DepartementService {
    List<Departement> retrieveAllDepartements();

    Departement addDepartement(Departement d);

    void deleteDepartement(int id);

    Departement updateDepartement(Departement d);

    Departement retrieveDepartement(int id);


    //**************** YOSRA**************************
    Set<Departement> retrieveDepartementsByUniversite(int idUniversite);

    Departement searchDepartementByNomDepart(String nomDepart);

    List<Departement> getAllOrderByNomDepartAsc();

    double salaireMoyenParDepartement(int idDepart);

    List<Departement> getDepartementsByNomDepartContains(String nom);

    List<MaxRecruDepart> nbRecrutementBydepartBetweenDeuxDates(Date startDate, Date endDate);
    //**************************************************************
}
