package com.virkamjha.springbootcrudexample1.service;

import com.virkamjha.springbootcrudexample1.entity.Product;
import com.virkamjha.springbootcrudexample1.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    //POST METHODS(CREATE)
    public Product saveProduct(Product product){
        return repository.save(product);
    }

    public List<Product> saveProducts(List<Product> products){
        return repository.saveAll(products);
    }

    //GET METHODS(RETRIEVE)
    public List<Product> getProducts(){
        return repository.findAll();
    }

    public Product getProductById(int id){
        return repository.findById(id).orElse(null);
    }

    public Product getProductByName(String name){
        return repository.findByName(name);
    }

    //DELETE METHODS
    public String deleteProductById(int id){
        repository.deleteById(id);
        return "product removed!!" + id;
    }

    public String deleteAll(){
        repository.deleteAll();
        return "Table Data Deleted";
    }

    //UPDATE METHODS
    public Product updateProduct(Product product){
        Product existingProduct=repository.findById(product.getId()).orElse(null);
        existingProduct.setId(product.getId());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setName(product.getName());
        existingProduct.setQuantity(product.getQuantity());
        return repository.save(existingProduct);
    }

}
