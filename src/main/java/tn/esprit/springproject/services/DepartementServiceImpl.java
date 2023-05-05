package tn.esprit.springproject.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.springproject.entities.Departement;

import tn.esprit.springproject.entities.MaxRecruDepart;
import tn.esprit.springproject.entities.Universite;
import tn.esprit.springproject.repositories.DepartementRepository;
import tn.esprit.springproject.repositories.UniversiteRepository;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class DepartementServiceImpl implements DepartementService {
    DepartementRepository departementRepository;
    UniversiteRepository universiteRepository;

    @Override
    public List<Departement> retrieveAllDepartements() {
        return departementRepository.findAll();
    }

    @Override
    public Departement addDepartement(Departement d) {
        return departementRepository.save(d);
    }

    @Override
    public void deleteDepartement(int id) {
        departementRepository.deleteById(id);

    }

    @Override
    public Departement updateDepartement(Departement d) {
        return departementRepository.save(d);
    }

    @Override
    public Departement retrieveDepartement(int id) {
        return departementRepository.findById(id).orElse(null);
    }


    @Override
    public Set<Departement> retrieveDepartementsByUniversite(int idUniversite) {
        Universite universite = universiteRepository.findById(idUniversite).orElse(null);
        return universite.getDepartements();
    }

    @Override
    public Departement searchDepartementByNomDepart(String nomDepart) {
        return departementRepository.searchDepartementByNomDepart(nomDepart);
    }

    @Override
    public List<Departement> getAllOrderByNomDepartAsc() {
        return departementRepository.getAllOrderByNomDepartAsc();
    }

    @Override
    public double salaireMoyenParDepartement(int idDepart) {
        return departementRepository.salaireMoyenParDepartement(idDepart);
    }

    @Override
    public List<Departement> getDepartementsByNomDepartContains(String nom) {
        return departementRepository.getDepartementsByNomDepartContains(nom);
    }

    @Override
    public List<MaxRecruDepart> nbRecrutementBydepartBetweenDeuxDates(Date startDate, Date endDate) {
        return departementRepository.nbRecrutementBydepartBetweenDeuxDates(startDate, endDate);
    }

}



