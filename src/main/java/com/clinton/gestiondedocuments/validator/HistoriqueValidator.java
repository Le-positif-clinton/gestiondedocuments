package com.clinton.gestiondedocuments.validator;

import com.clinton.gestiondedocuments.dto.HistoriqueDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class HistoriqueValidator {

    public static List<String> validate(HistoriqueDto historiqueDto){
        List<String> errors = new ArrayList<>();
        if (historiqueDto.equals(null) || historiqueDto.getDate().equals(null)){
            errors.add("vueillez renseignez la date de l'historique");
        }

        return errors;
    }

}
