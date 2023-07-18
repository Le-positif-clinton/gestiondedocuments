package com.clinton.gestiondedocuments.validator;

import com.clinton.gestiondedocuments.dto.ActionDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ActionValidator {

    public static List<String> validate(ActionDto actionDto){
        List<String> errors = new ArrayList<>();
        if (actionDto.equals(null)){
            errors.add("veuillez renseigner le numero d'action");
        }
        return errors;
    }

}
