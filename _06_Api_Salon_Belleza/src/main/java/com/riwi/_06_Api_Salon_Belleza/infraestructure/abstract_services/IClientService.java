package com.riwi._06_Api_Salon_Belleza.infraestructure.abstract_services;

import com.riwi._06_Api_Salon_Belleza.api.dto.request.ClientRequest;
import com.riwi._06_Api_Salon_Belleza.api.dto.response.ClientResponse;

public interface IClientService extends CRUD_Service<ClientRequest,ClientResponse,Long>{

        public String FIELD_BY_SORT = "firstName";
}
