package com.clinton.gestiondedocuments.dto;

import com.clinton.gestiondedocuments.model.Document;
import com.clinton.gestiondedocuments.model.DroitDocument;
import com.clinton.gestiondedocuments.model.Groupe;
import com.fasterxml.jackson.annotation.JsonIgnore;
//import jakarta.persistence.Column;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class DroitDocumentDto {
    private Integer id;
    
    private String nomDocument;
    @JsonIgnore
    
    private List<GroupeDto> groupeDtos;

    private DocumentDto documentDto;

    public static DroitDocumentDto fromEntity(DroitDocument droitDocument){
        if (droitDocument.equals(null)){
            return null;
        }
        return DroitDocumentDto.builder()
                .id(droitDocument.getId())
                .nomDocument(droitDocument.getNomDocument())
                .build();
    }
    public static DroitDocument toEntity(DroitDocumentDto droitDocumentDto){
        if (droitDocumentDto.equals(null)){
            return null;
        }
        DroitDocument droitDocument = new DroitDocument();
        droitDocument.setId(droitDocumentDto.getId());
        droitDocument.setNomDocument(droitDocumentDto.getNomDocument());
        return droitDocument;
    }
}
