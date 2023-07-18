package com.clinton.gestiondedocuments.controller;

import com.clinton.gestiondedocuments.Services.GroupeService;
import com.clinton.gestiondedocuments.controller.api.GroupeApi;
import com.clinton.gestiondedocuments.dto.GroupeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GroupeController implements GroupeApi {

    private GroupeService groupeService;

    @Autowired
    public GroupeController(GroupeService groupeService) {
        this.groupeService = groupeService;
    }

    @Override
    public GroupeDto save(GroupeDto dto) {
        return groupeService.save(dto);
    }

    @Override
    public GroupeDto findById(Integer id) {
        return groupeService.findById(id);
    }

    @Override
    public List<GroupeDto> findAll() {
        return groupeService.findAll();
    }

    @Override
    public void delete(Integer id) {
        groupeService.delete(id);
    }
}
