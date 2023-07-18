package com.clinton.gestiondedocuments.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "etudiant")
public class Etudiant extends AbstractEntity{
    @Column(name = "matricule")
    private String matricule;
    @Column(name = "nom")
    private String nom;
    @Column(name = "prenom")
    private String prenom;
    @Column(name = "email")
    private String email;
    @Column(name = "cycle")
    private String cycle;
    @Column(name = "niveau")
    private int niveau;
}
