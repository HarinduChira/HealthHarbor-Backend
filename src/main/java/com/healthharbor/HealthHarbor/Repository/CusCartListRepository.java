package com.healthharbor.HealthHarbor.Repository;


import com.healthharbor.HealthHarbor.Collection.CusCartList;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.DeleteQuery;


public interface CusCartListRepository extends MongoRepository<CusCartList,String> {


    @DeleteQuery(value = "{ 'product_id' : ?0 }")
    void deleteItemByID(int product_id);
}
