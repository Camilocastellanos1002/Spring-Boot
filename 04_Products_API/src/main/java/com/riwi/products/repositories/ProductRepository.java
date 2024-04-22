package com.riwi.products.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.riwi.products.entities.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {

    public Product findByName(String name);
}