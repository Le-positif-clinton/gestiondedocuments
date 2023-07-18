package com.clinton.gestiondedocuments.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "fichier")
public class Fichier {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id")
    private String id;
    @Column(name = "nom")
    private String nom;
    @Column(name = "chemin")
    private String chemin;
    @Column(name = "type")
    private String type;
    @Column(name = "taille")
    private long taille;
    @OneToOne
    @JoinColumn(name = "idDocument")
    private Document document;
    @Lob
    @Column(name = "donnee")
    private byte[] donnee;

    public Fichier(String nom, String type, byte[] donnee) {
        this.nom = nom;
        this.type = type;
        this.donnee = donnee;
    }
}
