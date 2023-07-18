package com.clinton.gestiondedocuments.Services;

import com.clinton.gestiondedocuments.dto.DroitDto;
import com.clinton.gestiondedocuments.dto.UtilisateurDto;

import java.util.List;

public interface DroitService {

    DroitDto save(DroitDto dto);
    DroitDto findById(Integer id);
    List<DroitDto> findAll();
    void delete(Integer id);

}
