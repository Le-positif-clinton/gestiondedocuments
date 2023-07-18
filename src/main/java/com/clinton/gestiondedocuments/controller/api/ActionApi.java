package com.clinton.gestiondedocuments.controller.api;

import com.clinton.gestiondedocuments.dto.ActionDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.clinton.gestiondedocuments.utils.Constents.APP_ROOT;

@Api(APP_ROOT + "/actions")
public interface ActionApi {

    @PostMapping(value = APP_ROOT + "/actions/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value="enregistrer une action(ajouter/modifier)", notes="Cette methode permet d'enregistrer ou de modifier une categorie", response = ActionDto.class)
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "L'objet action crée / modifié"),
            @ApiResponse(code = 400, message = "L'objet action n'est pas valide")
    })
    ActionDto save(@RequestBody ActionDto dto);

    @GetMapping(value = APP_ROOT + "/actions/{idAction}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value="Rechercher une action par ID", notes="Cette methode permet de rechercher une action par son ID", response = ActionDto.class)
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "L'objet action a été trouvé dans la BDD"),
            @ApiResponse(code = 404, message = "Aucune action n'existe dans la BDD avec l'id fournit" )
    })
    ActionDto findById(@PathVariable("idAction") Integer id);

    @GetMapping(value = APP_ROOT + "/actions/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value="Renvoie la liste des actions)", notes="Cette methode permet de rechercher et de renvoyer la liste des actions", response = ActionDto.class)
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "La liste des actions / Une liste vide")
    })
    List<ActionDto> findAll();

    @DeleteMapping(value = APP_ROOT + "/actions/delete/{idAction}")
    @ApiOperation(value="Supprimer une action)", notes="Cette methode permet de supprimer une action par ID", responseContainer = "List<ActionDto>")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "L'action' supprimé")
    })
    void delete(@PathVariable("idAction") Integer id);

}
