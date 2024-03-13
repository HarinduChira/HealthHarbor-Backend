package com.healthharbor.HealthHarbor.Controller;

import com.healthharbor.HealthHarbor.Collection.Products;
import com.healthharbor.HealthHarbor.Service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Products")
public class ProductsController {
    @Autowired
    private ProductsService productsService;

    @GetMapping
    public ResponseEntity<List<Products>> getAllProducts(){
        return new ResponseEntity<List<Products>>(productsService.allProducts(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Products> addProductToDb(@RequestBody Products products)
    {
        Products newProduct = productsService.addProduct(products);

        return new ResponseEntity<>(newProduct,HttpStatus.CREATED);
    }
}
