package com.clinton.gestiondedocuments.dto;

import com.clinton.gestiondedocuments.model.Enseignant;
//import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EnseignantDto {
    private Integer id;

    private String nom;

    private String prenom;

    private String email;

    private String matiere;

    public static EnseignantDto fromEntity(Enseignant enseignant){
        if (enseignant.equals(null)){
            return null;
        }
        return EnseignantDto.builder()
                .id(enseignant.getId())
                .nom(enseignant.getNom())
                .prenom(enseignant.getPrenom())
                .email(enseignant.getEmail())
                .matiere(enseignant.getMatiere())
                .build();
    }
    public static Enseignant toEntity(EnseignantDto enseignantDto){
        if (enseignantDto.equals(null)){
            return null;
        }
        Enseignant enseignant = new Enseignant();
        enseignant.setId(enseignantDto.getId());
        enseignant.setNom(enseignantDto.getNom());
        enseignant.setPrenom(enseignantDto.getPrenom());
        enseignant.setEmail(enseignantDto.getEmail());
        enseignant.setMatiere(enseignantDto.getMatiere());

        return enseignant;
    }
}
