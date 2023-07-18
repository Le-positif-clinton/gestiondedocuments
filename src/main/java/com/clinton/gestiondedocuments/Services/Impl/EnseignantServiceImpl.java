package com.clinton.gestiondedocuments.Services.Impl;

import com.clinton.gestiondedocuments.Exception.EntityNotFoundException;
import com.clinton.gestiondedocuments.Exception.ErrorCodes;
import com.clinton.gestiondedocuments.Exception.InvalidEntityException;
import com.clinton.gestiondedocuments.Services.EnseignantService;
import com.clinton.gestiondedocuments.dto.CategorieDto;
import com.clinton.gestiondedocuments.dto.EnseignantDto;
import com.clinton.gestiondedocuments.repository.EnseignantRepository;
import com.clinton.gestiondedocuments.validator.CategorieValidator;
import com.clinton.gestiondedocuments.validator.EnseignantValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EnseignantServiceImpl implements EnseignantService {

    private EnseignantRepository enseignantRepository;

    public EnseignantServiceImpl(EnseignantRepository enseignantRepository) {
        this.enseignantRepository = enseignantRepository;
    }

    @Override
    public EnseignantDto save(EnseignantDto dto) {
        List<String> errors = EnseignantValidator.validate(dto);
        if (!errors.isEmpty()){
            log.error("Categorie is not valid {}",dto);
            throw new InvalidEntityException("L'Enseignant n'est pas valide", ErrorCodes.ENSEIGNANT_NOT_VALIDE, errors);
        }
        return EnseignantDto.fromEntity(
                enseignantRepository.save(EnseignantDto.toEntity(dto))
        );
    }

    @Override
    public EnseignantDto findById(Integer id) {
        if (id.equals(null)){
            log.error("Enseignant ID is null");
            return null;
        }
        return enseignantRepository.findById(id)
                .map(EnseignantDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucun Enseignant avec l'ID = " + id + "n'a ete trouve dans la BDD",
                        ErrorCodes.ENSEIGNANT_NOT_FOUND
                ));
    }

    @Override
    public List<EnseignantDto> findAll() {
        return enseignantRepository.findAll().stream()
                .map(EnseignantDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id.equals(null)){
            log.error("Enseignant ID is null");
            return;
        }
        enseignantRepository.deleteById(id);
    }
}
