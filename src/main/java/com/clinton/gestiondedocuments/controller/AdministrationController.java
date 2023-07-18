package com.clinton.gestiondedocuments.controller;

import com.clinton.gestiondedocuments.Services.AdministrationService;
import com.clinton.gestiondedocuments.controller.api.AdministrationApi;
import com.clinton.gestiondedocuments.dto.AdministrationDto;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdministrationController implements AdministrationApi {

    private AdministrationService administrationService;

    public AdministrationController(AdministrationService administrationService) {
        this.administrationService = administrationService;
    }

    @Override
    public AdministrationDto save(AdministrationDto dto) {
        return administrationService.save(dto);
    }

    @Override
    public AdministrationDto findById(Integer id) {
        return administrationService.findById(id);
    }

    @Override
    public List<AdministrationDto> findAll() {
        return administrationService.findAll();
    }

    @Override
    public void delete(Integer id) {
        administrationService.delete(id);
    }
}
