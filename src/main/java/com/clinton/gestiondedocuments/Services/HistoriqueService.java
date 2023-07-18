package com.clinton.gestiondedocuments.Services;

import com.clinton.gestiondedocuments.dto.HistoriqueDto;
import com.clinton.gestiondedocuments.dto.UtilisateurDto;

import java.util.List;

public interface HistoriqueService {

    HistoriqueDto save(HistoriqueDto dto);
    HistoriqueDto findById(Integer id);
    List<HistoriqueDto> findAll();
    void delete(Integer id);

}
