package com.clinton.gestiondedocuments.controller;

import com.clinton.gestiondedocuments.Services.DroitDocumentService;
import com.clinton.gestiondedocuments.controller.api.DroitDocumentApi;
import com.clinton.gestiondedocuments.dto.DroitDocumentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DroitDocumentController implements DroitDocumentApi {

    private DroitDocumentService droitDocumentService;

    @Autowired
    public DroitDocumentController(DroitDocumentService droitDocumentService) {
        this.droitDocumentService = droitDocumentService;
    }

    @Override
    public DroitDocumentDto save(DroitDocumentDto dto) {
        return droitDocumentService.save(dto);
    }

    @Override
    public DroitDocumentDto findById(Integer id) {
        return droitDocumentService.findById(id);
    }

    @Override
    public List<DroitDocumentDto> findAll() {
        return droitDocumentService.findAll();
    }

    @Override
    public void delete(Integer id) {
        droitDocumentService.delete(id);
    }
}
