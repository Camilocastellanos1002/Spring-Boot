package com.riwi._05_Api_Vacantes_JPA_DTO.services.interfaces;

import com.riwi._05_Api_Vacantes_JPA_DTO.utils.dto.request.VacantRequest;
import com.riwi._05_Api_Vacantes_JPA_DTO.utils.dto.response.VacantResponse;

/*
 * Interface para establecer el contrato con el servicio
 */
public interface IVacantsService  extends CrudService<VacantRequest, VacantResponse, Long>{
    
}
