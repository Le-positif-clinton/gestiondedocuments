package com.clinton.gestiondedocuments.Services.Impl;

import com.clinton.gestiondedocuments.Exception.EntityNotFoundException;
import com.clinton.gestiondedocuments.Exception.ErrorCodes;
import com.clinton.gestiondedocuments.Exception.InvalidEntityException;
import com.clinton.gestiondedocuments.Services.EtudiantService;
import com.clinton.gestiondedocuments.dto.CategorieDto;
import com.clinton.gestiondedocuments.dto.EtudiantDto;
import com.clinton.gestiondedocuments.dto.UtilisateurDto;
import com.clinton.gestiondedocuments.model.Etudiant;
import com.clinton.gestiondedocuments.repository.EtudiantRepository;
import com.clinton.gestiondedocuments.validator.EtudiantValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EtudiantServiceImpl implements EtudiantService {
    private EtudiantRepository etudiantRepository;
    @Autowired
    public EtudiantServiceImpl(EtudiantRepository etudiantRepository) {
        this.etudiantRepository = etudiantRepository;
    }

    @Override
    public EtudiantDto save(EtudiantDto dto) {
        List<String> errors = EtudiantValidator.validate(dto);
        if (!errors.isEmpty()){
            log.error("Etudiant is not valide {}",dto);
            throw new InvalidEntityException("L'etudiant n'est pas valide", ErrorCodes.ETUDIANT_NOT_VALIDE,errors);
        }
        return EtudiantDto.fromEntity(
                etudiantRepository.save(EtudiantDto.toEntity(dto))
        );
    }

    @Override
    public EtudiantDto findById(Integer id) {
        if (id.equals(null)){
            log.error("Etudiant ID is null");
            return null;
        }
        return etudiantRepository.findById(id)
                .map(EtudiantDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException(
                        "Aucun etudiant avec l'ID = " + "n'a été trouvé dans la BDD",
                        ErrorCodes.ETUDIANT_NOT_FOUND
                ));
    }

    @Override
    public EtudiantDto findByMatricule(String matricule) {
        if (StringUtils.hasLength(matricule)){
            log.error("Etudiant matricule is null");
            return null;
        }
        return etudiantRepository.findByMatricule(matricule)
                .map(EtudiantDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException(
                        "Aucun Etudiant avec le matricule = " + matricule + "n'a ete trouve dans la BDD",
                        ErrorCodes.ETUDIANT_NOT_FOUND
                ));
    }

    @Override
    public List<EtudiantDto> findAll() {
        return etudiantRepository.findAll().stream()
                .map(EtudiantDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteByMatricule(String matricule) {
        if (!StringUtils.hasLength(matricule)){
            log.error("Etudiant matricule is null");
        }
        etudiantRepository.deleteByMatricule(matricule);

    }

    @Override
    public void delete(Integer id) {
        if (id.equals(null)){
            log.error("Etudiant id is null");
        }
        etudiantRepository.deleteById(id);
    }
}
