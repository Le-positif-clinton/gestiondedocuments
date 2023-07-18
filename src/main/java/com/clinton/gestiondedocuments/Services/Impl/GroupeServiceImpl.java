package com.clinton.gestiondedocuments.Services.Impl;

import com.clinton.gestiondedocuments.Exception.EntityNotFoundException;
import com.clinton.gestiondedocuments.Exception.ErrorCodes;
import com.clinton.gestiondedocuments.Exception.InvalidEntityException;
import com.clinton.gestiondedocuments.Services.GroupeService;
import com.clinton.gestiondedocuments.Services.UtilisateurService;
import com.clinton.gestiondedocuments.dto.CategorieDto;
import com.clinton.gestiondedocuments.dto.GroupeDto;
import com.clinton.gestiondedocuments.dto.RolesDto;
import com.clinton.gestiondedocuments.dto.UtilisateurDto;
import com.clinton.gestiondedocuments.repository.GroupeRepository;
import com.clinton.gestiondedocuments.repository.RolesRepository;
import com.clinton.gestiondedocuments.validator.CategorieValidator;
import com.clinton.gestiondedocuments.validator.GroupeValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Transactional(rollbackOn = Exception.class)
@Service
@Slf4j
public class GroupeServiceImpl implements GroupeService {

    private GroupeRepository groupeRepository;
    private UtilisateurService utilisateurService;
    private RolesRepository rolesRepository;

    @Autowired
    public GroupeServiceImpl(GroupeRepository groupeRepository, UtilisateurService utilisateurService, RolesRepository rolesRepository) {
        this.groupeRepository = groupeRepository;
        this.utilisateurService = utilisateurService;
        this.rolesRepository = rolesRepository;
    }

    @Override
    public GroupeDto save(GroupeDto dto) {
        List<String> errors = GroupeValidator.validate(dto);
        if (!errors.isEmpty()){
            log.error("Groupe is not valid {}",dto);
            throw new InvalidEntityException("Le Groupe n'est pas valide", ErrorCodes.GROUPE_NOT_VALIDE, errors);
        }
        GroupeDto savedGroupe = GroupeDto.fromEntity(
                groupeRepository.save(GroupeDto.toEntity(dto))
        );

        UtilisateurDto utilisateur = fromGroupe(savedGroupe);
        UtilisateurDto savedUser = utilisateurService.save(utilisateur);


        RolesDto rolesDto = RolesDto.builder()
                .roleName("ADMIN")
                .utilisateur(savedUser)
                .build();

        rolesRepository.save(RolesDto.toEntity(rolesDto));

        return  savedGroupe;
    }


    private UtilisateurDto fromGroupe(GroupeDto dto) {
        return UtilisateurDto.builder()
                .nomUtilisateur(dto.getNom())
//                .email(dto.getEmail())
                .motDePasse(generateRandomPassword())
                .groupe(dto)
                .etat(true)
//                .photo(dto.getPhoto())
                .build();
    }

    private String generateRandomPassword() {
        return "som3R@nd0mP@$$word";
    }


    @Override
    public GroupeDto findById(Integer id) {

        if (id.equals(null)){
            log.error("Categorie ID is null");
            return null;
        }
        return groupeRepository.findById(id)
                .map(GroupeDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucun Groupe avec l'ID = " + id + "n'a ete trouve dans la BDD",
                        ErrorCodes.GROUPE_NOT_FOUND
                ));
    }

    @Override
    public List<GroupeDto> findAll() {

        return groupeRepository.findAll().stream()
                .map(GroupeDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id.equals(null)){
            log.error("Groupe ID is null");
            return;
        }
        groupeRepository.deleteById(id);

    }
}
