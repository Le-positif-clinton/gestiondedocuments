package com.clinton.gestiondedocuments.Services;

import com.clinton.gestiondedocuments.dto.ActionDto;
import com.clinton.gestiondedocuments.dto.UtilisateurDto;

import java.util.List;

public interface ActionService {

    ActionDto save(ActionDto dto);
    ActionDto findById(Integer id);
    List<ActionDto> findAll();
    void delete(Integer id);

}
