package com.riwi._06_Api_Salon_Belleza.utils.exception;

public class BadRequestException extends RuntimeException {
    
    public BadRequestException(String message){
        super(message);
    }
}
