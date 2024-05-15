package com.riwi._05_Api_Vacantes_JPA_DTO.utils.dto.errors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;



//puede que se duplique el hastcode y/o identificadores de las clases, evitar posibles boogs, no es intensional = true
@EqualsAndHashCode(callSuper = true) 
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder //activa el constructor del padre de la clase BaseErrorResponse 
public class ErrorResponse extends BaseErrorResponse {
    private String message;
}