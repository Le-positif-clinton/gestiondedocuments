package com.clinton.gestiondedocuments.validator;

import com.clinton.gestiondedocuments.dto.GroupeDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class GroupeValidator {

    public static List<String> validate(GroupeDto groupeDto){
        List<String> errors = new ArrayList<>();
        if (groupeDto.equals(null)){
            errors.add("Vueillez renseigner le nom du groupe");
            errors.add("Vueillez renseigner le code du groupe");
            return errors;
        }
        if (!StringUtils.hasLength(groupeDto.getNom())){
            errors.add("Vueillez renseigner le nom du groupe");
        }
        if (!StringUtils.hasLength(groupeDto.getCode())){
            errors.add("Vueillez renseigner le code du groupe");
        }
        return errors;
    }

}
