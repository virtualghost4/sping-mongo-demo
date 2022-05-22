package com.virtualghost.springmongodemo.controller;


import com.virtualghost.springmongodemo.model.Vehicle;
import com.virtualghost.springmongodemo.service.VehicleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService){
        this.vehicleService = vehicleService;
    }

    @GetMapping("/vehicle/{id}")
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable("id") String id){
        Vehicle vehicle = vehicleService.getVehicleById(id);
        if(!vehicle.getId().isEmpty()) {
            return new ResponseEntity<>(vehicle, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping("/vehicle/create")
    public ResponseEntity<Vehicle> createVehicle(@RequestBody Vehicle vehicle) {
        try{
            Vehicle _vehicle = vehicleService.createVehicle(vehicle);
            return new ResponseEntity<>(_vehicle, HttpStatus.CREATED);
        }catch (Exception e){
            System.out.println("error guardando la cuestion");
            return new ResponseEntity<>(null, HttpStatus. INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("vehicles/brand/{brand}")
    public ResponseEntity<List<Vehicle>> getVehiclesByBrand(@PathVariable("brand") String brand){
        try {
            List<Vehicle> vehiclesList = vehicleService.getVehicleByBrand(brand);
            return new  ResponseEntity<>(vehiclesList, HttpStatus.OK);
        }catch (Exception e){
            System.out.println("error buscando por marca");
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("vehicle/edit/{id}")
    public ResponseEntity<Vehicle> editVehicleById(@PathVariable("id") String id, @RequestBody Vehicle vehicleDetails){
        Vehicle vehicle = vehicleService.editVehicle(id, vehicleDetails);
        return new  ResponseEntity<>(vehicle, HttpStatus.OK);
    }

}
