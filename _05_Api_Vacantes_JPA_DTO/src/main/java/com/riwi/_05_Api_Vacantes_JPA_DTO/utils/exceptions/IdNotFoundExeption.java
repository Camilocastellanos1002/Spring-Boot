package com.riwi._05_Api_Vacantes_JPA_DTO.utils.exceptions;

/**
 * RuntimeException es la clase general de errores de Java
 * La utilizaremos para utilizar su constructor y generar errores personalizados
 */
public class IdNotFoundExeption extends RuntimeException {
    private static final String ERROR_MESSGE = "No hay registros en la entidad %s con el id suministrado"; 

    /**
     * Utilizamos el constructor de RuntimeException y enviamos el mensaje
     * inyectando el nombre de la entidad en %s por medio de String.format de la variable naemEntity
     * 
     */
    public IdNotFoundExeption(String nameEntity) { //constructor manual para poderlo realizar personalizado
        super(String.format(ERROR_MESSGE, nameEntity)); //se llama el constructor padre
    }
}