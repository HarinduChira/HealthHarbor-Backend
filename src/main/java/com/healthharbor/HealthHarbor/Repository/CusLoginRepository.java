package com.healthharbor.HealthHarbor.Repository;

import com.healthharbor.HealthHarbor.Collection.CusLogin;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CusLoginRepository extends MongoRepository<CusLogin,String> {

    Optional<CusLogin> findCusByEmail(String email);
}
