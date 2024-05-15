package com.riwi._05_Api_Vacantes_JPA_DTO.utils.dto.errors;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder //activar el constructor padre de serializable 
@AllArgsConstructor
@NoArgsConstructor
public class BaseErrorResponse implements Serializable {//Serializable es una interfaz para responder con errores
    private String status;
    private Integer code;
}