package com.zoetic.ahmetsemsettinozdemidenassigment.repository;

import com.zoetic.ahmetsemsettinozdemidenassigment.model.Oximeter;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface OximeterRepository extends MongoRepository<Oximeter, String> {

    Optional<Oximeter> findTopByDateBetweenOrderByDateDesc(LocalDateTime startDate, LocalDateTime endDate);

}
