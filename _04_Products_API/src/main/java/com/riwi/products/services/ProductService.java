package com.riwi.products.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riwi.products.entities.Product;
import com.riwi.products.repositories.ProductRepository;
import com.riwi.products.services.service_abstract.IProductService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductService implements IProductService {

    @Autowired
    private final ProductRepository productRepository; //final = const de js


    @Override
    public Product save(Product product) {
        return this.productRepository.save(product);
    }

    @Override
    public Product findById(Long id) {
        return this.productRepository.findById(id).orElseThrow(); //regresa el respository con el id o genera un error  (if)
    }

    @Override
    public void delete(Long id) {
        Product productFind= this.productRepository.findById(id).orElseThrow(); //validar si el id existe
        this.productRepository.delete(productFind);

        
    }

    @Override
    public Product update(Long id,Product objproduct) {
        this.productRepository.findById(id).orElseThrow(); //regresa el respository con el id o genera un error  (if)
        objproduct.setId(id);
        return this.productRepository.save(objproduct);
    }

    @Override
    public List<Product> search(String name) {
        return this.productRepository.findByName(name);
    }

    @Override
    public List<Product> getAll() {
        return this.productRepository.findAll(); 
    }

    
}
