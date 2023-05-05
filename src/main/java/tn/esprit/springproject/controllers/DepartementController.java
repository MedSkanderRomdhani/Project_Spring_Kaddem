package tn.esprit.springproject.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springproject.entities.Departement;

import tn.esprit.springproject.entities.MaxRecruDepart;
import tn.esprit.springproject.services.DepartementService;


import java.util.Date;
import java.util.List;
import java.util.Set;

@CrossOrigin(origins = "*")
@Tag(name = "DepartementController")
@AllArgsConstructor
@RestController
@RequestMapping("Departement")
public class DepartementController {
    DepartementService departementService;

    @Operation(description = "AjouterDepartement")
    @PostMapping("/AjouterDepartement")
    Departement ajouterDepartement(@RequestBody Departement departement) {
        return departementService.addDepartement(departement);
    }

    @Operation(description = "ModifierDepartement")
    @PutMapping("/ModifierDepartement")
    Departement updateDepartement(@RequestBody Departement departement) {
        return departementService.updateDepartement(departement);

    }

    @Operation(description = "AfficherAllDepartements")
    @GetMapping("/AfficherAllDepartements")
    List<Departement> retrieveAllDepartements() {
        return departementService.retrieveAllDepartements();
    }

    @Operation(description = "AfficherDepartement")
    @GetMapping("/AfficherDepartement/{id}")
    Departement getDepartementById(@PathVariable int id) {
        return departementService.retrieveDepartement(id);
    }

    @Operation(description = "DeleteDepartement")
    @DeleteMapping("/DeleteDepartement/{id}")
    void deleteDepartement(@PathVariable int id) {
        departementService.deleteDepartement(id);
    }

    @Operation(description = "AfficherAllDepartementsByUniv")
    @GetMapping("/AfficherAllDepartementsByUniv/{idUniversite}")
    public Set<Departement> retrieveDepartementsByUniversite(@PathVariable int idUniversite) {
        return departementService.retrieveDepartementsByUniversite(idUniversite);
    }

    @Operation(description = "searchDepartementByNomDepart")
    @GetMapping("/searchDepartementByNomDepart")
    Departement searchDepartementByNomDepart(String nomDepart) {
        return departementService.searchDepartementByNomDepart(nomDepart);
    }

    @Operation(description = "getAllOrderByNomDepartAsc")
    @GetMapping("/getAllOrderByNomDepartAsc")
    List<Departement> getAllOrderByNomDepartAsc() {
        return departementService.getAllOrderByNomDepartAsc();
    }

    @Operation(description = "salaireMoyenParDepartement")
    @GetMapping("/salaireMoyenParDepartement/{idDepart}")
    double salaireMoyenParDepartement(@PathVariable int idDepart) {
        return departementService.salaireMoyenParDepartement(idDepart);
    }

    @Operation(description = "getDepartementsByNomDepartContains")
    @GetMapping("/getDepartementsByNomDepartContains/{nom}")
    List<Departement> getDepartementsByNomDepartContains(@PathVariable String nom) {
        return departementService.getDepartementsByNomDepartContains(nom);
    }

    @Operation(description = "maxDepartementRecrutement")
    @GetMapping("/maxDepartementRecrutement/{startDate}/{endDate}")
    List<MaxRecruDepart> nbRecrutementBydepartBetweenDeuxDates(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate, @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate) {
        return departementService.nbRecrutementBydepartBetweenDeuxDates(startDate, endDate);
    }
}
