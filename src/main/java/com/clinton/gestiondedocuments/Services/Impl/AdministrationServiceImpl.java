package com.clinton.gestiondedocuments.Services.Impl;

import com.clinton.gestiondedocuments.Exception.EntityNotFoundException;
import com.clinton.gestiondedocuments.Exception.ErrorCodes;
import com.clinton.gestiondedocuments.Exception.InvalidEntityException;
import com.clinton.gestiondedocuments.Services.AdministrationService;
import com.clinton.gestiondedocuments.dto.AdministrationDto;
import com.clinton.gestiondedocuments.dto.CategorieDto;
import com.clinton.gestiondedocuments.repository.AdministrationRepository;
import com.clinton.gestiondedocuments.validator.AdministrationValidator;
import com.clinton.gestiondedocuments.validator.CategorieValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class AdministrationServiceImpl implements AdministrationService {

    private AdministrationRepository administrationRepository;
    @Autowired
    public AdministrationServiceImpl(AdministrationRepository administrationRepository) {
        this.administrationRepository = administrationRepository;
    }

    @Override
    public AdministrationDto save(AdministrationDto dto) {

        List<String> errors = AdministrationValidator.validate(dto);
        if (!errors.isEmpty()){
            log.error("Administration member is not valid {}",dto);
            throw new InvalidEntityException("Le membre d'Administration n'est pas valide", ErrorCodes.ADMINISTRATION_NOT_VALIDE, errors);
        }
        return AdministrationDto.fromEntity(
                administrationRepository.save(AdministrationDto.toEntity(dto))
        );
    }

    @Override
    public AdministrationDto findById(Integer id) {
        if (id.equals(null)){
            log.error("Administration ID is null");
            return null;
        }
        return administrationRepository.findById(id)
                .map(AdministrationDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucun membre de l'Administration avec l'ID = " + id + "n'a ete trouve dans la BDD",
                        ErrorCodes.ADMINISTRATION_NOT_FOUND
                ));
    }

    @Override
    public List<AdministrationDto> findAll() {
        return administrationRepository.findAll().stream()
                .map(AdministrationDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id.equals(null)){
            log.error("Administration ID is null");
            return;
        }
        administrationRepository.deleteById(id);
    }
}
