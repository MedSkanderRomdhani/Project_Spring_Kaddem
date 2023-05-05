package tn.esprit.springproject.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springproject.entities.Departement;
import tn.esprit.springproject.entities.DetailEquipe;
import tn.esprit.springproject.services.DetailEquipeService;
import tn.esprit.springproject.services.DetailEquipeServiceImpl;

import java.util.List;

@Tag(name = "DetailEquipeController")
@RestController
@AllArgsConstructor
@RequestMapping("DetailEquipe")
public class DetailEquipeController {
    DetailEquipeService DetailEquipe;

    @Operation(description = "AjouterDetailEquipe")
    @PostMapping("/Ajouter")
    DetailEquipe ajouterDetailEquipe(@RequestBody DetailEquipe detailEquipe) {
        return DetailEquipe.addDetailEquipe(detailEquipe);
    }

    @Operation(description = "ModifierDetailEquipe")
    @PutMapping("/Modifier")
    DetailEquipe updateDetailEquipe(@RequestBody DetailEquipe detailEquipe) {
        return DetailEquipe.updateDetailEquipe(detailEquipe);

    }

    @Operation(description = "AfficherAllDetailEquipe")
    @GetMapping("/AfficherAll")
    List<DetailEquipe> retrieveAllDetailEquipe() {
        return DetailEquipe.retrieveAllDetails();
    }

    @Operation(description = "AfficherDetailEquipe")
    @GetMapping("/Afficher/{id}")
    DetailEquipe getDetailEquipeById(@PathVariable int id) {
        return DetailEquipe.retrieveDetailEquipe(id);
    }

    @Operation(description = "DeleteDetailEquipe")
    @DeleteMapping("/Delete")
    void deleteDetailEquipe(@PathVariable int id) {
        DetailEquipe.deleteDetailEquipe(id);
    }

    @GetMapping("/afficherdetailparequipe/{id}")
    public DetailEquipe retrieveDetailparEquipe(@PathVariable Integer id) {
        return DetailEquipe.retrieveDetailEquipe(id);
    }

    @GetMapping("/afficherListeDetailEquipeTriee")
    List<DetailEquipe> afficherListeDetailEquipeTriee() {
        return DetailEquipe.afficherListeDetailEquipeTriee();
    }
}

