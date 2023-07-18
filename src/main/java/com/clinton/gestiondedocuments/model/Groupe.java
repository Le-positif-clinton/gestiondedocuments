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
@Table(name = "groupe")
public class Groupe extends AbstractEntity{
    @Column(name = "nom")
    private String nom;
    @Column(name = "code")
    private String code;
    @OneToMany(mappedBy = "groupe")
    private List<Utilisateur> utilisateurs;
    @ManyToOne
    @JoinColumn(name = "idDroitDocument")
    private DroitDocument droitDocument;

}
