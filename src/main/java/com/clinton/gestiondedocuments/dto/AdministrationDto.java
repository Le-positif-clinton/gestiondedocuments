package com.clinton.gestiondedocuments.dto;

import com.clinton.gestiondedocuments.model.Administration;
//import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AdministrationDto {
    private Integer id;

    private String nom;

    private String prenom;

    private String email;

    private String role;

    public static AdministrationDto fromEntity(Administration administration){
        if (administration.equals(null)){
            return null;
        }
        return AdministrationDto.builder()
                .id(administration.getId())
                .nom(administration.getNom())
                .prenom(administration.getPrenom())
                .email(administration.getEmail())
                .role(administration.getRole())
                .build();
    }
    public static Administration toEntity(AdministrationDto administrationDto){
        if (administrationDto.equals(null))
            return null;
        Administration administration = new Administration();
        administration.setId(administrationDto.getId());
        administration.setNom(administrationDto.getNom());
        administration.setPrenom(administrationDto.getPrenom());
        administration.setEmail(administrationDto.getEmail());
        administration.setRole(administrationDto.getRole());
        return administration;
    }


}
