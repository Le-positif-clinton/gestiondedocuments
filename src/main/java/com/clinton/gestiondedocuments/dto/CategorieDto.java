package com.clinton.gestiondedocuments.dto;

import com.clinton.gestiondedocuments.model.Categorie;
import com.clinton.gestiondedocuments.model.Document;
import com.fasterxml.jackson.annotation.JsonIgnore;
//import jakarta.persistence.Column;
//import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CategorieDto {
    private Integer id;

    private String code;

    private int numCategorie;

    private String nom;

    private String description ;
    @JsonIgnore
    private List<DocumentDto> documentDtos;
    public static CategorieDto fromEntity(Categorie categorie){
        if (categorie.equals(null)) {
            return null;
        }
        return CategorieDto.builder()
                .id(categorie.getId())
                .numCategorie(categorie.getNumCategorie())
                .nom(categorie.getNom())
                .description(categorie.getDescription())
                .build();
    }
    public static Categorie toEntity(CategorieDto categorieDto){
        if (categorieDto.equals(null)){
            return null;
        }
        Categorie categorie = new Categorie();
        categorie.setId(categorieDto.getId());
        categorie.setNumCategorie(categorieDto.getNumCategorie());
        categorie.setNom(categorieDto.getNom());
        categorie.setDescription(categorieDto.getDescription());

        return categorie;
    }

}
