package com.riwi._06_Api_Salon_Belleza.infraestructure.abstract_services;

import java.util.List;

import com.riwi._06_Api_Salon_Belleza.api.dto.request.ServiceRequest;
import com.riwi._06_Api_Salon_Belleza.api.dto.response.ServiceResponse;

public interface IServiceService extends CRUD_Service<ServiceRequest,ServiceResponse, Long>{
    
    public List<ServiceResponse> search(String name);

    public String FIELD_BY_SORT = "price";
}
