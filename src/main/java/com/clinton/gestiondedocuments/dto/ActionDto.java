package com.clinton.gestiondedocuments.dto;

import com.clinton.gestiondedocuments.model.Action;
import com.clinton.gestiondedocuments.model.Historique;
//import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ActionDto {
    private Integer id;
    private int numero;

    private List<HistoriqueDto> historiqueDtos;

    public static ActionDto fromEntity(Action action){
        if (action.equals(null)){
            return null;
        }
        return ActionDto.builder()
                .id(action.getId())
                .numero(action.getNumero())
                .build();
    }
    public static Action toEntity(ActionDto actionDto){
        if (actionDto.equals(null)){
            return null;
        }
        Action action = new Action();
        action.setId(actionDto.getId());
        action.setNumero(actionDto.getNumero());
        return action;
    }
}
