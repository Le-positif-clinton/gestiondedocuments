package com.clinton.gestiondedocuments.controller.api;

import com.clinton.gestiondedocuments.dto.GroupeDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.clinton.gestiondedocuments.utils.Constents.APP_ROOT;

@Api(APP_ROOT + "groupes")
public interface GroupeApi {

    @PostMapping(value = APP_ROOT + "/groupes/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value="enregistrer un groupe(ajouter/modifier)", notes="Cette methode permet d'enregistrer ou de modifier un groupe", response = GroupeDto.class)
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "L'objet groupe crée / modifié"),
            @ApiResponse(code = 400, message = "L'objet groupe n'est pas valide")
    })
    GroupeDto save(@RequestBody GroupeDto dto);

    @GetMapping(value = APP_ROOT + "/groupes/{idGroupe}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value="Rechercher un groupe par ID", notes="Cette methode permet de rechercher un groupe par son ID", response = GroupeDto.class)
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "L'objet groupe a été trouvé dans la BDD"),
            @ApiResponse(code = 404, message = "Aucun groupe n'existe dans la BDD avec l'id fournit" )
    })
    GroupeDto findById(@PathVariable("idGroupe") Integer id);

    @GetMapping(value = APP_ROOT + "/groupes/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value="Renvoie la liste des groupes)", notes="Cette methode permet de rechercher et de renvoyer la liste des groupes", response = GroupeDto.class)
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "La liste des groupes / Une liste vide")
    })
    List<GroupeDto> findAll();

    @DeleteMapping(value = APP_ROOT + "/groupes/delete/{idGroupe}")
    @ApiOperation(value="Supprimer un groupe)", notes="Cette methode permet de supprimer un groupe par ID", responseContainer = "List<GroupeDto>")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "Le groupe supprimé")
    })
    void delete(@PathVariable("idGroupe") Integer id);

}
