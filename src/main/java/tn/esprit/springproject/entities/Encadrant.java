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
public class Encadrant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private int idEncadrant;
    private String nomEncadrant;
    private String prenomEncadrant;
    @Enumerated(EnumType.STRING)
    private Grade grade;
    @OneToMany(mappedBy = "encadrant")
    @JsonIgnore
    private Set<Equipe> equipes;
}
