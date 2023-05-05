package tn.esprit.springproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.springproject.entities.Contrat;
import tn.esprit.springproject.entities.Equipe;
import tn.esprit.springproject.entities.Option;
import tn.esprit.springproject.entities.Specialite;

import java.util.Date;
import java.util.List;

public interface ContratRepository extends JpaRepository<Contrat, Integer> {
    public List<Contrat> findByEtudiantIdEtudiantAndAndArchive(int idEtudiant, Boolean archive);

    List<Contrat> findContratsByDateDebutContratAndAndDateFinContrat(Date dateDebut, Date dateFin);

    List<Contrat> findByDateFinContratBetweenAndArchive(Date date1, Date date2, Boolean valid);

    //Integer countByContratArchive(Boolean valid);
    List<Contrat> findByEtudiantIdEtudiantAndArchive(int idEtudiant, Boolean archive);

    List<Contrat> findByEtudiant_IdEtudiantAndArchive(int idEtudiant, boolean archivee);

    List<Contrat> findBySpecialite(Specialite specialite);

    List<Contrat> findByDateFinContratBetween(Date startdate, Date enddate);

    List<Contrat> findByDateDebutContratBetween(Date startdate, Date enddate);

    List<Contrat> findByArchive(boolean archivee);

    List<Contrat> findByMontantContratGreaterThanEqual(Double montant);

    List<Contrat> findByMontantContratLessThanEqual(Double montant);

    List<Contrat> findByEtudiant_Op(Option option);

    List<Contrat> findByEtudiantNotNull();

    List<Contrat> findByEtudiantNotNullAndAndDateFinContratBetween(Date startdate, Date enddate);

    List<Contrat> findByDateFinContratBetweenOrDateDebutContratBetween(Date startdate, Date enddate, Date date1, Date date2);

    List<Contrat> findByEtudiant_IdEtudiantAndDateFinContratBetweenOrDateDebutContratBetweenAndArchive(int idEtudaint, Date startdate, Date enddate, Date date1, Date date2, boolean archive);

    List<Contrat> findByEtudiantNotNullAndArchive(boolean archive);
}

