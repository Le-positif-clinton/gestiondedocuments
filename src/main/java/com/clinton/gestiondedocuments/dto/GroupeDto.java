package com.clinton.gestiondedocuments.dto;

import com.clinton.gestiondedocuments.model.DroitDocument;
import com.clinton.gestiondedocuments.model.Groupe;
import com.clinton.gestiondedocuments.model.Utilisateur;
//import jakarta.persistence.Column;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GroupeDto {
    private Integer id;

    private String nom;

    private String code;

    private List<UtilisateurDto> utilisateurDtos;

    private DroitDocumentDto droitDocumentDto;

    public static GroupeDto fromEntity(Groupe groupe){
        if (groupe.equals(null)){
            return null;
        }
        return GroupeDto.builder()
                .id(groupe.getId())
                .nom(groupe.getNom())
                .code(groupe.getCode())
                .build();
    }
    public static Groupe toEntity(GroupeDto groupeDto){
        if (groupeDto.equals(null)){
            return null;
        }
        Groupe groupe = new Groupe();
        groupe.setId(groupeDto.getId());
        groupe.setNom(groupe.getNom());
        groupe.setCode(groupeDto.getCode());
        return groupe;

    }
}
