package com.clinton.gestiondedocuments.validator;

import com.clinton.gestiondedocuments.dto.EtudiantDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class EtudiantValidator {
    public static List<String> validate(EtudiantDto etudiantDto){
        List<String> errors = new ArrayList<>();
        if (etudiantDto.equals(null)){
            errors.add("veuillez renseiner le matricule de l'étudiant");
            errors.add("veuillez renseiner le nom de l'étudiant");
            errors.add("veuillez renseiner le prenom de l'étudiant");
            errors.add("veuillez renseiner l'email de l'étudiant");
            errors.add("veuillez renseiner le cycle de l'étudiant");
            errors.add("veuillez renseiner le niveau de l'étudiant");
            return errors;
        }
        if(!StringUtils.hasLength(etudiantDto.getMatricule())){
            errors.add("veuillez renseiner le matricule de l'étudiant");
        }
        if(!StringUtils.hasLength(etudiantDto.getNom())){
            errors.add("veuillez renseiner le nom de l'étudiant");
        }
        if(!StringUtils.hasLength(etudiantDto.getPrenom())){
            errors.add("veuillez renseiner le prenom de l'étudiant");
        }
        if(!StringUtils.hasLength(etudiantDto.getEmail())){
            errors.add("veuillez renseiner l'email de l'étudiant");
        }
        if(!StringUtils.hasLength(etudiantDto.getCycle())){
            errors.add("veuillez renseiner le cycle de l'étudiant");
        }
        if(etudiantDto.getNiveau() == 0){
            errors.add("veuillez renseiner le niveau de l'étudiant");
        }
        return errors;
    }
}
