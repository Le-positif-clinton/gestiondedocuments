package com.clinton.gestiondedocuments.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "categorie")
public class Categorie extends AbstractEntity{
    @Column(name = "numCategorie")
    private int numCategorie;
    @Column(name = "nom")
    private String nom;
    @Column(name = "code")
    private String code;
    @Column(name = "description")
    private String description ;
    @OneToMany(mappedBy = "categorie")
    private List<Document> documents;

}
