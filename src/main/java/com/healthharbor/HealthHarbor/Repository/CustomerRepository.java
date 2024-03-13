package com.healthharbor.HealthHarbor.Repository;

import com.healthharbor.HealthHarbor.Collection.Customer;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository  extends MongoRepository<Customer, ObjectId> {


    Optional<Customer> findCustomerByCusId(String cusId);

}
