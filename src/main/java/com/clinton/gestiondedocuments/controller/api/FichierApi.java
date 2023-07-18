package com.clinton.gestiondedocuments.controller.api;

import com.clinton.gestiondedocuments.dto.FichierDto;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import static com.clinton.gestiondedocuments.utils.Constents.APP_ROOT;

public interface FichierApi {

    @PostMapping(APP_ROOT+ "/upload")
    FichierDto upload(@RequestParam("file")MultipartFile file) throws Exception;
    @GetMapping(APP_ROOT+ "/download/{idFichier}")
    ResponseEntity<Resource> download(@PathVariable String idFichier) throws Exception;

    @DeleteMapping(APP_ROOT+ "/fichiers/delete/{idFichier}")
    void delete(@PathVariable("idFichier") String id);
}
