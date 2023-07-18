package com.clinton.gestiondedocuments.validator;

import com.clinton.gestiondedocuments.dto.DocumentDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class DocumentValidator {

    public static List<String> validate(DocumentDto documentDto){
        List<String> errors = new ArrayList<>();
        if (documentDto.equals(null)){
            errors.add("vueillez renseigner le titre du document");
            errors.add("vueillez renseigner l'auteur du document");
            errors.add("vueillez renseigner l'auteur du document");
            errors.add("vueillez renseigner le sujet du document");
            return errors;
        }
        if (!StringUtils.hasLength(documentDto.getTitre())){
            errors.add("vueillez renseigner le titre du document");
        }
        if (!StringUtils.hasLength(documentDto.getAuteur())){
            errors.add("vueillez renseigner l'auteur du document");
        }
        if (!StringUtils.hasLength(documentDto.getAuteur())){
            errors.add("vueillez renseigner l'auteur du document");
        }
        if (!StringUtils.hasLength(documentDto.getSujet())){
            errors.add("vueillez renseigner le sujet du document");
        }
        return errors;
    }

}
