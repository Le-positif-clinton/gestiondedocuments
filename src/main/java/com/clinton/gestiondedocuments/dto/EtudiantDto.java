package com.clinton.gestiondedocuments.dto;

import com.clinton.gestiondedocuments.model.Etudiant;
//import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EtudiantDto {
    private Integer id;

    private String matricule;

    private String nom;

    private String prenom;

    private String email;

    private String cycle;

    private int niveau;
    public static EtudiantDto fromEntity(Etudiant etudiant){
        if (etudiant.equals(null)){
            return null;
        }
        return EtudiantDto.builder()
                .id(etudiant.getId())
                .matricule(etudiant.getMatricule())
                .nom(etudiant.getNom())
                .prenom(etudiant.getPrenom())
                .email(etudiant.getEmail())
                .cycle(etudiant.getCycle())
                .niveau(etudiant.getNiveau())
                .build();
    }
    public static Etudiant toEntity(EtudiantDto etudiantDto){
        if(etudiantDto.equals(null)){
            return null;
        }

        Etudiant etudiant = new Etudiant();
        etudiant.setId(etudiantDto.getId());
        etudiant.setMatricule(etudiantDto.getMatricule());
        etudiant.setNom(etudiantDto.getNom());
        etudiant.setPrenom(etudiantDto.getPrenom());
        etudiant.setEmail(etudiantDto.getEmail());
        etudiant.setCycle(etudiantDto.getCycle());
        etudiant.setNiveau(etudiantDto.getNiveau());

        return etudiant;
    }
}
