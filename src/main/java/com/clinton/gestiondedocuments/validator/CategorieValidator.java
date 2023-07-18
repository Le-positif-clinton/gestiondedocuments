package com.clinton.gestiondedocuments.validator;

import com.clinton.gestiondedocuments.dto.CategorieDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CategorieValidator {

    public static List<String> validate(CategorieDto categorieDto){
        List<String> errors = new ArrayList<>();

        if ((categorieDto.equals(null) || !StringUtils.hasLength(categorieDto.getNom()))){
            errors.add("veuillez renseigner le nom de la categorie");
        }

        return errors;
    }

}
