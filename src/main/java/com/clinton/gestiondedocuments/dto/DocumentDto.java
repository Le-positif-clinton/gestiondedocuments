package com.clinton.gestiondedocuments.dto;

import com.clinton.gestiondedocuments.model.Document;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.IOException;
import java.time.Instant;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class DocumentDto {
    private Integer id;

    private String titre;

    private String auteur;

    private String dernierContributeur;

    private String description;

    private String sujet;

    private Instant creationDate;

    private Instant lastModifieDate;

    @JsonIgnore
    private CategorieDto categorieDto;
    @JsonIgnore
    private List<DroitDocumentDto> droitDocumentDtos;
    @JsonIgnore
    private HistoriqueDto historiqueDto;
    @JsonIgnore
    private FichierDto fichier;


    public static Document toEntity(DocumentDto documentDto) throws IOException {
        if (documentDto.equals(null)){
            return null;
        }
        Document document = new Document();
        document.setId(documentDto.getId());
        document.setTitre(documentDto.getTitre());
        document.setAuteur(documentDto.getAuteur());
        document.setDernierContributeur(documentDto.getDernierContributeur());
        document.setDescription(documentDto.getDescription());
        document.setSujet(documentDto.getSujet());
        document.setCreationDate(documentDto.getCreationDate());
        document.setLastModifieDate(documentDto.getLastModifieDate());

        return document;

    }
    public static DocumentDto fromEntity(Document document){
        if (document.equals(null)){
            return null;
        }
        return DocumentDto.builder()
                .id(document.getId())
                .titre(document.getTitre())
                .auteur(document.getAuteur())
                .dernierContributeur(document.getDernierContributeur())
                .description(document.getDescription())
                .sujet(document.getSujet())
                .creationDate(document.getCreationDate())
                .lastModifieDate(document.getLastModifieDate())
                .build();
    }
}
