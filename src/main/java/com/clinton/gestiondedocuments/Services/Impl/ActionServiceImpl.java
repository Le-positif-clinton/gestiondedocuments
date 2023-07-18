package com.clinton.gestiondedocuments.Services.Impl;

import com.clinton.gestiondedocuments.Exception.EntityNotFoundException;
import com.clinton.gestiondedocuments.Exception.ErrorCodes;
import com.clinton.gestiondedocuments.Exception.InvalidEntityException;
import com.clinton.gestiondedocuments.Services.ActionService;
import com.clinton.gestiondedocuments.dto.ActionDto;
import com.clinton.gestiondedocuments.repository.ActionRepository;
import com.clinton.gestiondedocuments.validator.ActionValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ActionServiceImpl implements ActionService {

    private ActionRepository actionRepository;

    @Autowired
    public ActionServiceImpl(ActionRepository actionRepository) {
        this.actionRepository = actionRepository;
    }

    @Override
    public ActionDto save(ActionDto dto) {
        List<String> errors = ActionValidator.validate(dto);
        if (!errors.isEmpty()){
            log.error("Action is not valid {}",dto);
            throw new InvalidEntityException("L'Action' n'est pas valide", ErrorCodes.ACTION_NOT_VALIDE, errors);
        }
        return ActionDto.fromEntity(
                actionRepository.save(ActionDto.toEntity(dto))
        );
    }

    @Override
    public ActionDto findById(Integer id) {
        if (id.equals(null)){
            log.error("Action ID is null");
            return null;
        }
        return actionRepository.findById(id)
                .map(ActionDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucune Action avec l'ID = " + id + "n'a ete trouve dans la BDD",
                        ErrorCodes.ACTION_NOT_FOUND
                ));
    }

    @Override
    public List<ActionDto> findAll() {
        return actionRepository.findAll().stream()
                .map(ActionDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id.equals(null)){
            log.error("Action ID is null");
            return;
        }
        actionRepository.deleteById(id);

    }
}
