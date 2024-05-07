package com.riwi._06_Api_Salon_Belleza.infraestructure.abstract_services;

import org.springframework.data.domain.Page;

import com.riwi._06_Api_Salon_Belleza.utils.enums.SortType;

public interface CRUD_Service <RQ, RS, ID> {

    public RS create(RS request);

    public RS get(ID request);

    public RS update(RQ request,ID id);

    public void delete(ID id);

    public Page<RS> getAll(int page,int size,SortType sortType); //forma de paginar de forma ascendente y descendentemente




}
