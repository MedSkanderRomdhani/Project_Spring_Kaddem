package tn.esprit.springproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.springproject.entities.TriunivDto;
import tn.esprit.springproject.entities.Universite;

import java.util.List;


public interface UniversiteRepository extends JpaRepository<Universite, Integer> {
    @Query(value = "SELECT COUNT(departement.id_depart) FROM departement \n" +
            "WHERE universite_id_univ= :id", nativeQuery = true)
    public int nbrdepUniv(@Param("id") Integer id);


    ///////////////////////////////////////////////////////////////////////////////////////

    @Query(value = "SELECT COUNT(etudiant.id_etudiant) FROM etudiant\n" +
            "LEFT JOIN departement ON departement.id_depart=etudiant.departement_id_depart \n" +
            "LEFT JOIN universite ON universite.id_univ = departement.universite_id_univ\n" +
            "WHERE universite.id_univ= :id", nativeQuery = true)
    public int nbretudUniv(@Param("id") Integer id);

    ///////////////////////////////////////////////////////////////////////////////////////////

    @Query(value = "SELECT    universite.nom_univ univ, COUNT(etudiant.id_etudiant)  nbr FROM etudiant\n" +
            "            LEFT JOIN departement ON departement.id_depart=etudiant.departement_id_depart\n" +
            "            LEFT JOIN universite ON universite.id_univ = departement.universite_id_univ\n" +
            "            GROUP BY(universite.id_univ)\n" +
            "            ORDER BY(COUNT(etudiant.id_etudiant) ) DESC;", nativeQuery = true)
    public List<TriunivDto> triuniv();


    ///////////////////////////////////////////////////////////////////////////////////////////////

//    @Query(value = "SELECT nom_univ FROM universite WHERE adresse=?1", nativeQuery = true)
//    public List<Universite> NomUnivParAdresse(@Param("adr") String adresse);

    public List<Universite> findUniversiteByAdresse(String adresse);

    public List<Universite> findUniversiteByAdresseContainingIgnoreCase(String x);



}
