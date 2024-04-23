package com.healthharbor.HealthHarbor.Service;

import com.healthharbor.HealthHarbor.Collection.ProductUpdates;
import com.healthharbor.HealthHarbor.Repository.ProductUpdatesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductUpdatesService {
    @Autowired
    private ProductUpdatesRepository productUpdatesRepository;

    public List<ProductUpdates> allProductUpdates()
    {
        return productUpdatesRepository.findAll();
    }
    public ProductUpdates addProductUpdates(ProductUpdates productUpdates) { return productUpdatesRepository.save(productUpdates);
    }

    public Optional<ProductUpdates> getProductUpdates(String name) {
        return productUpdatesRepository.findProductUpdatesByName(name);
    }
}
