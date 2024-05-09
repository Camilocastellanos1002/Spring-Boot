package com.riwi._06_Api_Salon_Belleza.infraestructure.service;

import java.util.List;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.riwi._06_Api_Salon_Belleza.api.dto.request.ServiceRequest;
import com.riwi._06_Api_Salon_Belleza.api.dto.response.ServiceResponse;
import com.riwi._06_Api_Salon_Belleza.domain.entities.ServiceEntity;
import com.riwi._06_Api_Salon_Belleza.domain.repositories.ServiceRepository;
import com.riwi._06_Api_Salon_Belleza.infraestructure.abstract_services.IServiceService;
import com.riwi._06_Api_Salon_Belleza.utils.enums.SortType;
import com.riwi._06_Api_Salon_Belleza.utils.messages.ErrorMessages;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Transactional
public class ServiceService implements IServiceService{

    @Autowired
    private final ServiceRepository serviceRepository;

    @Override
    public ServiceResponse create(ServiceRequest request) {
        ServiceEntity service = this.requestToEntity(request);

        return this.entityToResponse(this.serviceRepository.save(service));
    }

    @Override
    public ServiceResponse get(Long id) {
        return this.entityToResponse(this.find(id));
    }

    @Override
    public ServiceResponse update(ServiceRequest request, Long id) {
        ServiceEntity service = this.find(id);

        service = this.requestToEntity(request);

        service.setId(id);

        return this.entityToResponse(this.serviceRepository.save(service));
    }

    @Override
    public void delete(Long id) {
        this.serviceRepository.delete(this.find(id));
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

        this.serviceRepository.findAll(pagination);  //traer lista de toda la lista de datos
             
        return this.serviceRepository.findAll(pagination).map(this::entityToResponse); //convertimos y se lo enviamos a entityResponse 
    }

    @Override
    public List<ServiceResponse> search(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'search'");
    }

    private ServiceResponse entityToResponse(ServiceEntity entity){
        return ServiceResponse.builder() //se devuelve un serviceresponse constuyendolo con el patron de diseño builder
            .id(entity.getId())
            .name(entity.getName())
            .price(entity.getPrice())
            .description(entity.getDescription())
            .build();
    }

    private ServiceEntity requestToEntity(ServiceRequest request){
        return ServiceEntity.builder()
                    .name(request.getName())
                    .price(request.getPrice())
                    .description(request.getDescription())
                    .build();
    }



    private ServiceEntity find(Long id) throws org.apache.coyote.BadRequestException{

        return this.serviceRepository.findById(id)
                .orElseThrow(()-> new BadRequestException(ErrorMessages.idNotFound("servicio")));
    }
    
}
