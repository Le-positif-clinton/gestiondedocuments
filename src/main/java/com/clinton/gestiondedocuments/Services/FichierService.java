package com.clinton.gestiondedocuments.Services;

import com.clinton.gestiondedocuments.model.Fichier;
import org.springframework.web.multipart.MultipartFile;

public interface FichierService {

    Fichier saveFichier(MultipartFile file) throws Exception;
    Fichier getFichier(String idFichier) throws Exception;
    void delete(String idFichier);

}
