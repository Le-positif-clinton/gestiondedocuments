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
@Table(name = "document")
public class Document extends AbstractEntity{
    @Column(name = "titre")
    private String titre;
    @Column(name = "auteur")
    private String auteur;
    @Column(name = "dernierContributeur")
    private String dernierContributeur;
    @Column(name = "description")
    private String description;
    @Column(name = "sujet")
    private String sujet;
    @ManyToOne
    @JoinColumn(name = "idCategorie")
    private Categorie categorie;
    @OneToMany(mappedBy = "document")
    private List<DroitDocument> droitDocuments;
    @ManyToOne
    @JoinColumn(name = "idHistorique")
    private Historique historique;

    @JoinColumn(name = "id_fichier")
    @OneToOne(mappedBy = "document")
    private Fichier fichier;

}
