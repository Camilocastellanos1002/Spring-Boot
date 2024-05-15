package com.riwi._05_Api_Vacantes_JPA_DTO.services;

import java.util.ArrayList;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


import com.riwi._05_Api_Vacantes_JPA_DTO.entities.Company;
import com.riwi._05_Api_Vacantes_JPA_DTO.entities.Vacant;
import com.riwi._05_Api_Vacantes_JPA_DTO.repositories.CompanyRepository;
import com.riwi._05_Api_Vacantes_JPA_DTO.services.interfaces.ICompanyService;
import com.riwi._05_Api_Vacantes_JPA_DTO.utils.dto.request.CompanyRequest;
import com.riwi._05_Api_Vacantes_JPA_DTO.utils.dto.response.CompanyResponse;
import com.riwi._05_Api_Vacantes_JPA_DTO.utils.dto.response.VacantToCompanyResponse;
import com.riwi._05_Api_Vacantes_JPA_DTO.utils.exceptions.IdNotFoundExeption;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CompanyService implements ICompanyService {
    
    @Autowired
    private final CompanyRepository companyRepository; //inyeccion de dependencias

    @Override
    public Page<CompanyResponse> getAll(int page, int size) {
        /** 1. Configuramos la paginación */
        if (page < 0)
            page = 0;
        PageRequest pagination = PageRequest.of(page, size);
        // *LLamamos el repositorio */
        // return this.companyRepository.findAll(pagination)
        // .map(company -> this.entityToResponse(company));

        return this.companyRepository.findAll(pagination)
                .map(this::entityToResponse);
    }

    @Override
    public CompanyResponse create(CompanyRequest request) {
        /** Convertimos el Request en la entidad */
        Company company = this.requestToEntity(request, new Company());
        /**
         * crea la compañia y save la devuelve al repositorio y se retorna la conversion de compañia a response 
         */
        return this.entityToResponse(this.companyRepository.save(company));
    }

    @Override
    public CompanyResponse update(CompanyRequest request, String id) {
        Company companyToUpdate = this.find(id); //busco por id la compañia

        Company company = this.requestToEntity(request, companyToUpdate); //convierte la request ingresado en entidad y recibe el objeto compañia actualizado

        return this.entityToResponse(this.companyRepository.save(company)); //guardamos el objeto actualizado en el repositorio y se genera la conversion de la entidad a response
    }

    @Override
    public void delete(String id) {
        // Buscamos la compañia a la que corresponde el id
        Company company = this.find(id);
        // Eliminamos
        this.companyRepository.delete(company);
    }

    @Override
    public CompanyResponse getById(String id) {
        // Buscamos la compañia con el id
        Company company = this.find(id);

        // Convertimos la entidad al dto de respuesta y lo retornamos
        return this.entityToResponse(company);
    }

    /**
     * Este método se encargará de convertir una entidad (Company) a CompanyResponse
     */
    private CompanyResponse entityToResponse(Company entity) {

        CompanyResponse response = new CompanyResponse();
        /**
         * Bean Utils nos permite hacer un copia de una clase en otra
         * En este caso toda la entidad de tipo Company sera copiada con la información
         * requerida por la variable tipo CompanyResponse
         */

        BeanUtils.copyProperties(entity, response);

        /**
         * Mapeamos las cantes convirtiendo cada una de ellas al dto de response
         * stream -> Convierte la lista en colección para poder iterarse
         * map -> Itera toda la lista y retorna cambios, es como un for each
         * collect -> Crea de nuevo toda la lista que se habia transformado en coleccion
         */
        response.setVacants(entity.getVacants().stream() // stream() cambia una lista a una coleccion, pero desarmada 
            //getVacants genera el join 
                .map(this::vacantToResponse) //infiere que se desea sacar un iterable y llevarselo a la funcion vacanttoresponse
                .collect(Collectors.toList())); //forma de  armar la coleccion 

        return response;

    }

    private VacantToCompanyResponse vacantToResponse(Vacant entity) {
        VacantToCompanyResponse response = new VacantToCompanyResponse();

        BeanUtils.copyProperties(entity, response);

        return response;
    }

    private Company requestToEntity(CompanyRequest request, Company company) {
        company.setContact(request.getContact());
        company.setLocation(request.getLocation());
        company.setName(request.getName());
        company.setVacants(new ArrayList<>());
        return company;
    }

    //metodo utilizado en la mayoria de los otros metodos
    //del repositorio busca por id y en caso de no encontrarlo genera error y dispara el error pernosalizado por medio de una funcion lambda y recibe el nombre de la entidad
    private Company find(String id) {
        return this.companyRepository.findById(id).orElseThrow(() -> new IdNotFoundExeption("Company"));
    }
}