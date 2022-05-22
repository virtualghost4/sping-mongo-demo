package com.virtualghost.springmongodemo.service.impl;

import com.virtualghost.springmongodemo.model.Vehicle;
import com.virtualghost.springmongodemo.service.VehicleRepository;
import com.virtualghost.springmongodemo.service.VehicleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    private String message;
    Logger logger = LoggerFactory.getLogger(VehicleServiceImpl.class);

    @Autowired
    VehicleRepository vehicleRepository;

    @Override
    public Vehicle getVehicleById(String id){
        return vehicleRepository.findById(id).orElseThrow(RuntimeException::new);

    }

    @Override
    public Vehicle createVehicle(Vehicle vehicle){
        return vehicleRepository.save(vehicle);

    }

    @Override
    public String getVehicleMessage(){

        return message;
    }

    @Override
    public List<Vehicle> getVehicleByBrand(String brand){
        List<Vehicle> vehicleList = vehicleRepository.findbyBrand(brand);
        return vehicleList;
    }

    @Override
    public Vehicle editVehicle(String id, Vehicle vehicleDetails) {

        Vehicle vehicle = vehicleRepository.findById(id).orElseThrow(RuntimeException::new);
        vehicle.setBrand(vehicleDetails.getBrand());
        vehicle.setColor(vehicleDetails.getColor());
        vehicle.setModel(vehicleDetails.getModel());
        vehicle.setModel(vehicleDetails.getModel());
        vehicle.setDisplacement(vehicleDetails.getDisplacement());
        vehicle.setYear(vehicleDetails.getYear());

        final Vehicle vehicleUpdated = vehicleRepository.save(vehicle);
        return vehicleUpdated;
    }
}
