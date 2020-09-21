package com.zoetic.ahmetsemsettinozdemidenassigment.repository;

import com.zoetic.ahmetsemsettinozdemidenassigment.model.Temperature;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TemperatureRepository extends MongoRepository<Temperature, String> {

}
