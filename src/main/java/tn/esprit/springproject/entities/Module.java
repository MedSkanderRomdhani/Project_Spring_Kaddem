package tn.esprit.springproject.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private int idModule;
    private String nomModule;
    private int coeffModule;
    @ManyToMany
    @JsonIgnore
    private Set<Enseignant> enseignants;

    @ManyToMany(mappedBy = "modules")
    @JsonIgnore
    private Set<Etudiant> etudiants;
}
