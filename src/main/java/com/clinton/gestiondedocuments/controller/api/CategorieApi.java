package com.clinton.gestiondedocuments.controller.api;

import com.clinton.gestiondedocuments.dto.CategorieDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.clinton.gestiondedocuments.utils.Constents.APP_ROOT;

@Api(APP_ROOT + "/categories")
public interface CategorieApi {

    @PostMapping(value = APP_ROOT + "/categories/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value="enregistrer une categorie(ajouter/modifier)", notes="Cette methode permet d'enregistrer ou de modifier une categorie", response = CategorieDto.class)
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "L'objet categorie crée / modifié"),
            @ApiResponse(code = 400, message = "L'objet categorie n'est pas valide")
    })
    CategorieDto save(@RequestBody CategorieDto dto);

    @GetMapping(value = APP_ROOT + "/categories/{idCategorie}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value="Rechercher une categorie par ID", notes="Cette methode permet de rechercher une categorie par son ID", response = CategorieDto.class)
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "L'objet categorie a été trouvé dans la BDD"),
            @ApiResponse(code = 404, message = "Aucune categorie n'existe dans la BDD avec l'id fournit" )
    })
    CategorieDto findById(@PathVariable("idCategorie") Integer id);

    @GetMapping(value = APP_ROOT + "/categories/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value="Renvoie la liste des categories)", notes="Cette methode permet de rechercher et de renvoyer la liste des categories", response = CategorieDto.class)
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "La liste des categories / Une liste vide")
    })
    List<CategorieDto> findAll();

    @DeleteMapping(value = APP_ROOT + "/categories/delete/{idCategorie}")
    @ApiOperation(value="Supprimer une categorie)", notes="Cette methode permet de supprimer une categorie par ID", responseContainer = "List<CategorieDto>")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "La categorie supprimé")
    })
    void delete(@PathVariable("idCategorie") Integer id);

}
