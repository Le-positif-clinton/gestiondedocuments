package com.clinton.gestiondedocuments.Services;

import com.clinton.gestiondedocuments.dto.AdministrationDto;
import com.clinton.gestiondedocuments.dto.UtilisateurDto;

import java.util.List;

public interface AdministrationService {

    AdministrationDto save(AdministrationDto dto);
    AdministrationDto findById(Integer id);
    List<AdministrationDto> findAll();
    void delete(Integer id);

}
