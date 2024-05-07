package com.riwi._06_Api_Salon_Belleza.api.dto.errors;


import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true) //no es obligatorio pero java da la advertencia, llame el espacio de memoria del padre y no genere otro espacio del hijo
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse extends BaseErrorResponse {
    private List<String>errors;
}
