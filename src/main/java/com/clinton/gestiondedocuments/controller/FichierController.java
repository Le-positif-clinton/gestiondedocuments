package com.clinton.gestiondedocuments.controller;

import com.clinton.gestiondedocuments.Services.FichierService;
import com.clinton.gestiondedocuments.controller.api.FichierApi;
import com.clinton.gestiondedocuments.dto.FichierDto;
import com.clinton.gestiondedocuments.model.Fichier;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import static com.clinton.gestiondedocuments.utils.Constents.APP_ROOT;

@RestController
public class FichierController implements FichierApi {

    FichierService fichierService;

    public FichierController(FichierService fichierService) {
        this.fichierService = fichierService;
    }

    @Override
    public FichierDto upload(MultipartFile file) throws Exception {
        Fichier fichier = null;
        String url = "";
        fichier = fichierService.saveFichier(file);
        url = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(APP_ROOT+ "/download/")
                .path(fichier.getId())
                .toUriString();
        return new FichierDto(fichier.getId(),
                fichier.getNom(),
                url,
                file.getContentType(),
                fichier.getDocument(),
                file.getSize());
    }

    @Override
    public ResponseEntity<Resource> download(String idFichier) throws Exception {
        Fichier fichier = fichierService.getFichier(idFichier);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(fichier.getType()))
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "fichier; nom=\""+fichier.getNom() +"\"")
                .body(new ByteArrayResource(fichier.getDonnee()));
    }

    @Override
    public void delete(String id) {
        fichierService.delete(id);
    }
}
