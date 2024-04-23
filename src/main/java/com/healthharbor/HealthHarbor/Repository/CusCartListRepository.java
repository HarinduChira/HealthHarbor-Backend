package com.healthharbor.HealthHarbor.Repository;


import com.healthharbor.HealthHarbor.Collection.CustCartList;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.DeleteQuery;


public interface CusCartListRepository extends MongoRepository<CustCartList,String> {


    @DeleteQuery(value = "{ 'product_id' : ?0 }")
    void deleteItemByID(int product_id);
}
