package com.clinton.gestiondedocuments.validator;

import com.clinton.gestiondedocuments.dto.DroitDocumentDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class DroitDocumentValidator {

    public static List<String> validate(DroitDocumentDto dto){
        List<String> errors = new ArrayList<>();
        if (dto.equals(null) || (!StringUtils.hasLength(dto.getNomDocument()))){
            errors.add("vueillez renseigner le nom dudocument conserné");
        }

        return errors;
    }

}
