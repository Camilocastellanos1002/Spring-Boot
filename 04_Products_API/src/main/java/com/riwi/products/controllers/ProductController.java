package com.riwi.products.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.products.entities.Product;
import com.riwi.products.services.service_abstract.IProductService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v1/products")
@AllArgsConstructor //crear todos los constructores
public class ProductController {

    private final IProductService productService; //constante del servicio abstracto

    @GetMapping
    public ResponseEntity<List<Product>> getAll(){ 
        return ResponseEntity.ok(this.productService.getAll()); //devuelve un estado 200 y es correcto
    }
    
}
