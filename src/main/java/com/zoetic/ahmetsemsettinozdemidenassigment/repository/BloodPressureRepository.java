package com.zoetic.ahmetsemsettinozdemidenassigment.repository;

import com.zoetic.ahmetsemsettinozdemidenassigment.model.BloodPressure;
import com.zoetic.ahmetsemsettinozdemidenassigment.model.Oximeter;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface BloodPressureRepository extends MongoRepository<BloodPressure, String> {

    Optional<BloodPressure> findTopByDateBetweenOrderByDateDesc(LocalDateTime startDate, LocalDateTime endDate);

}
