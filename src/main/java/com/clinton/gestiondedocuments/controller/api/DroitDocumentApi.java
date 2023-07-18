package com.clinton.gestiondedocuments.controller.api;

import com.clinton.gestiondedocuments.dto.DroitDocumentDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.clinton.gestiondedocuments.utils.Constents.APP_ROOT;

@Api(APP_ROOT + "/droitDocuments")
public interface DroitDocumentApi {

    @PostMapping(value = APP_ROOT + "/droitDocuments/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value="enregistrer un droitDocument(ajouter/modifier)", notes="Cette methode permet d'enregistrer ou de modifier un droitDocument", response = DroitDocumentDto.class)
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "L'objet droitDocument crée / modifié"),
            @ApiResponse(code = 400, message = "L'objet droitDocument n'est pas valide")
    })
    DroitDocumentDto save(@RequestBody DroitDocumentDto dto);

    @GetMapping(value = APP_ROOT + "/droitDocuments/{idDroitDocument}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value="Rechercher un droitDocument par ID", notes="Cette methode permet de rechercher un droitDocument par son ID", response = DroitDocumentDto.class)
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "L'objet droitDocument a été trouvé dans la BDD"),
            @ApiResponse(code = 404, message = "Aucune droitDocument n'existe dans la BDD avec l'id fournit" )
    })
    DroitDocumentDto findById(@PathVariable("idDroitDocument") Integer id);

    @GetMapping(value = APP_ROOT + "/droitDocuments/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value="Renvoie la liste des droitDocuments)", notes="Cette methode permet de rechercher et de renvoyer la liste des droitDocuments", response = DroitDocumentDto.class)
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "La liste des droitDocuments / Une liste vide")
    })
    List<DroitDocumentDto> findAll();

    @DeleteMapping(value = APP_ROOT + "/droitDocuments/delete/{idDroitDocument}")
    @ApiOperation(value="Supprimer un droitDocument)", notes="Cette methode permet de supprimer une categorie par ID", responseContainer = "List<DroitDocumentDto>")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "Le droitDocument supprimé")
    })
    void delete(@PathVariable("idDroitDocument") Integer id);

}
