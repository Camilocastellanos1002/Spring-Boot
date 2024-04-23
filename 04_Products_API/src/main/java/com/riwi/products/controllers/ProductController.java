package com.riwi.products.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    
    @PostMapping
    public ResponseEntity<Product> insert(@RequestBody Product objProduct){ //recibe
        return ResponseEntity.ok(this.productService.save(objProduct)); //devolvemos un responseEntity con un estado, donde la vista utiliza el metodo save y recibe el objeto objproduct
    }

    @GetMapping(path = "/{id}") //id dinamico
    public ResponseEntity<Product> get(@PathVariable Long id){//recibe un path variable 
        return ResponseEntity.ok(this.productService.findById(id)); 
    }

    @PutMapping(path="/{id}")
    public ResponseEntity<Product> update(
        @PathVariable Long id, /* PathVariable por que el id viene por URL */
        @RequestBody Product product /*RequestBody por que los datos vienen   */
    ){
        return ResponseEntity.ok(this.productService.update(id, product));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(
        @PathVariable Long id /* PathVariable por que el id viene por URL */
    ){
        this.productService.delete(id);
        return ResponseEntity.noContent().build(); //devuelve 204 para que no devuelva nada //build es la forma de instanciar un objeto por medio de un metodo en vez de la paralbra reseervada new

    }
}
