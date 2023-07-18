package com.clinton.gestiondedocuments.Services.Impl;

import com.clinton.gestiondedocuments.Exception.EntityNotFoundException;
import com.clinton.gestiondedocuments.Exception.ErrorCodes;
import com.clinton.gestiondedocuments.Exception.InvalidEntityException;
import com.clinton.gestiondedocuments.Services.DroitService;
import com.clinton.gestiondedocuments.dto.CategorieDto;
import com.clinton.gestiondedocuments.dto.DroitDocumentDto;
import com.clinton.gestiondedocuments.dto.DroitDto;
import com.clinton.gestiondedocuments.repository.DroitRepository;
import com.clinton.gestiondedocuments.validator.CategorieValidator;
import com.clinton.gestiondedocuments.validator.DroitValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class DroitServiceImpl implements DroitService {

    private DroitRepository droitRepository;

    @Autowired
    public DroitServiceImpl(DroitRepository droitRepository) {
        this.droitRepository = droitRepository;
    }

    @Override
    public DroitDto save(DroitDto dto) {
        List<String> errors = DroitValidator.validate(dto);
        if (!errors.isEmpty()){
            log.error("Droit is not valid {}",dto);
            throw new InvalidEntityException("Le Droit n'est pas valide", ErrorCodes.DROIT_NOT_VALIDE, errors);
        }
        return DroitDto.fromEntity(
                droitRepository.save(DroitDto.toEntity(dto))
        );
    }

    @Override
    public DroitDto findById(Integer id) {
        if (id.equals(null)){
            log.error("Droit ID is null");
            return null;
        }
        return droitRepository.findById(id)
                .map(DroitDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucun Droit avec l'ID = " + id + "n'a ete trouve dans la BDD",
                        ErrorCodes.DROIT_NOT_FOUND
                ));
    }

    @Override
    public List<DroitDto> findAll() {
        return droitRepository.findAll().stream()
                .map(DroitDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id.equals(null)){
            log.error("Droit ID is null");
            return;
        }
        droitRepository.deleteById(id);
    }
}
