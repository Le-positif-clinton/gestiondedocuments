package com.clinton.gestiondedocuments.Services;

import com.clinton.gestiondedocuments.dto.EnseignantDto;
import com.clinton.gestiondedocuments.dto.UtilisateurDto;

import java.util.List;

public interface EnseignantService {

    EnseignantDto save(EnseignantDto dto);
    EnseignantDto findById(Integer id);
    List<EnseignantDto> findAll();
    void delete(Integer id);

}
