package com.virtualghost.springmongodemo.service;

import com.virtualghost.springmongodemo.model.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends MongoRepository<Vehicle, String> {

    @Query("{brand:'?0'}")
    List<Vehicle> findbyBrand(String brand);

}
