package com.clinton.gestiondedocuments.controller.api;

import com.clinton.gestiondedocuments.dto.EtudiantDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.clinton.gestiondedocuments.utils.Constents.APP_ROOT;

@Api(APP_ROOT + "/etudiants")
public interface EtudiantApi {

    @PostMapping(value = APP_ROOT + "/etudiants/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value="enregistrer un etudiant(ajouter/modifier)", notes="Cette methode permet d'enregistrer ou de modifier un etudiant", response = EtudiantDto.class)
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "L'objet etudiant crée / modifié"),
            @ApiResponse(code = 400, message = "L'objet etudiant n'est pas valide")
    })
    EtudiantDto save(@RequestBody EtudiantDto dto);

    @GetMapping(value = APP_ROOT + "/etudiants/{idEtudiant}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value="Rechercher un etudiant par ID", notes="Cette methode permet de rechercher un etudiant par son ID", response = EtudiantDto.class)
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "L'objet etudiant a été trouvé dans la BDD"),
            @ApiResponse(code = 404, message = "Aucun etudiant n'existe dans la BDD avec l'id fournit" )
    })
    EtudiantDto findById(@PathVariable("idEtudiant") Integer id);

    @GetMapping(value = APP_ROOT + "/etudiants/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value="Renvoie la liste des etudiants)", notes="Cette methode permet de rechercher et de renvoyer la liste des etudiants", response = EtudiantDto.class)
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "La liste des etudiants / Une liste vide")
    })
    List<EtudiantDto> findAll();

    @DeleteMapping(value = APP_ROOT + "/etudiants/delete/{idEtudiant}")
    @ApiOperation(value="Supprimer un etudiant)", notes="Cette methode permet de supprimer un etudiant par ID", responseContainer = "List<EtudiantDto>")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "L'etudiant'supprimé")
    })
    void delete(@PathVariable("idEtudiant") Integer id);

}
