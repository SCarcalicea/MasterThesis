package com.logicbig.repository;

import com.logicbig.model.Stations;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StationsRepository extends MongoRepository<Stations, String> { }
