package tn.esprit.springproject.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springproject.entities.Encadrant;
import tn.esprit.springproject.services.EncadrantService;

import java.util.List;

@CrossOrigin
@Tag(name = "EncadrantController")
@AllArgsConstructor
@RestController
@RequestMapping("Encadrant")
public class EncadrantController {
    EncadrantService encadrantService;

    @Operation(description = "AjouterEncadrant")
    @PostMapping("/AjouterEncadrant")
    Encadrant ajouterEncadrant(@RequestBody Encadrant e) {
        return encadrantService.addEncadrant(e);
    }

    @Operation(description = "ModifierEncadrant")
    @PutMapping("/ModifierEncadrant")
    Encadrant updateEncadrant(@RequestBody Encadrant e) {
        return encadrantService.updateEncadrant(e);
    }

    @Operation(description = "AfficherAllEncadrants")
    @GetMapping("/AfficherAllEncadrants")
    List<Encadrant> retrieveAllEncadrant() {
        return encadrantService.retrieveAllEncadrants();
    }

    @Operation(description = "AfficherEncadrant")
    @GetMapping("/AfficherEncadrant/{id}")
    Encadrant getEncadrantById(@PathVariable int id) {
        return encadrantService.retrieveEncadrant(id);
    }

    @Operation(description = "DeleteEncadrant")
    @DeleteMapping("/DeleteEncadrant/{id}")
    void deleteEncadrant(@PathVariable int id) {
        encadrantService.deleteEncadrant(id);
    }
}
