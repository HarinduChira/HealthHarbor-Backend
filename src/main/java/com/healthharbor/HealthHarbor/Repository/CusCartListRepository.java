package com.healthharbor.HealthHarbor.Repository;


import com.healthharbor.HealthHarbor.Collection.CusCartList;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.DeleteQuery;
import org.springframework.data.mongodb.repository.Update;


public interface CusCartListRepository extends MongoRepository<CusCartList,String> {


    @DeleteQuery(value = "{ 'product_id' : ?0 }")
    void deleteItemByID(int product_id);

//    @Update(value = "{ 'product_id' : ?0 }")
//    CusCartList findByProductId(int productId);
}
