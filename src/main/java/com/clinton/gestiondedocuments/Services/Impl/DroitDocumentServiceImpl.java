package com.clinton.gestiondedocuments.Services.Impl;

import com.clinton.gestiondedocuments.Exception.EntityNotFoundException;
import com.clinton.gestiondedocuments.Exception.ErrorCodes;
import com.clinton.gestiondedocuments.Exception.InvalidEntityException;
import com.clinton.gestiondedocuments.Services.DroitDocumentService;
import com.clinton.gestiondedocuments.dto.CategorieDto;
import com.clinton.gestiondedocuments.dto.DroitDocumentDto;
import com.clinton.gestiondedocuments.repository.DroitDocumentRepository;
import com.clinton.gestiondedocuments.validator.CategorieValidator;
import com.clinton.gestiondedocuments.validator.DroitDocumentValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class DroitDocumentServiceImpl implements DroitDocumentService {

    private DroitDocumentRepository droitDocumentRepository;

    @Autowired
    public DroitDocumentServiceImpl(DroitDocumentRepository droitDocumentRepository) {
        this.droitDocumentRepository = droitDocumentRepository;
    }

    @Override
    public DroitDocumentDto save(DroitDocumentDto dto) {
        List<String> errors = DroitDocumentValidator.validate(dto);
        if (!errors.isEmpty()){
            log.error("DroitDocument is not valid {}",dto);
            throw new InvalidEntityException("Le DroitDocument n'est pas valide", ErrorCodes.DROIT_DOCUMENT_NOT_VALIDE, errors);
        }
        return DroitDocumentDto.fromEntity(
                droitDocumentRepository.save(DroitDocumentDto.toEntity(dto))
        );
    }

    @Override
    public DroitDocumentDto findById(Integer id) {

        if (id.equals(null)){
            log.error("DroitDocument ID is null");
            return null;
        }
        return droitDocumentRepository.findById(id)
                .map(DroitDocumentDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucun DroitDocument avec l'ID = " + id + "n'a ete trouve dans la BDD",
                        ErrorCodes.DROIT_DOCUMENT_NOT_FOUND
                ));
    }

    @Override
    public List<DroitDocumentDto> findAll() {
        return droitDocumentRepository.findAll().stream()
                .map(DroitDocumentDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id.equals(null)){
            log.error("DroitDocument ID is null");
            return;
        }
        droitDocumentRepository.deleteById(id);
    }
}
