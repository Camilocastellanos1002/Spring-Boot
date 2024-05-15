package com.riwi._05_Api_Vacantes_JPA_DTO.utils.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder // patron de diseño para crear clases
@AllArgsConstructor
@NoArgsConstructor
public class CompanyRequest {
    //Anotaciones que validan datos de tipo string, Size y NotBlank
    @Size(min = 0, max = 40, message = "El nombre supera la cantidad de caracteres permitidos") //longitud del atributo maximo
    @NotBlank(message = "El nombre de la compañia es requerido") //anotacion que dice que el nombre es obligatorio
    private String name;
    @NotBlank(message = "El nombre de la locación es requerida")
    private String location;
    @Size(min = 0, max = 15, message = "El contacto supera la cantidad de caracteres permitidos")
    @NotBlank(message = "El número de contacto es requerid")
    private String contact;
}