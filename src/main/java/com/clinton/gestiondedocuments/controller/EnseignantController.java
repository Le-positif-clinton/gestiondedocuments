package com.clinton.gestiondedocuments.controller;

import com.clinton.gestiondedocuments.Services.EnseignantService;
import com.clinton.gestiondedocuments.controller.api.EnseignantApi;
import com.clinton.gestiondedocuments.dto.EnseignantDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EnseignantController implements EnseignantApi {

    private EnseignantService enseignantService;

    @Autowired
    public EnseignantController(EnseignantService enseignantService) {
        this.enseignantService = enseignantService;
    }

    @Override
    public EnseignantDto save(EnseignantDto dto) {
        return enseignantService.save(dto);
    }

    @Override
    public EnseignantDto findById(Integer id) {
        return enseignantService.findById(id);
    }

    @Override
    public List<EnseignantDto> findAll() {
        return enseignantService.findAll();
    }

    @Override
    public void delete(Integer id) {
        enseignantService.delete(id);
    }
}
