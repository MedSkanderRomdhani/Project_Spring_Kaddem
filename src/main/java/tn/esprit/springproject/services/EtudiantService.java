package tn.esprit.springproject.services;


import tn.esprit.springproject.entities.Equipe;
import tn.esprit.springproject.entities.Etudiant;
import tn.esprit.springproject.entities.Module;
import tn.esprit.springproject.entities.Option;

import java.util.List;
import java.util.Set;


public interface EtudiantService {
    List<Etudiant> retrieveAllEtudiants();

    Etudiant addEtudiant(Etudiant e);

    void deleteEtudiant(int id);

    Etudiant updateEtudiant(Etudiant e);

    Etudiant retrieveEtudiant(int id);

    void assignEtudiantToDepartement(int etudiantId, int departementId);

    Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, int idContrat, int
            idEquipe);

    Etudiant findByNomAndPrenom(String nom, String prenom);

    Integer nombreEtudiantsByOption(Option option);


    //**************** YOSRA**************************
    List<Etudiant> getEtudiantsByDepartement(int idDepart);

    Integer nombreEtudiantsByDepartement(int idDepart);
    //***************************************************

    List<Etudiant> EtudiantsByOption(Option option);

    List<Etudiant> getAllOrderByNomEtudiantAsc();


    void assignModuleToEtudiant(int etudiantId, int moduleId);


    Set<Equipe> EquipeByEtudiant(int etudiantID);

    Set<Module> ModulesByEtudiant(int etudiantID);
}
