package tn.esprit.springproject.services;

import tn.esprit.springproject.entities.*;

import java.util.Date;
import java.util.List;

public interface ContratService {
    List<Contrat> retrieveAllContrats();

    Contrat addContrat(Contrat c);

    void deleteContrat(int id);

    Contrat updateContrat(Contrat c);

    Contrat retrieveContrat(int id);

    Contrat affectContratToEtudiant(Contrat ce, String nom, String prenom);

    float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate);

    Integer nbContratsValides(Date startDate, Date endDate);

    List<Contrat> getContratBySpecialite(Specialite specialite);

    float getChiffreAffaireParEtudiant(int idEtudiant);

    void asseignContratToEtudiant(int idContrat, int idEtudiant);

    List<Contrat> findByDateFinContratBetween(Date startdate, Date enddate);

    List<Contrat> findByDateDebutContratBetween(Date startdate, Date enddate);

    List<Contrat> findByArchive(boolean archivee);

    List<Contrat> findByMontantContratGreaterThanEqual(Double montant);

    List<Contrat> findByMontantContratLessThanEqual(Double montant);

    List<Contrat> findByOptionEtudiant(Option option);

    List<Contrat> findByEquipe(int idEquipe);

    List<Contrat> findByNiveauEquipe(Niveau niveau);

    List<Contrat> findByDepartement(int idDepartement);

    float getChiffreAffaireParEquipe(int idEquipe);

    Contrat archiverContrat(int idContrat);

    List<Contrat> getContratsEntreDeuxDate(Date date1, Date date2);

    float getChiffreAffaireParEtudiantEntreDeuxDate(int idEtudiant, Date startdate, Date enddate);
}
