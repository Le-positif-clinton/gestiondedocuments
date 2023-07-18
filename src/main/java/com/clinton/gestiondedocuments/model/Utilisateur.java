package com.clinton.gestiondedocuments.model;

import javax.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "utilisateur")
public class Utilisateur extends AbstractEntity{
    @Column(name = "code")
    private String code;
    @Column(name = "motDePasse")
    private String motDePasse;
    @Column(name = "nomUtilisateur")
    private String nomUtilisateur;
    @Column(name = "email")
    private String email;
    @Column(name = "etat")
    private boolean etat;
    @ManyToOne
    @JoinColumn(name = "idGroupe")
    private Groupe groupe;
    @ManyToOne
    @JoinColumn(name = "idHistorique")
    private Historique historique;

    @OneToMany(mappedBy = "utilisateur")
    private List<Roles> roles;
}
