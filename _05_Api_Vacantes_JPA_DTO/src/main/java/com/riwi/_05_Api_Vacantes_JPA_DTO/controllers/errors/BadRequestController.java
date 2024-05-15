package com.riwi._05_Api_Vacantes_JPA_DTO.controllers.errors;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.riwi._05_Api_Vacantes_JPA_DTO.utils.dto.errors.ErrorResponse;
import com.riwi._05_Api_Vacantes_JPA_DTO.utils.dto.errors.ErrorsResponse;
import com.riwi._05_Api_Vacantes_JPA_DTO.utils.dto.errors.BaseErrorResponse;
import com.riwi._05_Api_Vacantes_JPA_DTO.utils.exceptions.IdNotFoundExeption;

/**
 * RestControllerAdvice = anotacion de Controlador de errorres
 */
@RestControllerAdvice
/**
 * Status de error
 */
@ResponseStatus(code = HttpStatus.BAD_REQUEST) //forma de la cual el cliente envia los datos de forma erronea
public class BadRequestController {
    
    
    /**
     * Para especificar cuando se va a disparar este metodo
     * utilizamos la aotacion ExceptionHandler
     */
    @ExceptionHandler(IdNotFoundExeption.class) //anotacion que va a observar la clase de la excepcion creada que la dispara
    public BaseErrorResponse handleIdNotFound(IdNotFoundExeption exeption) {

        return ErrorResponse.builder() //construccion del errorResponse con el patron builder sin la palabra new
                .message(exeption.getMessage()) //uso implicito del setmessage obteniendo el getmessage
                .status(HttpStatus.BAD_REQUEST.name()) //uso implicito del setestatus obteniendo el getstatus
                .code(HttpStatus.BAD_REQUEST.value()) //uso implicito del setcode obteniendo el getcode
                .build(); //construir el error
    }

    @ExceptionHandler(MethodArgumentNotValidException.class) //excepcion que crea la libreria
    public BaseErrorResponse handleErrors(MethodArgumentNotValidException exception) { //responde lista de errores
        List<String> errors = new ArrayList<>(); //generamos una lista varia para llenarla de los errores

        exception.getAllErrors().forEach(error -> errors.add(error.getDefaultMessage())); //traer toda la coleccion de todos los errores, se itera por medio de un foreach y agrega el error a la lista

        return ErrorsResponse.builder()
                .errors(errors)
                .status(HttpStatus.BAD_REQUEST.name())
                .code(HttpStatus.BAD_REQUEST.value())
                .build();
    }
}
