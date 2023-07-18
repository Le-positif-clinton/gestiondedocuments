package com.clinton.gestiondedocuments.Services;

import com.clinton.gestiondedocuments.dto.CategorieDto;
import com.clinton.gestiondedocuments.dto.UtilisateurDto;

import java.util.List;

public interface CategorieService {

    CategorieDto save(CategorieDto dto);
    CategorieDto findById(Integer id);
    CategorieDto findByCode(String code);
    List<CategorieDto> findAll();
    void delete(Integer id);

}
