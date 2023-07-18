package com.clinton.gestiondedocuments.validator;

import com.clinton.gestiondedocuments.dto.EnseignantDto;
import com.clinton.gestiondedocuments.dto.EtudiantDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class EnseignantValidator {
    public static List<String> validate(EnseignantDto enseignantDto){
        List<String> errors = new ArrayList<>();
        if (enseignantDto.equals(null)){
            errors.add("veuillez renseiner le nom de l'enseignant");
            errors.add("veuillez renseiner le prenom de l'enseignant");
            errors.add("veuillez renseiner l'email de l'enseignant");
            errors.add("veuillez renseiner la matiere de l'enseignant");
            return errors;
        }
        if(!StringUtils.hasLength(enseignantDto.getNom())){
            errors.add("veuillez renseiner le nom de l'enseignant");
        }
        if(!StringUtils.hasLength(enseignantDto.getPrenom())){
            errors.add("veuillez renseiner le prenom de l'enseignant");
        }
        if(!StringUtils.hasLength(enseignantDto.getEmail())){
            errors.add("veuillez renseiner l'email de l'enseignant");
        }
        if(!StringUtils.hasLength(enseignantDto.getMatiere())){
            errors.add("veuillez renseiner la matiere de l'enseignant");
        }
        return errors;
    }
}
