package com.clinton.gestiondedocuments.Services;

import com.clinton.gestiondedocuments.dto.DroitDocumentDto;
import com.clinton.gestiondedocuments.dto.UtilisateurDto;

import java.util.List;

public interface DroitDocumentService {

    DroitDocumentDto save(DroitDocumentDto dto);
    DroitDocumentDto findById(Integer id);
    List<DroitDocumentDto> findAll();
    void delete(Integer id);

}
