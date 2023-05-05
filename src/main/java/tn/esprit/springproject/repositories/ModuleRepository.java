package tn.esprit.springproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.springproject.entities.Departement;
import tn.esprit.springproject.entities.Module;

import java.util.List;

public interface ModuleRepository extends JpaRepository<Module, Integer> {
    List<Module> findModuleBycoeffModule(int idModule);

    //JPQL
    @Query("SELECT m From Module m JOIN m.enseignants e WHERE e.idEns= :idEns AND m.nomModule = :nomModule")
    Module getModuleBynomModuleAndenseignantJPQL(@Param("idEns") int idEns, @Param("nomModule") String nomModule);
}
