package com.clinton.gestiondedocuments.model;

import javax.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "historique")
public class Historique extends AbstractEntity{
    @Column(name = "date")
    private Date date;
    @OneToMany(mappedBy = "historique")
    private List<Document> documents;
    @OneToMany(mappedBy = "historique")
    private List<Utilisateur> utilisateurs;
    @ManyToOne
    @JoinColumn(name = "idAction")
    private Action action;

}
