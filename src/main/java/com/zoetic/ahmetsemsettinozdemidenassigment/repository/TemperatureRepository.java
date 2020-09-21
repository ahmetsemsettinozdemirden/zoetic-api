package com.zoetic.ahmetsemsettinozdemidenassigment.repository;

import com.zoetic.ahmetsemsettinozdemidenassigment.model.Temperature;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface TemperatureRepository extends MongoRepository<Temperature, String> {

    Optional<Temperature> findTopByDateBetweenOrderByDateDesc(LocalDateTime startDate, LocalDateTime endDate);

}
