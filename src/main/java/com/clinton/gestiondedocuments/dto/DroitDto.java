package com.clinton.gestiondedocuments.dto;

import com.clinton.gestiondedocuments.model.Droit;
//import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DroitDto {
    private Integer id;

    private boolean peutTelecharger;

    private boolean peutConsulter;

    private boolean peutSupprimer;

    public static DroitDto fromEntity(Droit droit){
        if (droit.equals(null)){
            return null;
        }
        return DroitDto.builder()
                .id(droit.getId())
                .peutTelecharger(droit.isPeutTelecharger())
                .peutConsulter(droit.isPeutConsulter())
                .peutSupprimer(droit.isPeutSupprimer())
                .build();
    }
    public static Droit toEntity(DroitDto droitDto){
        if (droitDto.equals(null)){
            return null;
        }
        Droit droit = new Droit();
        droit.setId(droitDto.getId());
        droit.setPeutTelecharger(droitDto.isPeutTelecharger());
        droit.setPeutConsulter(droit.isPeutConsulter());
        droit.setPeutSupprimer(droitDto.isPeutSupprimer());
        return droit;
    }
}
