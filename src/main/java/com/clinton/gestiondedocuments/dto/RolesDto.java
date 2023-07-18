package com.clinton.gestiondedocuments.dto;

import com.clinton.gestiondedocuments.model.Roles;
import lombok.Builder;
import lombok.Data;

import javax.management.relation.Role;

@Data
@Builder
public class RolesDto {
    private Integer id;

    private String roleName;

    private UtilisateurDto utilisateur;
    private Integer idProfil;

    public static RolesDto fromEntity(Roles roles){
        if (roles.equals(null)){
            return null;
        }
        return RolesDto.builder()
                .id(roles.getId())
                .roleName(roles.getRoleName())
                .utilisateur(UtilisateurDto.fromEntity(roles.getUtilisateur()))
                .build();
    }
    public static Roles toEntity(RolesDto rolesDto){
        if (rolesDto.equals(null)){
            return null;
        }
        Roles roles = new Roles();
        roles.setId(rolesDto.getId());
        roles.setRoleName(roles.getRoleName());
        roles.setUtilisateur(UtilisateurDto.toEntity(rolesDto.getUtilisateur()));

        return roles;
    }

}
