package com.clinton.gestiondedocuments.Services.Impl;

import com.clinton.gestiondedocuments.Exception.EntityNotFoundException;
import com.clinton.gestiondedocuments.Exception.ErrorCodes;
import com.clinton.gestiondedocuments.Exception.InvalidEntityException;
import com.clinton.gestiondedocuments.Services.CategorieService;
import com.clinton.gestiondedocuments.dto.CategorieDto;
import com.clinton.gestiondedocuments.repository.CategorieRepository;
import com.clinton.gestiondedocuments.validator.CategorieValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CategorieServiceImpl implements CategorieService {

    private CategorieRepository categorieRepository;
    @Autowired
    public CategorieServiceImpl(CategorieRepository categorieRepository){
        this.categorieRepository = categorieRepository;
    }

    @Override
    public CategorieDto save(CategorieDto dto) {
        List<String> errors = CategorieValidator.validate(dto);
        if (!errors.isEmpty()){
            log.error("Categorie is not valid {}",dto);
            throw new InvalidEntityException("La categorie n'est pas valide", ErrorCodes.CATEGORIE_NOT_VALIDE, errors);
        }
        return CategorieDto.fromEntity(
                categorieRepository.save(CategorieDto.toEntity(dto))
        );
    }

    @Override
    public CategorieDto findById(Integer id) {
        if (id.equals(null)){
            log.error("Categorie ID is null");
            return null;
        }
        return categorieRepository.findById(id)
                .map(CategorieDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucune categorie avec l'ID = " + id + "n'a ete trouve dans la BDD",
                        ErrorCodes.CATEGORIE_NOT_FOUND
                ));
    }

    public CategorieDto findByCode(String code){
        if (StringUtils.hasLength(code)){
            log.error("Categorie CODE is null");
            return null;
        }
        return categorieRepository.findCategorieByCode(code)
                .map(CategorieDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException(
                        "Aucune categorie avec le CODE = " + code + "n'a ete trouve dans la BDD",
                        ErrorCodes.CATEGORIE_NOT_FOUND
                ));
    }

    @Override
    public List<CategorieDto> findAll() {
        return categorieRepository.findAll().stream()
                .map(CategorieDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id.equals(null)){
            log.error("Categorie ID is null");
            return;
        }
        categorieRepository.deleteById(id);
    }
}
