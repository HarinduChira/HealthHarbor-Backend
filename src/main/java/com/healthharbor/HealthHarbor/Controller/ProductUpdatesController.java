package com.healthharbor.HealthHarbor.Controller;


import com.healthharbor.HealthHarbor.Collection.ProductUpdates;
import com.healthharbor.HealthHarbor.Service.ProductUpdatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ProductUpdates")
public class ProductUpdatesController {

    @Autowired
    private ProductUpdatesService productUpdatesService;

    @GetMapping
    public ResponseEntity<List<ProductUpdates>> getAllProductUpdates() {
        return new ResponseEntity<List<ProductUpdates>>(productUpdatesService.allProductUpdates(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProductUpdates> addProductUpdatesToDb(@RequestBody ProductUpdates productUpdates) {
        ProductUpdates newProductUpdates = productUpdatesService.addProductUpdates(productUpdates);

        return new ResponseEntity<>(newProductUpdates, HttpStatus.CREATED);
    }

}
