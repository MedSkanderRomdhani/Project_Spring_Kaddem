package tn.esprit.springproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.springproject.entities.Departement;
import tn.esprit.springproject.entities.Enseignant;
import tn.esprit.springproject.entities.Fonction;

import java.util.Date;
import java.util.List;

public interface EnseignantRepository extends JpaRepository<Enseignant, Integer> {
    //**************** YOSRA**************************
    List<Enseignant> getEnseignantsByFonctionAndDepartement_IdDepart(Fonction fonction, int idDepart);

    @Query(value = "select count (e.idEns) from Enseignant e group by e.departement.idDepart having e.departement.idDepart=?1")
    Integer nombreEnseignantsByDepartement(int idDepart);

    List<Enseignant> findEnseignantsByDateRecrutementBetweenAndDepartement_IdDepart(Date startDate, Date finDate, int idDepart);

    //**********************************************************
    Enseignant getEnseignantByFonctionAndDepartement_IdDepart(Fonction fonction, int idDepart);

    /* Enseignant getEneignantByFonctionAndModule_IdModule(Fonction fonction,int idModule);*/
    Enseignant findEnseignantBynomEns(String nomEns);

    List<Enseignant> findEnseignantByModules_idModule(int idModule);

    List<Enseignant> findEnseignantByFonctionAndModules_idModule(Fonction fonction, int idModule);
}
