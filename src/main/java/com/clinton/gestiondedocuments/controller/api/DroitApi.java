package com.clinton.gestiondedocuments.controller.api;

import com.clinton.gestiondedocuments.dto.DroitDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.clinton.gestiondedocuments.utils.Constents.APP_ROOT;

@Api(APP_ROOT + "/droits")
public interface DroitApi {

    @PostMapping(value = APP_ROOT + "/droits/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value="enregistrer un droit(ajouter/modifier)", notes="Cette methode permet d'enregistrer ou de modifier un droit", response = DroitDto.class)
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "L'objet droit crée / modifié"),
            @ApiResponse(code = 400, message = "L'objet droit n'est pas valide")
    })
    DroitDto save(@RequestBody DroitDto dto);

    @GetMapping(value = APP_ROOT + "/droits/{idCategorie}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value="Rechercher un droit par ID", notes="Cette methode permet de rechercher un droit par son ID", response = DroitDto.class)
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "L'objet droit a été trouvé dans la BDD"),
            @ApiResponse(code = 404, message = "Aucune droit n'existe dans la BDD avec l'id fournit" )
    })
    DroitDto findById(@PathVariable("idDroit") Integer id);

    @GetMapping(value = APP_ROOT + "/droits/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value="Renvoie la liste des droits)", notes="Cette methode permet de rechercher et de renvoyer la liste des droits", response = DroitDto.class)
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "La liste des droits / Une liste vide")
    })
    List<DroitDto> findAll();

    @DeleteMapping(value = APP_ROOT + "/droits/delete/{idDroit}")
    @ApiOperation(value="Supprimer un droit)", notes="Cette methode permet de supprimer un droit par ID", responseContainer = "List<DroitDto>")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "Le droit supprimé")
    })
    void delete(@PathVariable("idDroit") Integer id);

}
