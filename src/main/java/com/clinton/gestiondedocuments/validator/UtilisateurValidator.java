package com.clinton.gestiondedocuments.validator;

import com.clinton.gestiondedocuments.dto.UtilisateurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class UtilisateurValidator {

    public static List<String> validate(UtilisateurDto utilisateurDto){
        List<String> errors = new ArrayList<>();
        if (utilisateurDto.equals(null)){
            errors.add("veuillez renseigner le code de l'utilisateur");
            errors.add("veuillez renseigner le nom d'utilisateur");
            errors.add("veuillez renseigner l'email d'utilisateur");
        }
        if (!StringUtils.hasLength(utilisateurDto.getCode())){
            errors.add("veuillez renseigner le code de l'utilisateur");
        }
        if (!StringUtils.hasLength(utilisateurDto.getNomUtilisateur())){
            errors.add("veuillez renseigner le nom d'utilisateur");
        }
        if (!StringUtils.hasLength(utilisateurDto.getEmail())){
            errors.add("veuillez renseigner l'email d'utilisateur");
        }
        return errors;
    }

}
