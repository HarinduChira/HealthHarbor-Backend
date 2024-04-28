package com.healthharbor.HealthHarbor.Repository;

import com.healthharbor.HealthHarbor.Collection.CusCartList;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.DeleteQuery;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CusCartListRepository extends MongoRepository<CusCartList, ObjectId> {

    @DeleteQuery(value = "{ 'productId' : ?0 }")
    void deleteItemByID(int productId);

    Optional<CusCartList> findByProductId(int productId);

}
