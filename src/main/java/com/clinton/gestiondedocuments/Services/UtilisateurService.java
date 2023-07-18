package com.clinton.gestiondedocuments.Services;

import com.clinton.gestiondedocuments.dto.ChangerMotDePasseUtilisateurDto;
import com.clinton.gestiondedocuments.dto.UtilisateurDto;
import io.swagger.models.properties.EmailProperty;

import java.util.List;

public interface UtilisateurService {

    UtilisateurDto save(UtilisateurDto dto);
    UtilisateurDto findById(Integer id);
    UtilisateurDto findByEmail(String email);
    List<UtilisateurDto> findAll();
    void delete(Integer id);
    UtilisateurDto changerMotDePasse(ChangerMotDePasseUtilisateurDto dto);

}
