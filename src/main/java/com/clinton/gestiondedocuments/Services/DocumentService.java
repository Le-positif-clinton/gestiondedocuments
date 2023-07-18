package com.clinton.gestiondedocuments.Services;

import com.clinton.gestiondedocuments.dto.DocumentDto;
import com.clinton.gestiondedocuments.model.Document;
import com.clinton.gestiondedocuments.model.Fichier;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface DocumentService {

    DocumentDto save( DocumentDto dto)throws Exception;
    DocumentDto findById(Integer id) throws Exception;
    DocumentService findByTitre(String titre);
    List<DocumentDto> findAll();
    void delete(Integer id);

}
