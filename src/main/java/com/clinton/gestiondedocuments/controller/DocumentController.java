package com.clinton.gestiondedocuments.controller;

import com.clinton.gestiondedocuments.Services.DocumentService;
import com.clinton.gestiondedocuments.controller.api.DocumentApi;
import com.clinton.gestiondedocuments.dto.DocumentDto;
import com.clinton.gestiondedocuments.dto.FichierDto;
import com.clinton.gestiondedocuments.model.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

import static com.clinton.gestiondedocuments.utils.Constents.APP_ROOT;

@RestController
public class DocumentController implements DocumentApi {

    private DocumentService documentService;
    @Autowired
    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @Override
    public DocumentDto save(DocumentDto dto) throws Exception {
        return documentService.save(dto);
    }

    @Override
    public DocumentDto findById(Integer id) throws Exception {
        return documentService.findById(id);
    }


    @Override
    public DocumentService findByTitre(String titre) {
        return documentService.findByTitre(titre);
    }

    @Override
    public List<DocumentDto> findAll() {
        return documentService.findAll();
    }

    @Override
    public void delete(Integer id) {
        documentService.delete(id);
    }
}
