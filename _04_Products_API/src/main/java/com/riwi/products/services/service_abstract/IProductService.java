package com.riwi.products.services.service_abstract;
import com.riwi.products.entities.Product;
import java.util.List;

public interface IProductService { //interface tipo CRUD
    
    public Product save(Product product);
    public List<Product> getAll();
    public Product findById(Long id);
    public void delete(Long id);
    public Product update(Long id,Product product);
    public List<Product> search(String name);
}
