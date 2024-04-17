package com.riwi.primerWeb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.primerWeb.entity.Coder;

//
@Repository
/*  - tipo interface
    - extiende de JpaRespository 
    - Recibe  tipo de clase (Coder)
    - Se declara el tipo de dato de la llave primara*/
public interface CoderRespository extends JpaRepository<Coder , Long> {

    
}
