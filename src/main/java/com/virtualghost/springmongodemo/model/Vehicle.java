package com.virtualghost.springmongodemo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "vehicles")
@Data
public class Vehicle {

    @Id
    private String id;
    private String brand;
    private String model;
    private int displacement;
    private int year;
    private String color;


    public Vehicle(String brand, String model, int displacement, int year, String color){
        this.brand = brand;
        this.model = model;
        this.displacement = displacement;
        this.year = year;
        this.color = color;
    }


}
