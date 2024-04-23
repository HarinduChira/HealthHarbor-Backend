package com.healthharbor.HealthHarbor.Repository;

import com.healthharbor.HealthHarbor.Collection.ProductUpdates;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductUpdatesRepository extends MongoRepository<ProductUpdates, ObjectId> {
    Optional<ProductUpdates> findProductUpdatesByName(String name);
}
