package com.example.demo.repository;

import com.example.demo.entity.Property;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PropertyDao extends MongoRepository<Property, String> {

    @Query(value= "SELECT p FROM Property p WHERE p.bestSeller = true")
    List<Property> findByBestSeller();

}
