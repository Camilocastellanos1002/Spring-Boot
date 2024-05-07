package com.riwi._06_Api_Salon_Belleza.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientRequest {
    @NotBlank(message="El nombre es requerido")
    private String firstName;
    @NotBlank(message= "El apellido es requerido")
    private String lastName;
    @Size(
        min=10,
        max=20,
        message="El telefono debe tener entre 10 y 20 caracteres")
    private String phone;
    @Email(message="El email no es valido")
    @Size(
        min=5,
        max=100,
        message="El email debe tener 5 y 100 caracteres")
    private String email;
}
