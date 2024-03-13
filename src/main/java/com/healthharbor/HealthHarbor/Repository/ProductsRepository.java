package com.healthharbor.HealthHarbor.Repository;

import com.healthharbor.HealthHarbor.Collection.Products;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends MongoRepository<Products, ObjectId> {
}
