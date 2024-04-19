package com.riwi.primerWeb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    
    /*
     * Método para listar los coders de forma paginada
     */
    public Page<Coder> fingPaginated(int page, int size) {
        if (page < 0) {
            page = 1;
        }

        // Crear objeto de paginación
        Pageable objPageable = PageRequest.of(page, size);

        return this.objCoderRespository.findAll(objPageable);
    }

    /**
     * Servicio para guardar un coder
     */

    public Coder insert(Coder objCoder) {
        return this.objCoderRespository.save(objCoder);
    }

    /**
     * Servicio para actualizar un coder
     */

    public Coder update(Long id, Coder objCoder) {
        /** Buscar al coder con ese id */
        Coder objCoderDB = this.findById(id);

        /** Verificar que si exista */
        if (objCoderDB == null)
            return null;

        /* Actualizar el coder antiguo */
        objCoderDB = objCoder;

        // Guardarlo
        return this.objCoderRespository.save(objCoderDB);
    }

    public Coder findById(Long id) {
        return this.objCoderRespository.findById(id).orElse(null);
    }

    /**
     * Metodo para eliminar
     *
     */

    public void delete(Long id) {
        this.objCoderRespository.deleteById(id);
    }
}
