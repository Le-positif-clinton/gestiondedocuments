package com.clinton.gestiondedocuments.Services.Impl;

import com.clinton.gestiondedocuments.Exception.EntityNotFoundException;
import com.clinton.gestiondedocuments.Exception.ErrorCodes;
import com.clinton.gestiondedocuments.Exception.InvalidEntityException;
import com.clinton.gestiondedocuments.Services.UtilisateurService;
import com.clinton.gestiondedocuments.dto.ChangerMotDePasseUtilisateurDto;
import com.clinton.gestiondedocuments.dto.UtilisateurDto;
import com.clinton.gestiondedocuments.model.Utilisateur;
import com.clinton.gestiondedocuments.repository.UtilisateurRepository;
import com.clinton.gestiondedocuments.validator.UtilisateurValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UtilisateurServiceImpl implements UtilisateurService {

    private UtilisateurRepository utilisateurRepository;
    @Autowired
    public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository){
        this.utilisateurRepository = utilisateurRepository;
    }

    @Override
    public UtilisateurDto save(UtilisateurDto dto) {
        List<String> errors = UtilisateurValidator.validate(dto);
        if (!errors.isEmpty()){
            log.error("Utilisateur is not valid {}",dto);
            throw new InvalidEntityException("L'utilisateur n'est pas valide", ErrorCodes.UTILISATEUR_NOT_VALIDE, errors);
        }
        return UtilisateurDto.fromEntity(
                utilisateurRepository.save(UtilisateurDto.toEntity(dto))
        );
    }

    @Override
    public UtilisateurDto findById(Integer id) {
        if (id.equals(null)){
            log.error("Utilisateur ID is null");
            return null;
        }
        return utilisateurRepository.findById(id)
                .map(UtilisateurDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException(
                        "Aucun etudiant avec l'ID = " + "n'a été trouvé dans la BDD",
                        ErrorCodes.UTILISATEUR_NOT_FOUND
                ));
    }

    @Override
    public UtilisateurDto findByEmail(String email) {
        return utilisateurRepository.findUtilisateurByEmail(email)
                .map(UtilisateurDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucun utilisateur avec l'email = "+ email + "n'a etet trouve dans la BDD",
                ErrorCodes.UTILISATEUR_NOT_FOUND
        ));
    }

    @Override
    public List<UtilisateurDto> findAll() {

        return utilisateurRepository.findAll().stream()
                .map(UtilisateurDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
    if (id.equals(null)){
        log.error("Utilisateur ID is null");
        return;
    }
    utilisateurRepository.deleteById(id);
    }

    @Override
    public UtilisateurDto changerMotDePasse(ChangerMotDePasseUtilisateurDto dto) {
        validate(dto);
        Optional<Utilisateur> utilisateurOptional = utilisateurRepository.findById(dto.getId());
        if (utilisateurOptional.isEmpty()){
            log.warn("Aucun utilisateurOptional n'a été trouver avec l'ID"+ dto.getId());
            throw new EntityNotFoundException("Aucun utilisateurOptional n'a été trouver avec l'ID"+ dto.getId(), ErrorCodes.UTILISATEUR_NOT_FOUND);
        }

        Utilisateur utilisateur = utilisateurOptional.get();
        utilisateur.setMotDePasse(dto.getMotDePasse());

        return UtilisateurDto.fromEntity(
                utilisateurRepository.save(utilisateur)
        );
    }
    private void validate(ChangerMotDePasseUtilisateurDto dto){
        if (dto == null){
           log.warn("impossible de modifier le mot de passe avec un objet NULL");
           throw new InvalidEntityException("Aucune information n'a ete fourni pour changer le mot de passe",ErrorCodes.UTILISATEUR_CHANGE_PASSWORD_NOT_VALID);
       }
       if (dto.getId() == null){
           log.warn("impossible de modifier le mot de passe avec un ID NULL");
           throw new InvalidEntityException("ID utilisateur NULL: impossible de modifier le mot de passe",ErrorCodes.UTILISATEUR_CHANGE_PASSWORD_NOT_VALID);
       }
        if (!StringUtils.hasLength(dto.getMotDePasse()) || !StringUtils.hasLength(dto.getConfirmMotDepasse())){
            log.warn("impossible de modifier le mot de passe avec un mot de passe vide");
            throw new InvalidEntityException("mot de passe utilisateur NULL: impossible de modifier le mot de passe",ErrorCodes.UTILISATEUR_CHANGE_PASSWORD_NOT_VALID);
        }
        if (!dto.getMotDePasse().equals(dto.getConfirmMotDepasse())){
            log.warn("impossible de modifier le mot de passe avec deux mots de passe diferents");
            throw new InvalidEntityException("mot de passe utilisateur non conforme : impossible de modifier le mot de passe",ErrorCodes.UTILISATEUR_CHANGE_PASSWORD_NOT_VALID);
        }

    }

}
