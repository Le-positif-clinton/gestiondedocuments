package com.clinton.gestiondedocuments.dto;

import com.clinton.gestiondedocuments.model.Document;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class FichierDto {
    private String id;
    private String nom;
    private String url;
    private String type;
    private long taille;
    @JsonIgnore
    private Document documentDto;

    public FichierDto(String id, String nom, String url, String contentType, Document document, long size) {
        this.nom=nom;
        this.id=id;
        this.type=contentType;
        this.taille=size;
        this.documentDto=document;
    }


//    public static Fichier toEntity(FichierDto fichierDto, MultipartFile file){
//        Fichier fichier = new Fichier();
//        fichier.setId(fichierDto.getId());
//        fichier.setNom(file.getName());
//        fichier.getTaille(file.getSize());
//        fichier.getUrl(file.getOriginalFilename());
//
//        return fichier;
//    }

}
