package com.clinton.gestiondedocuments.controller.api;

import com.clinton.gestiondedocuments.dto.AdministrationDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.clinton.gestiondedocuments.utils.Constents.APP_ROOT;

@Api(APP_ROOT + "/administrations")
public interface AdministrationApi {

    @PostMapping(value = APP_ROOT + "/administrations/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value="enregistrer un membre de l'administration(ajouter/modifier)", notes="Cette methode permet d'enregistrer ou de modifier un membre d'administration", response = AdministrationDto.class)
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "L'objet administration crée / modifié"),
            @ApiResponse(code = 400, message = "L'objet administration n'est pas valide")
    })
    AdministrationDto save(@RequestBody AdministrationDto dto);

    @GetMapping(value = APP_ROOT + "/administrations/{idAdministration}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value="Rechercher un membre d'administration par ID", notes="Cette methode permet de rechercher un membre de l'administration par son ID", response = AdministrationDto.class)
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "L'objet administration a été trouvé dans la BDD"),
            @ApiResponse(code = 404, message = "Aucun membre de l'administration n'existe dans la BDD avec l'id fournit" )
    })
    AdministrationDto findById(@PathVariable("idAdministration") Integer id);

    @GetMapping(value = APP_ROOT + "/administrations/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value="Renvoie la liste des administrations)", notes="Cette methode permet de rechercher et de renvoyer la liste des administrations", response = AdministrationDto.class)
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "La liste des administrations / Une liste vide")
    })
    List<AdministrationDto> findAll();

    @DeleteMapping(value = APP_ROOT + "/categories/delete/{idAdministration}")
    @ApiOperation(value="Supprimer un membre de l'administration)", notes="Cette methode permet de supprimer un membre de l'administration par ID", responseContainer = "List<AdministrationDto>")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "Le membre de l'administration supprimé")
    })
    void delete(@PathVariable("idAdministration") Integer id);

}
