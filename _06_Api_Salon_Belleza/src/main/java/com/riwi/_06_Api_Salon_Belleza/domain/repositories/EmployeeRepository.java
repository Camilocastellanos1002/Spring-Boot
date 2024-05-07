package com.riwi._06_Api_Salon_Belleza.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.riwi._06_Api_Salon_Belleza.domain.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{
    
}
