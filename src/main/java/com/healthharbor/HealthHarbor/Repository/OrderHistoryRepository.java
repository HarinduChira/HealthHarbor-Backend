package com.healthharbor.HealthHarbor.Repository;

import com.healthharbor.HealthHarbor.Collection.OrderHistory;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderHistoryRepository extends MongoRepository<OrderHistory, ObjectId> {


}
