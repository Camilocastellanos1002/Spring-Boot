package com.riwi._05_Api_Vacantes_JPA_DTO.services.interfaces;

import com.riwi._05_Api_Vacantes_JPA_DTO.utils.dto.request.CompanyRequest;
import com.riwi._05_Api_Vacantes_JPA_DTO.utils.dto.response.CompanyResponse;

public interface ICompanyService
        extends CrudService<CompanyRequest, CompanyResponse, String> {

}