package com.zoetic.ahmetsemsettinozdemidenassigment.repository;

import com.zoetic.ahmetsemsettinozdemidenassigment.model.BloodPressure;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BloodPressureRepository extends MongoRepository<BloodPressure, String> {

}
