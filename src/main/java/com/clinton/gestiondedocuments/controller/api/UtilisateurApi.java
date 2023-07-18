package com.clinton.gestiondedocuments.controller.api;
import com.clinton.gestiondedocuments.dto.UtilisateurDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.clinton.gestiondedocuments.utils.Constents.APP_ROOT;

@Api(APP_ROOT + "/utilisateurs")
public interface UtilisateurApi {

    @PostMapping(value = APP_ROOT + "/utilisateurs/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value="enregistrer un utilisateur (ajouter/modifier)", notes="Cette methode permet d'enregistrer ou de modifier un utilisateur", response = UtilisateurDto.class)
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "L'objet utilisateur crée / modifié"),
            @ApiResponse(code = 400, message = "L'objet utilisateur n'est pas valide")
    })
    UtilisateurDto save(@RequestBody UtilisateurDto dto);

    @GetMapping(value = APP_ROOT + "/utilisateurs/{idUtilisateur}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value="Rechercher un utilisateur par ID", notes="Cette methode permet de rechercher un utilisateur par son ID", response = UtilisateurDto.class)
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "L'objet utilisateur a été trouvé dans la BDD"),
            @ApiResponse(code = 404, message = "Aucun utilisateur n'existe dans la BDD avec l'id fournit" )
    })
    UtilisateurDto findById(@PathVariable("idUtilisateur") Integer id);

    @GetMapping(value = APP_ROOT + "/utilisateurs/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value="Renvoie la liste des utilisateurs)", notes="Cette methode permet de rechercher et de renvoyer la liste des utilisateurs", response = UtilisateurDto.class)
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "La liste des utilisateurs / Une liste vide")
    })
    List<UtilisateurDto> findAll();

    @DeleteMapping(value = APP_ROOT + "/utilisateurs/delete/{idUtilisateur}")
    @ApiOperation(value="Supprimer une categorie)", notes="Cette methode permet de supprimer un utilisateur par ID", responseContainer = "List<UtilisateurDto>")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "L'utilisateur' supprimé")
    })
    void delete(@PathVariable("idUtilisateur") Integer id);

}
