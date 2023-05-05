package tn.esprit.springproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;
import tn.esprit.springproject.entities.Departement;
import tn.esprit.springproject.entities.MaxRecruDepart;


import java.util.Date;
import java.util.List;

public interface DepartementRepository extends JpaRepository<Departement, Integer> {
    //**************** YOSRA**************************
    List<Departement> getDepartementsByNomDepartContains(String nom);

    Departement searchDepartementByNomDepart(String nom);

    @Query("select d from Departement d order by d.nomDepart ASC ")
    List<Departement> getAllOrderByNomDepartAsc();

    @Query("select avg (e.salaire) from Enseignant e group by e.departement.idDepart having e.departement.idDepart=?1")
    double salaireMoyenParDepartement(int idDepart);

    @Query(value = "select count (e.dateRecrutement) as nbr,d.nomDepart as nom,e.dateRecrutement from Departement d  LEFT JOIN Enseignant e ON d.idDepart=e.departement.idDepart  where e.dateRecrutement between :startDate and :endDate group by (d.idDepart)")
    List<MaxRecruDepart> nbRecrutementBydepartBetweenDeuxDates(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

//********************************************
}
