package com.virtualghost.springmongodemo.service;

import com.virtualghost.springmongodemo.model.Vehicle;

import java.util.List;

public interface VehicleService {

    Vehicle getVehicleById(String id);

    Vehicle createVehicle(Vehicle vehicle);

    public String getVehicleMessage();

    List<Vehicle> getVehicleByBrand(String brand);

    Vehicle editVehicle(String id, Vehicle vehicle);
}
