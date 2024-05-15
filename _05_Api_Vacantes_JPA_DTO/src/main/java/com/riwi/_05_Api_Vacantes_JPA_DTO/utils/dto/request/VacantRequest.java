package com.riwi._05_Api_Vacantes_JPA_DTO.utils.dto.request;

import com.riwi._05_Api_Vacantes_JPA_DTO.utils.enums.StatusVacant;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
//el Request es como le pedimos las cosas al cliente (POSTMAN)
public class VacantRequest {
    /* Size: forma de limitar el tamaño del titulo */
    /* notBlank: especifica que el titulo es obligatorio en caso de que no lo inserte */
    @Size(min = 0,max = 255)
    @NotBlank(message = "El titulo es requerido")
    private String title;
    @NotBlank(message = "La descripcion es requerida")
    private String description;
    private StatusVacant status;
    @Size(min = 0,max = 32)
    @NotBlank (message = "El id de la compañia es querido")
    //unico atributo que requerimos de la compañia en la vacante
    private String companyId;
}
