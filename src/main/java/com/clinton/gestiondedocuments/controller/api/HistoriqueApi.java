package com.clinton.gestiondedocuments.controller.api;

import com.clinton.gestiondedocuments.dto.HistoriqueDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.clinton.gestiondedocuments.utils.Constents.APP_ROOT;

@Api(APP_ROOT + "/historiques")
public interface HistoriqueApi {

    @PostMapping(value = APP_ROOT + "/historiques/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value="enregistrer un historique(ajouter/modifier)", notes="Cette methode permet d'enregistrer ou de modifier un historique", response = HistoriqueDto.class)
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "L'objet historique crée / modifié"),
            @ApiResponse(code = 400, message = "L'objet historique n'est pas valide")
    })
    HistoriqueDto save(@RequestBody HistoriqueDto dto);

    @GetMapping(value = APP_ROOT + "/historiques/{idHistorique}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value="Rechercher une historique par ID", notes="Cette methode permet de rechercher une historique par son ID", response = HistoriqueDto.class)
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "L'objet historique a été trouvé dans la BDD"),
            @ApiResponse(code = 404, message = "Aucune historique n'existe dans la BDD avec l'id fournit" )
    })
    HistoriqueDto findById(@PathVariable("idHistorique") Integer id);

    @GetMapping(value = APP_ROOT + "/historiques/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value="Renvoie la liste des historiques)", notes="Cette methode permet de rechercher et de renvoyer la liste des historiques", response = HistoriqueDto.class)
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "La liste des historiques / Une liste vide")
    })
    List<HistoriqueDto> findAll();

    @DeleteMapping(value = APP_ROOT + "/historiques/delete/{idHistorique}")
    @ApiOperation(value="Supprimer un historique)", notes="Cette methode permet de supprimer un historique par ID", responseContainer = "List<HistoriqueDto>")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "L'historique supprimé")
    })
    void delete(@PathVariable("idHistorique") Integer id);

}
