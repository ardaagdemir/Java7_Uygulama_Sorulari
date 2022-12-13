package com.bilgeadam.engine_app.motorwatervehicles;

import com.bilgeadam.engine_app.engine.Engine;

public class Sail extends MotorWaterVehicles{

    private String type;

    public Sail(String brand, int year, Engine engine, int numberOfEngine, int width, int height, String registry, String hullMaterial, int numberOfCabin, String type) {
        super(brand, year, engine, numberOfEngine, width, height, registry, hullMaterial, numberOfCabin);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Sail{" +
                "type='" + type + '\'' +
                "} " + super.toString();
    }
}
