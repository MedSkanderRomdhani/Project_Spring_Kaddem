package tn.esprit.springproject.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springproject.entities.*;
import tn.esprit.springproject.services.ContratService;

import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "*")
@Tag(name = "ContratController")
@AllArgsConstructor
@RestController
@RequestMapping("Contrat")
public class ContratController {
    ContratService contratService;

    @Operation(description = "AjouterContrat")
    @PostMapping("/AjouterContrat")
    Contrat ajouterContrat(@RequestBody Contrat c) {
        return contratService.addContrat(c);
    }

    @Operation(description = "ModifierContrat")
    @PutMapping("/ModifierContrat")
    Contrat updateContrat(@RequestBody Contrat c) {
        return contratService.updateContrat(c);
    }

    @Operation(description = "AfficherAllContrats")
    @GetMapping("/AfficherAllContrats")
    List<Contrat> retrieveAllContrat() {
        return contratService.retrieveAllContrats();
    }

    @Operation(description = "AfficherContrat")
    @GetMapping("/AfficherContrat/{id}")
    Contrat getContratById(@PathVariable int id) {
        return contratService.retrieveContrat(id);
    }

    @Operation(description = "DeleteContrat")
    @DeleteMapping("/DeleteContrat/{id}")
    void deleteContrat(@PathVariable int id) {
        contratService.deleteContrat(id);
    }

    @Operation(description = "affectContratToEtudiant")
    @PutMapping("/affectContratToEtudiant/{nom}/{prenom}")
    public Contrat affectContratToEtudiant(@RequestBody Contrat ce, @PathVariable String nom, @PathVariable String prenom) {
        return contratService.affectContratToEtudiant(ce, nom, prenom);
    }

    @Operation(description = "nbContratsValides")
    @GetMapping("/getNbContrat/{startDate}/{endDate}")
    Integer nbContratsValides(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate, @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate) {
        return contratService.nbContratsValides(startDate, endDate);
    }

    @Operation(description = "getChiffreAffaireEntreDeuxDate")
    @GetMapping("/getChiffreAffaire/{startDate}/{endDate}")
    public float getChiffreAffaireEntreDeuxDate(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate, @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate) {
        return contratService.getChiffreAffaireEntreDeuxDate(startDate, endDate);
    }

    @GetMapping("getContratBySpecialite/{specialite}")
    public List<Contrat> getContratBySpecialite(@PathVariable Specialite specialite) {
        return contratService.getContratBySpecialite(specialite);
    }

    @PutMapping("AsseignContartToEtudiant/{idContrat}/{idEtudiant}")
    public void asseignContartToEtudiant(@PathVariable int idContrat, @PathVariable int idEtudiant) {
        contratService.asseignContratToEtudiant(idContrat, idEtudiant);
    }

    @GetMapping("getChiffreAffaireParEtudiant/{idEtudiant}")
    public float getChiffreAffaireParEtudiant(@PathVariable int idEtudiant) {
        return contratService.getChiffreAffaireParEtudiant(idEtudiant);
    }

    @GetMapping("findByDateFinContratBetween/{startdate}/{enddate}")
    public List<Contrat> findByDateFinContratBetween(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startdate, @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date enddate) {
        return contratService.findByDateFinContratBetween(startdate, enddate);
    }

    @GetMapping("findByDateDebutContratBetween/{startdate}/{enddate})")
    public List<Contrat> findByDateDebutContratBetween(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startdate, @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date enddate) {
        return contratService.findByDateDebutContratBetween(startdate, enddate);
    }

    @GetMapping("findByArchive/{archivee}")
    public List<Contrat> findByArchive(@PathVariable boolean archivee) {
        return contratService.findByArchive(archivee);
    }

    @GetMapping("findByMontantContratGreaterThan/{montant}")
    public List<Contrat> findByMontantContratGreaterThanEqual(@PathVariable Double montant) {
        return contratService.findByMontantContratGreaterThanEqual(montant);
    }

    @GetMapping("findByMontantContratLessThan/{montant}")
    public List<Contrat> findByMontantContratLessThanEqual(@PathVariable Double montant) {
        return contratService.findByMontantContratLessThanEqual(montant);
    }

    @GetMapping("findByOptionEtudiant/{option}")
    public List<Contrat> findByOptionEtudiant(@PathVariable Option option) {
        return contratService.findByOptionEtudiant(option);
    }

    @GetMapping("findByEquipe/{idEquipe}")
    List<Contrat> findByEquipe(@PathVariable int idEquipe) {
        return contratService.findByEquipe(idEquipe);
    }

    @GetMapping("findByNiveauEquipe/{niveau}")
    public List<Contrat> findByNiveauEquipe(@PathVariable Niveau niveau) {
        return contratService.findByNiveauEquipe(niveau);
    }

    @GetMapping("findByDepartement/{idDepartement}")
    public List<Contrat> findByDepartement(@PathVariable int idDepartement) {
        return contratService.findByDepartement(idDepartement);
    }

    @GetMapping("getChiffreAffaireParEquipe/{idEquipe}")
    public float getChiffreAffaireParEquipe(@PathVariable int idEquipe) {
        return contratService.getChiffreAffaireParEquipe(idEquipe);
    }

    @PutMapping("archiverContrat/{idContrat}")
    public Contrat archiverContrat(@PathVariable int idContrat) {
        return contratService.archiverContrat(idContrat);
    }

    @GetMapping("getContratsEntreDeuxDate/{date1}/{date2}")
    List<Contrat> getContratsEntreDeuxDate(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date1, @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date2) {
        return contratService.getContratsEntreDeuxDate(date1, date2);
    }

    @GetMapping("getChiffreAffaireParEtudiantEntreDeuxDate/{idEtudiant}/{startdate}/{enddate}")
    public float getChiffreAffaireParEtudiantEntreDeuxDate(@PathVariable int idEtudiant, @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startdate, @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date enddate) {
        return contratService.getChiffreAffaireParEtudiantEntreDeuxDate(idEtudiant, startdate, enddate);
    }
}