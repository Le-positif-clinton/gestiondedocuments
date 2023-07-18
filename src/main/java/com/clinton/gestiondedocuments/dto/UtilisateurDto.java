package com.clinton.gestiondedocuments.dto;

import com.clinton.gestiondedocuments.model.Groupe;
import com.clinton.gestiondedocuments.model.Historique;
import com.clinton.gestiondedocuments.model.Utilisateur;
//import jakarta.persistence.Column;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UtilisateurDto {
    private Integer id;

    private String code;

    private String motDePasse;

    private String nomUtilisateur;

    private String email;

    private boolean etat;

    private GroupeDto groupe;
    private Integer idGroupe;

    private HistoriqueDto historiqueDto;

    @JsonIgnore
    private List<RolesDto> roles;

    public static UtilisateurDto fromEntity(Utilisateur utilisateur){
        if (utilisateur.equals(null)){
            return null;
        }
        return UtilisateurDto.builder()
                .id(utilisateur.getId())
                .code(utilisateur.getCode())
                .motDePasse(utilisateur.getMotDePasse())
                .nomUtilisateur(utilisateur.getNomUtilisateur())
                .email(utilisateur.getEmail())
                .etat(utilisateur.isEtat())
                .build();
    }
    public static Utilisateur toEntity(UtilisateurDto utilisateurDto){
        if (utilisateurDto.equals(null)){
            return null;
        }
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(utilisateurDto.getId());
        utilisateur.setCode(utilisateur.getCode());
        utilisateur.setMotDePasse(utilisateur.getMotDePasse());
        utilisateur.setNomUtilisateur(utilisateur.getNomUtilisateur());
        utilisateur.setEmail(utilisateur.getEmail());
        utilisateur.setEtat(utilisateurDto.isEtat());
        return utilisateur;
    }

//    public RolesDto getRoles() {
//        return
//    }
}
