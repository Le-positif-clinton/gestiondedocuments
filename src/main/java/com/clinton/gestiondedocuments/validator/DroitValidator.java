package com.clinton.gestiondedocuments.validator;

import com.clinton.gestiondedocuments.dto.DroitDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class DroitValidator {

    public static List<String> validate(DroitDto droitDto){
        List<String> errors = new ArrayList<>();
        if (droitDto.equals(null)){
            return errors;
        }
        return errors;
    }

}
