package tn.esprit.springproject.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springproject.entities.Etudiant;
import tn.esprit.springproject.entities.Module;
import tn.esprit.springproject.services.ModuleService;

import javax.websocket.server.PathParam;
import java.util.List;

@Tag(name = "ModuleController")
@AllArgsConstructor
@RestController
@RequestMapping("Module")
public class ModuleController {
    ModuleService moduleService;

    @Operation(description = "AjouterEtudiant")
    @PostMapping("/AjouterModule")
    Module ajouterModule(@RequestBody Module mod) {
        return moduleService.addModule(mod);
    }

    @Operation(description = "ModifierModule")
    @PutMapping("/ModifierModule")
    Module updateModule(@RequestBody Module mod) {
        return moduleService.updateModule(mod);

    }

    @Operation(description = "AfficherAllModules")
    @GetMapping("/AfficherAllModules")
    List<Module> retrieveAllModules() {
        return moduleService.retrieveAllModules();
    }

    @Operation(description = "AfficherModule")
    @GetMapping("/AfficherModuleById/{id}")
    Module getModuleById(@PathVariable int id) {
        return moduleService.retrieveModule(id);
    }

    @Operation(description = "DeleteModule")
    @DeleteMapping("/DeleteModule/{id}")
    void deleteModule(@PathVariable int id) {
        moduleService.deleteModule(id);
    }

    @PutMapping("/assignEnseignantModule/")
    public void assignEnseignantToModule(@PathParam("enseignantId") int enseignantId, @PathParam("idModule") int idModule) {
        moduleService.assignEnseignantToModule(enseignantId, idModule);
    }

    @GetMapping("/chercherModuleByCoeff/{idModule}")
    public List<Module> chercherModuleBycoeffModule(@PathVariable int idModule) {
        return moduleService.chercherModuleBycoeffModule(idModule);

    }

    @GetMapping("/chercherModuleBynomModuleenseignant/{idEns}/{nomModule}")
    public Module getModuleBynomModuleAndenseignant(@PathVariable int idEns, @PathVariable String nomModule) {
        return moduleService.getModuleBynomModuleAndenseignant(idEns, nomModule);
    }
}
