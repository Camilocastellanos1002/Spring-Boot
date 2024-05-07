package com.riwi._06_Api_Salon_Belleza.infraestructure.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.riwi._06_Api_Salon_Belleza.api.dto.request.ServiceRequest;
import com.riwi._06_Api_Salon_Belleza.api.dto.response.ServiceResponse;
import com.riwi._06_Api_Salon_Belleza.domain.repositories.ServiceRepository;
import com.riwi._06_Api_Salon_Belleza.infraestructure.abstract_services.IServiceService;
import com.riwi._06_Api_Salon_Belleza.utils.enums.SortType;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Transactional
public class ServiceService implements IServiceService{

    @Autowired
    private final ServiceRepository serviceRepository;

    @Override
    public ServiceResponse create(ServiceResponse request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public ServiceResponse get(Long request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public ServiceResponse update(ServiceRequest request, Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Page<ServiceResponse> getAll(int page, int size, SortType sortType) {
        if (page < 0) page= 0;
        PageRequest pagination = null;
        switch (sortType) {
            case NONE ->pagination = PageRequest.of(page, size);
            case ASC ->pagination = PageRequest.of(page, size,Sort.by(FIELD_BY_SORT).ascending());
            case DESC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).descending());
        }

        this.serviceRepository.findAll(pagination);

        return null;
    }

    @Override
    public List<ServiceResponse> search(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'search'");
    }
    
}
