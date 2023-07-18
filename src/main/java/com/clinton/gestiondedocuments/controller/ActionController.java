package com.clinton.gestiondedocuments.controller;

import com.clinton.gestiondedocuments.Services.ActionService;
import com.clinton.gestiondedocuments.controller.api.ActionApi;
import com.clinton.gestiondedocuments.dto.ActionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ActionController implements ActionApi {

    private ActionService actionService;

    @Autowired
    public ActionController(ActionService actionService) {
        this.actionService = actionService;
    }

    @Override
    public ActionDto save(ActionDto dto) {
        return actionService.save(dto);
    }

    @Override
    public ActionDto findById(Integer id) {
        return actionService.findById(id);
    }

    @Override
    public List<ActionDto> findAll() {
        return actionService.findAll();
    }

    @Override
    public void delete(Integer id) {
        actionService.delete(id);
    }
}
