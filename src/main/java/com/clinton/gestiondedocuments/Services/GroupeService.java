package com.clinton.gestiondedocuments.Services;

import com.clinton.gestiondedocuments.dto.GroupeDto;
import com.clinton.gestiondedocuments.dto.UtilisateurDto;

import java.util.List;

public interface GroupeService {

    GroupeDto save(GroupeDto dto);
    GroupeDto findById(Integer id);
    List<GroupeDto> findAll();
    void delete(Integer id);

}
