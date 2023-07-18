package com.clinton.gestiondedocuments.Services;

import com.clinton.gestiondedocuments.dto.EtudiantDto;
import com.clinton.gestiondedocuments.dto.UtilisateurDto;

import java.util.List;

public interface EtudiantService {

    EtudiantDto save(EtudiantDto dto);
    EtudiantDto findById(Integer id);
    EtudiantDto findByMatricule(String  matricule);
    List<EtudiantDto> findAll();
    void deleteByMatricule(String  id);
    void delete(Integer id);

}
