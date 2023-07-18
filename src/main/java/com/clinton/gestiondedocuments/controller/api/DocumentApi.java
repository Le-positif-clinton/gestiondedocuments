package com.clinton.gestiondedocuments.controller.api;

import com.clinton.gestiondedocuments.Services.DocumentService;
import com.clinton.gestiondedocuments.dto.DocumentDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import static com.clinton.gestiondedocuments.utils.Constents.APP_ROOT;

@Api(APP_ROOT + "/documents")//uploader
public interface DocumentApi {

    @PostMapping(value = APP_ROOT + "/documents/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value="enregistrer un document(ajouter/modifier)", notes="Cette methode permet d'enregistrer ou de modifier un document", response = DocumentDto.class)
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "L'objet document crée / modifié"),
            @ApiResponse(code = 400, message = "L'objet document n'est pas valide")
    })
    DocumentDto save(@RequestBody DocumentDto dto) throws Exception;

    @GetMapping(value = APP_ROOT + "/documents/{idDoc}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value="Rechercher un document par ID", notes="Cette methode permet de rechercher un document par son ID", response = DocumentDto.class)
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "L'objet document a été trouvé dans la BDD"),
            @ApiResponse(code = 404, message = "Aucun document n'existe dans la BDD avec l'id fournit" )
    })
    DocumentDto findById(@PathVariable("idDoc") Integer id) throws Exception;

//    @GetMapping(value = APP_ROOT + "/documents/downloads/{idDoc}", produces = MediaType.APPLICATION_JSON_VALUE)
//    @ApiOperation(value="Telecharger un document par ID", notes="Cette methode permet de telecharger le fichier d'un document par son ID", response = DocumentDto.class)
//    @ApiResponses(value={
//            @ApiResponse(code = 200, message = "Le fichier a été trouvé dans la BDD"),
//            @ApiResponse(code = 404, message = "Aucun fichier n'existe dans la BDD avec l'id fournit" )
//    })
//    ResponseEntity<Resource> download(@PathVariable Integer idFichier) throws Exception;

    @GetMapping(value = APP_ROOT + "/documents/{titreDoc}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value="Rechercher un document par titre", notes="Cette methode permet de rechercher un document par son titre", response = DocumentDto.class)
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "L'objet document a été trouvé dans la BDD"),
            @ApiResponse(code = 404, message = "Aucun document n'existe dans la BDD avec le titre fournit" )
    })
    DocumentService findByTitre(@PathVariable("titreDoc") String titre);

    @GetMapping(value = APP_ROOT + "/documents/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value="Renvoie la liste des documents)", notes="Cette methode permet de rechercher et de renvoyer la liste des documents", response = DocumentDto.class)
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "La liste des documents / Une liste vide")
    })
    List<DocumentDto> findAll();
    @DeleteMapping(value = APP_ROOT + "/documents/delete/{idDoc}")
    @ApiOperation(value="Supprimer un document)", notes="Cette methode permet de supprimer un document par ID", responseContainer = "List<DocumentDto>")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "Le document supprimé")
    })
    void delete(@PathVariable("idDoc") Integer id);

}
