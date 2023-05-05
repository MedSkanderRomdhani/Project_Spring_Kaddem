package tn.esprit.springproject.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Etudiant {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private int idEtudiant;
    @Enumerated(EnumType.STRING)
    private Option op;
    private String nom;
    private String prenom;
    @ManyToMany(mappedBy = "etudiants")
    @JsonIgnore
    private Set<Equipe> equipes;
    @ManyToOne
    @JsonIgnore
    private Departement departement;
    @OneToMany(mappedBy = "etudiant")
    @JsonIgnore
    private Set<Contrat> contrats;

    @ManyToMany
    @JsonIgnore
    private Set<Module> modules;
}
