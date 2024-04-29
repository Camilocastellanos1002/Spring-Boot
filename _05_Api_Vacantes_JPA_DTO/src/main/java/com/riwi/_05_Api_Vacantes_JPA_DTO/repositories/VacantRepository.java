package com.riwi._05_Api_Vacantes_JPA_DTO.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.riwi._05_Api_Vacantes_JPA_DTO.entities.Vacant;

public interface VacantRepository  extends JpaRepository<Vacant, Long>{

    
} 
