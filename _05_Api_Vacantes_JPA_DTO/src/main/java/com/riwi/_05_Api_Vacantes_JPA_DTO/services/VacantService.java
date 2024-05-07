package com.riwi._05_Api_Vacantes_JPA_DTO.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.riwi._05_Api_Vacantes_JPA_DTO.entities.Company;
import com.riwi._05_Api_Vacantes_JPA_DTO.entities.Vacant;
import com.riwi._05_Api_Vacantes_JPA_DTO.repositories.CompanyRepository;
import com.riwi._05_Api_Vacantes_JPA_DTO.repositories.VacantRepository;
import com.riwi._05_Api_Vacantes_JPA_DTO.services.interfaces.IVacantsService;
import com.riwi._05_Api_Vacantes_JPA_DTO.utils.dto.request.VacantRequest;
import com.riwi._05_Api_Vacantes_JPA_DTO.utils.dto.response.CompanyToVancantResponse;
import com.riwi._05_Api_Vacantes_JPA_DTO.utils.dto.response.VacantResponse;
import com.riwi._05_Api_Vacantes_JPA_DTO.utils.enums.StatusVacant;
import com.riwi._05_Api_Vacantes_JPA_DTO.utils.exceptions.IdNotFoundExeption;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class VacantService implements IVacantsService {

    @Autowired
    private final VacantRepository vacantRepository;
    @Autowired
    private final CompanyRepository companyRepository;

    @Override
    public Page<VacantResponse> getAll(int page, int size) {
        if (page < 0)
            page = 0;

        PageRequest pagination = PageRequest.of(page, size);

        /*
         * Obtenemos todas las vacantes, las iteramos para convertir cada una
         * a el dto de respuesta
         */
        return this.vacantRepository.findAll(pagination)
                .map(vacant -> this.entityToResponse(vacant));
    }

    @Override
    public VacantResponse create(VacantRequest request) {
        /*
         * Buscamos la compañia que corresponda con el id que esta dentro del request
         */
        Company company = this.companyRepository.findById(request.getCompanyId())
                .orElseThrow(() -> new IdNotFoundExeption("Company"));

        /**
         * Convertimos el request a una instacia de vacante
         */
        Vacant vacant = this.requestToVacant(request, new Vacant());
        vacant.setCompany(company);

        // Guardamos en la BD y convertimos la nueva entidad al DTO de respuesta
        return this.entityToResponse(this.vacantRepository.save(vacant));

    }

    @Override
    public VacantResponse update(VacantRequest request, Long id) {
        // Buscamos la vancante
        Vacant vacant = this.find(id);

        // Validamos la compañia
        Company company = this.companyRepository.findById(request.getCompanyId())
                .orElseThrow(() -> new IdNotFoundExeption("company"));

        // Convertimos el dto de request
        vacant = this.requestToVacant(request, vacant);
        // Agregamos la vacante
        vacant.setCompany(company);
        // Agregamos el nuevo Status
        vacant.setStatus(request.getStatus());

        return this.entityToResponse(this.vacantRepository.save(vacant));
    }

    @Override
    public void delete(Long id) {
        Vacant vacant = this.find(id);
        this.vacantRepository.delete(vacant);
    }

    @Override
    public VacantResponse getById(Long id) {
        return this.entityToResponse(this.find(id));
    }

    private VacantResponse entityToResponse(Vacant entity) {
        /* Creamos instacion del dto de vacante */
        VacantResponse response = new VacantResponse();

        /* Copiar toda la entidad en el DTO */
        BeanUtils.copyProperties(entity, response);

        /* Creamos instacio del dto de compañia dentro de la vancate */
        CompanyToVancantResponse companyDto = new CompanyToVancantResponse();

        /*
         * Copio todas las propiedades de la compañia que se encuentra dentro
         * de la entidad (Vacante) en el dto de respuesta
         */
        BeanUtils.copyProperties(entity.getCompany(), companyDto);

        // Agregego el dto lleno a la respuesta final
        response.setCompany(companyDto);

        return response;

    }

    private Vacant requestToVacant(VacantRequest request, Vacant entity) {

        entity.setTitle(request.getTitle());
        entity.setDescription(request.getDescription());
        entity.setStatus(StatusVacant.ACTIVE);

        return entity;

    }

    private Vacant find(Long id) {
        return this.vacantRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundExeption("Vacant"));
    }
    
}
