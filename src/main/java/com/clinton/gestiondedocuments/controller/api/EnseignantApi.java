package com.clinton.gestiondedocuments.controller.api;

import com.clinton.gestiondedocuments.dto.EnseignantDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.clinton.gestiondedocuments.utils.Constents.APP_ROOT;

@Api(APP_ROOT + "/enseignants")
public interface EnseignantApi {

    @PostMapping(value = APP_ROOT + "/enseignants/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value="enregistrer un enseignant(ajouter/modifier)", notes="Cette methode permet d'enregistrer ou de modifier une enseignant", response = EnseignantDto.class)
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "L'objet enseignant crée / modifié"),
            @ApiResponse(code = 400, message = "L'objet enseignant n'est pas valide")
    })
    EnseignantDto save(@RequestBody EnseignantDto dto);

    @GetMapping(value = APP_ROOT + "/enseignants/{idEnseignant}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value="Rechercher un enseignant par ID", notes="Cette methode permet de rechercher un enseignant par son ID", response = EnseignantDto.class)
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "L'objet enseignant a été trouvé dans la BDD"),
            @ApiResponse(code = 404, message = "Aucune enseignant n'existe dans la BDD avec l'id fournit" )
    })
    EnseignantDto findById(@PathVariable("idEnseigant") Integer id);

    @GetMapping(value = APP_ROOT + "/enseigants/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value="Renvoie la liste des enseigants)", notes="Cette methode permet de rechercher et de renvoyer la liste des enseigants", response = EnseignantDto.class)
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "La liste des enseignants / Une liste vide")
    })
    List<EnseignantDto> findAll();

    @DeleteMapping(value = APP_ROOT + "/enseignants/delete/{idEnseignant}")
    @ApiOperation(value="Supprimer un enseignant)", notes="Cette methode permet de supprimer un enseignant par ID", responseContainer = "List<EnseigantDto>")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "L'enseignant' supprimé")
    })
    void delete(@PathVariable("idEnseignant") Integer id);

}
