package com.clinton.gestiondedocuments.Services.Impl;

import com.clinton.gestiondedocuments.Services.FichierService;
import com.clinton.gestiondedocuments.model.Fichier;
import com.clinton.gestiondedocuments.repository.FichierRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FichierServiceImpl implements FichierService {
    private FichierRepository fichierRepository;

    public FichierServiceImpl(FichierRepository fichierRepository) {
        this.fichierRepository = fichierRepository;
    }

    @Override
    public Fichier saveFichier(MultipartFile file) throws Exception {
        String nomFichier = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            if (nomFichier.contains("..")){
                throw new Exception("le nom du fichier contient un path invalide: "+nomFichier);
            }
            Fichier fichier = new Fichier(nomFichier, file.getContentType(),file.getBytes());
            return fichierRepository.save(fichier);
        }catch (Exception e){
            throw new Exception("impossible de sauvegarder le fichier: "+nomFichier);
        }
    }

    @Override
    public Fichier getFichier(String idFichier) throws Exception {
        return fichierRepository
                .findById(idFichier)
                .orElseThrow(() -> new Exception("ce fichier avec l'ID "+idFichier+" n'existe pas"));
    }

    @Override
    public void delete(String idFichier) {
        fichierRepository.deleteById(idFichier);
    }
}
