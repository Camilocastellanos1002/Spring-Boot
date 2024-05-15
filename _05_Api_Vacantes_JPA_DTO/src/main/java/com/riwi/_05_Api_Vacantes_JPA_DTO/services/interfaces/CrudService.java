package com.riwi._05_Api_Vacantes_JPA_DTO.services.interfaces;

import org.springframework.data.domain.Page;
/*
 * RQ = REQUEST
 * RS = RESPONSE 
 * ID = tipo de dato de la llave primaria de la entidad
 */
public interface CrudService<RQ, RS, ID> { //interfaz con valores genericos RQ,RS,ID para cualquier las interfaces extenderan de esta
    Page<RS> getAll(int page, int size); //obtener paginado donde se pagina responses

    RS create(RQ request);

    RS update(RQ request, ID id);

    void delete(ID id);

    RS getById(ID id);
}