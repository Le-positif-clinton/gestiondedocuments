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
@Table(name = "droitDocument")
public class DroitDocument extends AbstractEntity{
    @Column(name = "nomDocument")
    private String nomDocument;
    @OneToMany(mappedBy = "droitDocument")
    private List<Groupe> groupes;
    @ManyToOne
    @JoinColumn(name = "idDocument")
    private Document document;
}
