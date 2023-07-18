package com.clinton.gestiondedocuments.controller;

import com.clinton.gestiondedocuments.Services.DroitService;
import com.clinton.gestiondedocuments.controller.api.DroitApi;
import com.clinton.gestiondedocuments.dto.DroitDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DroitController implements DroitApi {

    private DroitService droitService;

    @Autowired
    public DroitController(DroitService droitService) {
        this.droitService = droitService;
    }

    @Override
    public DroitDto save(DroitDto dto) {
        return droitService.save(dto);
    }

    @Override
    public DroitDto findById(Integer id) {
        return droitService.findById(id);
    }

    @Override
    public List<DroitDto> findAll() {
        return droitService.findAll();
    }

    @Override
    public void delete(Integer id) {
        droitService.delete(id);
    }
}
