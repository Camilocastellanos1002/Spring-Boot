package com.riwi._05_Api_Vacantes_JPA_DTO.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import com.riwi._05_Api_Vacantes_JPA_DTO.utils.dto.errors.ErrorResponse;
import com.riwi._05_Api_Vacantes_JPA_DTO.utils.dto.errors.ErrorsResponse;
import com.riwi._05_Api_Vacantes_JPA_DTO.utils.dto.request.CompanyRequest;

import com.riwi._05_Api_Vacantes_JPA_DTO.services.interfaces.ICompanyService;
import com.riwi._05_Api_Vacantes_JPA_DTO.utils.dto.response.CompanyResponse;

import lombok.AllArgsConstructor;

@RestController //anotacion de controlador
@RequestMapping(path = "/company") //ruta que vamos a utilizar
@AllArgsConstructor //constructor lleno
public class CompanyController {

    @Autowired
    private final ICompanyService companyService; //inyeccion de dependencia

    // Colocar una descripcion individual
    @Operation(summary = "Obtiene toda la lista de compañias de forma paginada")

    //READ
        @GetMapping
        public ResponseEntity<Page<CompanyResponse>> getAll(
                @RequestParam(defaultValue = "1") int page,
                @RequestParam(defaultValue = "3") int size) {
            return ResponseEntity.ok(this.companyService.getAll(page - 1, size));
        }

        @ApiResponse(responseCode = "400", description = "Cuando el id no es valido", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
        })
        @GetMapping(path = "/{id}")
        public ResponseEntity<CompanyResponse> get(
                @PathVariable String id) {
            return ResponseEntity.ok(this.companyService.getById(id));
        }
    //CREATE
        @ApiResponse(responseCode = "400", description = "Cuando el request no es valido", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorsResponse.class))
        })
        @PostMapping
            public ResponseEntity<CompanyResponse> insert(
                    @Validated @RequestBody CompanyRequest company) { //valida errores
                return ResponseEntity.ok(this.companyService.create(company));
            }
    //DELETE
        @ApiResponse(responseCode = "400", description = "Cuando el id no es valido", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
        })
        @DeleteMapping(path = "/{id}")
        public ResponseEntity<Void> delete(@PathVariable String id) { //recibe por pathvariable la id de la compañia a eliminar

            this.companyService.delete(id);
            return ResponseEntity.noContent().build(); //responde status 204: que elimino de lo contrario hubo un error
        }
    //UPDATE
        @ApiResponse(responseCode = "400", description = "Cuando el request no es valido", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorsResponse.class))
        })
    
        @PutMapping(path = "/{id}") //recibe variable id por url
        public ResponseEntity<CompanyResponse> update(
                @Validated @PathVariable String id, //recibe el id del pathvariable y valida un metodo
                @RequestBody CompanyRequest company) { //recibe el cuerpo de un request de compañia actualizada

            return ResponseEntity.ok(this.companyService.update(company, id)); //genera un status 200 y genera por medio de un response de tipo compañia acutlizada
        }
}