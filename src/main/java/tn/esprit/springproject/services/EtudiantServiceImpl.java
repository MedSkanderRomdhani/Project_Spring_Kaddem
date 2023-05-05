package tn.esprit.springproject.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.springproject.entities.*;
import tn.esprit.springproject.repositories.DepartementRepository;

import tn.esprit.springproject.repositories.EtudiantRepository;
import tn.esprit.springproject.repositories.ModuleRepository;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class EtudiantServiceImpl implements EtudiantService{
    EtudiantRepository etudiantRepository;
    DepartementRepository departementRepository;
    ModuleRepository moduleRepository;
    ContratService contratService;
    EquipeService equipeService;

    ModuleService moduleService;

    @Override
    public List<Etudiant> retrieveAllEtudiants() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant addEtudiant(Etudiant e) {
        return etudiantRepository.save(e);
    }

    @Override
    public void deleteEtudiant(int id) {
etudiantRepository.deleteById(id);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant e) {
        return etudiantRepository.save(e);
    }

    @Override
    public Etudiant retrieveEtudiant(int id) {
        return etudiantRepository.findById(id).orElse(null);
    }

    @Override
    public void assignEtudiantToDepartement(int etudiantId, int departementId) {
        Etudiant etudiant=retrieveEtudiant(etudiantId);
        Departement departement=departementRepository.findById(departementId).orElse(null);
        etudiant.setDepartement(departement);
        etudiantRepository.save(etudiant);
    }

    @Override
    public Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, int idContrat, int idEquipe) {
        Contrat contrat=contratService.retrieveContrat(idContrat);
        Equipe equipe=equipeService.retrieveEquipe(idEquipe);
        contrat.setEtudiant(e);
        equipe.getEtudiants().add(e);
        return etudiantRepository.save(e);
    }


    @Override
    public Etudiant findByNomAndPrenom(String nom, String prenom) {
        return etudiantRepository.findByNomAndPrenom(nom,prenom);
    }

    @Override
    public List<Etudiant> getEtudiantsByDepartement(int idDepart) {
        return etudiantRepository.getEtudiantsByDepartement(idDepart);
    }

    @Override
    public Integer nombreEtudiantsByDepartement(int idDepart) {
        return  etudiantRepository.nombreEtudiantsByDepartement(idDepart);
    }

    @Override
    public Integer nombreEtudiantsByOption(Option option) {
        return  etudiantRepository.nombreEtudiantsByOption(option);
    }

    @Override
    public List<Etudiant> EtudiantsByOption(Option option) {
        return  etudiantRepository.EtudiantsByOption(option);
    }

    @Override
    public List<Etudiant> getAllOrderByNomEtudiantAsc() {
        return etudiantRepository.getAllOrderByNomEtudiantAsc();
    }

    @Override
    public void assignModuleToEtudiant(int etudiantId, int moduleId) {
        Etudiant etudiant=retrieveEtudiant(etudiantId);
        Module module= moduleRepository.findById(moduleId).orElse(null);
        Set<Module> modules = etudiant.getModules();
        modules.add(module);
        etudiant.setModules(modules);
        etudiantRepository.save(etudiant);
    }

    @Override
    public Set<Equipe> EquipeByEtudiant(int etudiantID) {
       Etudiant etudiant=retrieveEtudiant(etudiantID);
       return etudiant.getEquipes();
    }

    @Override
    public Set<Module> ModulesByEtudiant(int etudiantID) {
        Etudiant etudiant=retrieveEtudiant(etudiantID);
        return etudiant.getModules();
    }
}


