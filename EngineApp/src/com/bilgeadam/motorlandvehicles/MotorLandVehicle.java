package com.bilgeadam.motorlandvehicles;

import com.bilgeadam.engine.Engine;
import com.bilgeadam.engine.MotorVehicle;

public abstract class MotorLandVehicle extends MotorVehicle {

    private String licensePlate;
    private int numberOfWheels;

    public MotorLandVehicle(String brand, int year, Engine engine, String licensePlate, int numberOfWheels) {
        super(brand, year, engine);
        this.licensePlate = licensePlate;
        this.numberOfWheels = numberOfWheels;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public int getNumberOfWheels() {
        return numberOfWheels;
    }

    public void setNumberOfWheels(int numberOfWheels) {
        this.numberOfWheels = numberOfWheels;
    }

    @Override
    public String toString() {
        return "MotorLandVehicle{" +
                "licensePlate='" + licensePlate + '\'' +
                ", numberOfWheels=" + numberOfWheels +
                "} " + super.toString();
    }

}
