package tn.esprit.springproject.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.springproject.entities.Departement;
import tn.esprit.springproject.entities.Enseignant;
import tn.esprit.springproject.entities.Etudiant;
import tn.esprit.springproject.entities.Fonction;
import tn.esprit.springproject.repositories.DepartementRepository;
import tn.esprit.springproject.repositories.EnseignantRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EnseignantServiceImpl implements EnseignantService {
    DepartementRepository departementRepository;
    EnseignantRepository enseignantRepository;

    @Override
    public List<Enseignant> retrieveAllEnseignants() {
        return enseignantRepository.findAll();
    }

    @Override
    public Enseignant addEnseignant(Enseignant e) {
        return enseignantRepository.save(e);
    }

    @Override
    public void deleteEnseignant(int id) {
        enseignantRepository.deleteById(id);

    }

    @Override
    public Enseignant updateEnseignant(Enseignant e) {
        return enseignantRepository.save(e);
    }

    @Override
    public Enseignant retrieveEnseignant(int id) {
        return enseignantRepository.findById(id).orElse(null);
    }

    public void assignEnseignantToDepartement(int enseignantId, int departementId) {
        Enseignant enseignant = retrieveEnseignant(enseignantId);
        Departement departement = departementRepository.findById(departementId).orElse(null);
        enseignant.setDepartement(departement);
        enseignantRepository.save(enseignant);
    }

    @Override
    public Enseignant getEnseignantByFonctionAndDepartement_IdDepart(Fonction fonction, int idDepart) {
        return enseignantRepository.getEnseignantByFonctionAndDepartement_IdDepart(fonction, idDepart);
    }

    @Override
    public List<Enseignant> getEnseignantsByFonctionAndDepartement_IdDepart(Fonction fonction, int idDepart) {
        return enseignantRepository.getEnseignantsByFonctionAndDepartement_IdDepart(fonction, idDepart);
    }

    @Override
    public List<Enseignant> getEnseignantWithMaxSalaireByDeptAndFonction(Fonction fonction, int idDepart) throws IndexOutOfBoundsException {
        List<Enseignant> lst = enseignantRepository.getEnseignantsByFonctionAndDepartement_IdDepart(fonction, idDepart);
        List<Enseignant> list = new ArrayList<>();
        Enseignant max_sal = lst.get(0);
        if (lst.size() == 0)
            return list;

        else {
            for (int i = 0; i < lst.size(); i++) {
                if (max_sal.getSalaire() < lst.get(i).getSalaire()) {

                    max_sal = lst.get(i);
                }

            }

            for (int i = 0; i < lst.size(); i++) {
                if (max_sal.getSalaire() == lst.get(i).getSalaire())

                    list.add(lst.get(i));
            }
            return list;
        }
    }


    @Override
    public Integer nombreEnseignantsByDepartement(int idDepart) {
        return enseignantRepository.nombreEnseignantsByDepartement(idDepart);
    }

    @Override
    public List<Enseignant> findEnseignantsByDateRecrutementBetweenAndDepartement_IdDepart(Date startDate, Date endDate, int idDepart) {
        return enseignantRepository.findEnseignantsByDateRecrutementBetweenAndDepartement_IdDepart(startDate, endDate, idDepart);
    }

    @Override
    public Enseignant chercherEnseignantBynom(String nomEns) {

        return enseignantRepository.findEnseignantBynomEns(nomEns);
    }

    @Override
    public List<Enseignant> getEnseignantByModules_idModule(int idModule) {
        return enseignantRepository.findEnseignantByModules_idModule(idModule);
    }

    @Override
    public List<Enseignant> getEnseignantByFonctionAndModules_idModule(Fonction fonction, int idModule) {
        return enseignantRepository.findEnseignantByFonctionAndModules_idModule(fonction, idModule);
    }

    @Override
    public List<Enseignant> chercherEnseignantBySalaire(double salaire) {
        List<Enseignant> enseignants;
        enseignants = enseignantRepository.findAll().stream().filter(e -> e.getSalaire() < salaire)
                .collect(Collectors.toList());
        return enseignants;
    }
}
