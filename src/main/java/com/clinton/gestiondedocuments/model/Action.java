package com.clinton.gestiondedocuments.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "action")
public class Action extends AbstractEntity{
    @Column(name = "numero")
    private int numero;
    @OneToMany(mappedBy = "action")
    private List<Historique> historiques;
}
