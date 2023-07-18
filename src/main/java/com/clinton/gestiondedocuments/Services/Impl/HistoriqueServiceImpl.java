package com.clinton.gestiondedocuments.Services.Impl;

import com.clinton.gestiondedocuments.Exception.EntityNotFoundException;
import com.clinton.gestiondedocuments.Exception.ErrorCodes;
import com.clinton.gestiondedocuments.Exception.InvalidEntityException;
import com.clinton.gestiondedocuments.Services.HistoriqueService;
import com.clinton.gestiondedocuments.dto.CategorieDto;
import com.clinton.gestiondedocuments.dto.HistoriqueDto;
import com.clinton.gestiondedocuments.repository.HistoriqueRepository;
import com.clinton.gestiondedocuments.validator.CategorieValidator;
import com.clinton.gestiondedocuments.validator.HistoriqueValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class HistoriqueServiceImpl implements HistoriqueService {

    private HistoriqueRepository historiqueRepository;

    @Autowired
    public HistoriqueServiceImpl(HistoriqueRepository historiqueRepository) {
        this.historiqueRepository = historiqueRepository;
    }

    @Override
    public HistoriqueDto save(HistoriqueDto dto) {
        List<String> errors = HistoriqueValidator.validate(dto);
        if (!errors.isEmpty()){
            log.error("Historique is not valid {}",dto);
            throw new InvalidEntityException("L'Historique' n'est pas valide", ErrorCodes.HISTORIQUE_NOT_VALIDE, errors);
        }
        return HistoriqueDto.fromEntity(
                historiqueRepository.save(HistoriqueDto.toEntity(dto))
        );
    }

    @Override
    public HistoriqueDto findById(Integer id) {
        if (id.equals(null)){
            log.error("Categorie ID is null");
            return null;
        }
        return historiqueRepository.findById(id)
                .map(HistoriqueDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucun Historique avec l'ID = " + id + "n'a ete trouve dans la BDD",
                        ErrorCodes.HISTORIQUE_NOT_FOUND
                ));
    }

    @Override
    public List<HistoriqueDto> findAll() {
        return historiqueRepository.findAll().stream()
                .map(HistoriqueDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id.equals(null)){
            log.error("Historique ID is null");
            return;
        }
        historiqueRepository.deleteById(id);

    }
}
