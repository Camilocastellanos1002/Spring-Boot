package com.riwi._06_Api_Salon_Belleza.api.dto.request;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AppoinmentRequest {
    @NotBlank(message="La fecha y hora es requerida")
    private LocalDateTime dateTime;
    @Min(value=10,message="La duracion no puede ser menor a 10")
    @Max(value=720,message="La duracion no puede ser mayor a 12 horas")
    private Integer duration;
    private String comments;
    @NotNull(message="El id del cliente es obligatorio")
    private Long clientId;
    @NotNull(message="El id del servicio es obligatorio")
    private Long serviceId;
    @NotNull(message="El id del empleado es obligatorio")
    private Long employeeId;
}
