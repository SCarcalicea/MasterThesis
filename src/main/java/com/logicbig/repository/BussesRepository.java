package com.logicbig.repository;

import com.logicbig.model.Bus;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BussesRepository extends MongoRepository<Bus, String> {
}
