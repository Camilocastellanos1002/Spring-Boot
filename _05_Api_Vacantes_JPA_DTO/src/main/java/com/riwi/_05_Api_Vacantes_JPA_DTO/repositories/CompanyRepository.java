package com.riwi._05_Api_Vacantes_JPA_DTO.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi._05_Api_Vacantes_JPA_DTO.entities.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company,String>{
    
}
