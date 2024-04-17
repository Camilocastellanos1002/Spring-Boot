package com.riwi.primerWeb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riwi.primerWeb.entity.Coder;
import com.riwi.primerWeb.repository.CoderRespository;


//forma de declarar que esta clase sera un servicio
@Service
public class CoderService {

    //Indica a SpringBoot que se hace inyeccion de dependencias 
    @Autowired
    private CoderRespository objCoderRespository;

    /*
     * Servicio para listar todos los coders 
     */
    public List<Coder> findAll(){
        return this.objCoderRespository.findAll();
    }
}
