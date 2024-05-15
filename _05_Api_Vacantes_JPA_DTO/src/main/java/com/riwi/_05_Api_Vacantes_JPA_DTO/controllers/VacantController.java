package com.riwi._05_Api_Vacantes_JPA_DTO.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.riwi._05_Api_Vacantes_JPA_DTO.services.interfaces.IVacantsService;
import com.riwi._05_Api_Vacantes_JPA_DTO.utils.dto.errors.ErrorResponse;
import com.riwi._05_Api_Vacantes_JPA_DTO.utils.dto.request.VacantRequest;
import com.riwi._05_Api_Vacantes_JPA_DTO.utils.dto.response.VacantResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/vacants")
@AllArgsConstructor
//con Tag podemos cambiar el nombre en swagger
@Tag(name = "Vacantes")
public class VacantController {

     @Autowired
    private final IVacantsService vacantsService;

    //documentacion del endpoint en swagger
    @Operation(
        summary = "Lista todas las vacantes con paginacion",
        description = "debes enviar la pagina y el tamaño de la pagina para recibir todas las vacantes correspondientes"
    )
    @GetMapping
    public ResponseEntity<Page<VacantResponse>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "7") int size) {

        return ResponseEntity.ok(this.vacantsService.getAll(page - 1, size));
    }

    //ApiResponse nos ayuda a crear un nuevo esquema de respuesta (dto) cuando se envia un id erronea
    @ApiResponse(
        responseCode = "400",
        description = "Cuando el id no es valido",
        content = {
            @Content(
                mediaType = "application/json",//responde de tipo json
                schema = @Schema(implementation = ErrorResponse.class) //como responde el error
            )
        }
    )
    //documentacion en swagger
    @Operation(
        summary = "Lista una vacante por id",
        description = "debes enviar el id de la vacante a buscar"
    )
    @GetMapping(path = "/{id}")
    public ResponseEntity<VacantResponse> get(
            @PathVariable Long id) {

        return ResponseEntity.ok(this.vacantsService.getById(id));
    }

    @Operation(
        summary = "Crea una vacante y la asocia a una compañia",
        description = "Crea una vacante y la asocia a una compañia"
    )
    @PostMapping
    public ResponseEntity<VacantResponse> insert(
            @Validated @RequestBody VacantRequest vacant) {
        return ResponseEntity.ok(this.vacantsService.create(vacant));
    }

    @Operation(
        summary = "Elimina una vacante por id",
        description = "elimina una vacante por id"
    )
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Map<String, String>> delete( //retorna un mensaje de eliminado
            @PathVariable Long id) {
        // Creamos el mapa
        Map<String, String> response = new HashMap<>(); //forma de crear un map al igual que una lista
        response.put("message", "Vacante eliminada correctamente.");//el put agrega el mensaje al map
        //elimina vadcante
        this.vacantsService.delete(id);
        //devuelve estado de eliminacion
        return ResponseEntity.ok(response);
    }

    
    @Operation(
        summary = "Actualiza una vacante por id",
        description = "Actualiza una vacante por id"
    )
    @PutMapping(path = "/{id}")
    public ResponseEntity<VacantResponse> update(
            @PathVariable Long id, //variable que viene por url
            @Validated @RequestBody VacantRequest vacant) { //reecibe el cuerpo del request de tipo vacante request y se valida

        return ResponseEntity.ok(this.vacantsService.update(vacant, id)); //se devuelve un response de estado http si se actualizo la vacante po
    }
}
