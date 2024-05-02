package com.riwi._05_Api_Vacantes_JPA_DTO.controllers;

import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.riwi._05_Api_Vacantes_JPA_DTO.services.interfaces.IVacantsService;
import com.riwi._05_Api_Vacantes_JPA_DTO.utils.dto.request.VacantRequest;
import com.riwi._05_Api_Vacantes_JPA_DTO.utils.dto.response.VacantResponse;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/vacants")
@AllArgsConstructor
public class VacantController {

    @Autowired
    private final IVacantsService vacantsService;

    @GetMapping
    public ResponseEntity <Page<VacantResponse>> getAll(
        @RequestParam(defaultValue = "1") int page,
        @RequestParam(defaultValue = "7") int size
    ){
        return ResponseEntity.ok(this.vacantsService.getAll(page-1,size));
    }

    @PostMapping
    public ResponseEntity<VacantResponse> insert(
        @Validated /*forma de validad que se inserte los valores requeridos */
        @RequestBody VacantRequest vacant
    ){
        return ResponseEntity.ok(this.vacantsService.create(vacant));
    }
}
