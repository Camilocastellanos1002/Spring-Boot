package com.riwi.products.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.riwi.products.entities.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {

    public List<Product> findByName(String name);
}