package com.clinton.gestiondedocuments.Services.Impl;

import com.clinton.gestiondedocuments.Exception.EntityNotFoundException;
import com.clinton.gestiondedocuments.Exception.ErrorCodes;
import com.clinton.gestiondedocuments.Exception.InvalidEntityException;
import com.clinton.gestiondedocuments.Services.DocumentService;
import com.clinton.gestiondedocuments.dto.DocumentDto;
import com.clinton.gestiondedocuments.model.Document;
import com.clinton.gestiondedocuments.model.Fichier;
import com.clinton.gestiondedocuments.repository.DocumentRepository;
import com.clinton.gestiondedocuments.validator.DocumentValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class DocumentServiceImpl implements DocumentService {

    private DocumentRepository documentRepository;
    @Autowired
    public DocumentServiceImpl(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    @Override
    public DocumentDto save(DocumentDto dto) throws Exception {

        List<String> errors = DocumentValidator.validate(dto);
        if (!errors.isEmpty()){
            log.error("Document is not valid {}");
            throw new InvalidEntityException("Le Document n'est pas valide voir ", ErrorCodes.DOCUMENT_NOT_VALIDE, errors);
        }
        return DocumentDto.fromEntity(documentRepository.save(DocumentDto.toEntity(dto)));
    }


    @Override
    public DocumentDto findById(Integer id){
        if(id.equals(null)){
            log.error("Article ID is nul");
            return null;
        }
        Optional<Document> document = documentRepository.findById(id);


        return Optional.of(DocumentDto.fromEntity(document.get())).orElseThrow(() -> new EntityNotFoundException("Aucun document avec l'ID "+id+" n'a été trouvé dans la BDD",
                ErrorCodes.DOCUMENT_NOT_FOUND)
        );
    }

    @Override
    public DocumentService findByTitre(String titre) {
        if (StringUtils.hasLength(titre)){
            log.error("Document CODE is null");
            return null;
        }
        return (DocumentService) documentRepository.findByTitre(titre)
                .map(DocumentDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException(
                        "Aucun Document avec le CODE = " + titre + "n'a ete trouve dans la BDD",
                        ErrorCodes.DOCUMENT_NOT_FOUND
                ));
    }

    @Override
    public List<DocumentDto> findAll() {
        return documentRepository.findAll().stream()
                .map(DocumentDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id.equals(null)){
            log.error("Document ID is nul");
            return;
        }
    documentRepository.deleteById(id);
    }
}
