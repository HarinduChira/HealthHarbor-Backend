package com.healthharbor.HealthHarbor.Service;

import com.healthharbor.HealthHarbor.Collection.Products;
import com.healthharbor.HealthHarbor.Repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductsService {
    @Autowired
    private ProductsRepository productsRepository;

    public List<Products> allProducts()
    {
        return productsRepository.findAll();
    }
    public Products addProduct(Products products) {
        return productsRepository.save(products);
    }


    public Optional<Products> getProduct(String name) {
        return productsRepository.findProductByName(name);
    }
}
