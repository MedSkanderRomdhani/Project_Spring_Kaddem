package tn.esprit.springproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;
import tn.esprit.springproject.entities.Etudiant;
import tn.esprit.springproject.entities.Option;

import java.util.List;


public interface EtudiantRepository extends JpaRepository<Etudiant, Integer> {

    Etudiant findByNomAndPrenom(String nom, String prenom);

    @Query("select e from Etudiant e where e.departement.idDepart=?1")

    List<Etudiant>getEtudiantsByDepartement(int idDepart);


    @Query(value = "select count (e.idEtudiant) from Etudiant e group by e.departement.idDepart having e.departement.idDepart=?1")
    Integer nombreEtudiantsByDepartement(int idDepart);

    @Query(value = "select count (e.idEtudiant) from Etudiant e where e.op=:option")
    Integer nombreEtudiantsByOption(@Param("option") Option option);

    @Query(value = "select e from Etudiant e where e.op=:option")
    List<Etudiant> EtudiantsByOption(@Param("option") Option option);



    @Query("select e from Etudiant e order by e.nom ASC ")
    List<Etudiant> getAllOrderByNomEtudiantAsc();


}
