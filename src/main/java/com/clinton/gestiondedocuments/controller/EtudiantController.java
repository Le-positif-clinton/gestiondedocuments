package com.clinton.gestiondedocuments.controller;

import com.clinton.gestiondedocuments.Services.EtudiantService;
import com.clinton.gestiondedocuments.controller.api.EtudiantApi;
import com.clinton.gestiondedocuments.dto.EtudiantDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EtudiantController  implements EtudiantApi {

    private EtudiantService etudiantService;

    @Autowired
    public EtudiantController(EtudiantService etudiantService) {
        this.etudiantService = etudiantService;
    }

    @Override
    public EtudiantDto save(EtudiantDto dto) {
        return etudiantService.save(dto);
    }

    @Override
    public EtudiantDto findById(Integer id) {
        return etudiantService.findById(id);
    }

    @Override
    public List<EtudiantDto> findAll() {
        return etudiantService.findAll();
    }

    @Override
    public void delete(Integer id) {
        etudiantService.delete(id);
    }
}
