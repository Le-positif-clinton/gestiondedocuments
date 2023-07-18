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
@Table(name = "droit")
public class Droit extends AbstractEntity{
    @Column(name = "peutTelecharger")
    private boolean peutTelecharger;
    @Column(name = "peutCinsulter")
    private boolean peutConsulter;
    @Column(name = "peutSupprimer")
    private boolean peutSupprimer;
}
