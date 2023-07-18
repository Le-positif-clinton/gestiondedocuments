package com.clinton.gestiondedocuments.validator;


import com.clinton.gestiondedocuments.dto.AdministrationDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class AdministrationValidator {
    
    public static List<String> validate(AdministrationDto administrationDto){
        List<String> errors = new ArrayList<>();
        if (administrationDto.equals(null)){
            errors.add("vueillez renseigner le nom du menbre de l'administration");
            errors.add("vueillez renseigner le prenom du menbre de l'administration");
            errors.add("vueillez renseigner l'email du menbre de l'administration");
            errors.add("vueillez renseigner le role du menbre de l'administration");
            return errors;
        }
        if (!StringUtils.hasLength(administrationDto.getNom())){
            errors.add("vueillez renseigner le nom du menbre de l'administration");
        }
        if (!StringUtils.hasLength(administrationDto.getPrenom())){
            errors.add("vueillez renseigner le prenom du menbre de l'administration");
        }
        if (!StringUtils.hasLength(administrationDto.getEmail())){
            errors.add("vueillez renseigner l'email du menbre de l'administration");
        }
        if (!StringUtils.hasLength(administrationDto.getRole())){
            errors.add("vueillez renseigner le role du menbre de l'administration");
        }
        return errors;

    }
    
}
