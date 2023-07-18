package com.clinton.gestiondedocuments.controller;

import com.clinton.gestiondedocuments.Services.HistoriqueService;
import com.clinton.gestiondedocuments.controller.api.HistoriqueApi;
import com.clinton.gestiondedocuments.dto.HistoriqueDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HistoriqueController implements HistoriqueApi {

    private HistoriqueService historiqueService;

    @Autowired
    public HistoriqueController(HistoriqueService historiqueService) {
        this.historiqueService = historiqueService;
    }

    @Override
    public HistoriqueDto save(HistoriqueDto dto) {
        return historiqueService.save(dto);
    }

    @Override
    public HistoriqueDto findById(Integer id) {
        return historiqueService.findById(id);
    }

    @Override
    public List<HistoriqueDto> findAll() {
        return historiqueService.findAll();
    }

    @Override
    public void delete(Integer id) {
        historiqueService.delete(id);
    }
}
