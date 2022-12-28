package com.bilgeadam.engine_app.engine;

import com.bilgeadam.engine_app.motorlandvehicles.Car;
import com.bilgeadam.engine_app.motorlandvehicles.MotorLandVehicle;
import com.bilgeadam.engine_app.motorwatervehicles.Sail;


public class Main {
    public static void main(String[] args) {

        Engine engine1 = new Engine(105, 1.6, EFuelType.Gasoline);
        Car car1 = new Car("BMW", 2016, engine1, "06 ABC 06", 4, 5);

        //enginePower update
        engine1.setEnginePower(140);
        System.out.println(car1);

        Sail sail1 = new Sail("Abakus", 2013, engine1, 1, 4, 13, "Türkiye", " ", 2, "Tek Gövde");

        //hullMaterial update
        sail1.setHullMaterial("Fiberglass");
        System.out.println(sail1);
    }
}
