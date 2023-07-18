package com.clinton.gestiondedocuments.dto;

import com.clinton.gestiondedocuments.model.Action;
import com.clinton.gestiondedocuments.model.Document;
import com.clinton.gestiondedocuments.model.Historique;
import com.clinton.gestiondedocuments.model.Utilisateur;
//import jakarta.persistence.Column;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Builder
public class HistoriqueDto {
    private Integer id;

    private Date date;

    private List<DocumentDto> documentDtos;

    private List<UtilisateurDto> utilisateurDtos;

    private ActionDto actionDto;

    public static HistoriqueDto fromEntity(Historique historique){
        if (historique.equals(null)){
            return null;
        }
        return HistoriqueDto.builder()
                .id(historique.getId())
                .date(historique.getDate())
                .build();
    }
    public static Historique toEntity(HistoriqueDto historiqueDto){
        if (historiqueDto.equals(null)){
            return null;
        }
        Historique historique = new Historique();
        historique.setId(historiqueDto.getId());
        historique.setDate(historiqueDto.getDate());
        return historique;
    }
}
