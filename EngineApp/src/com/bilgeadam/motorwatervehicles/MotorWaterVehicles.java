package com.bilgeadam.motorwatervehicles;

import com.bilgeadam.engine.Engine;
import com.bilgeadam.engine.MotorVehicle;

public abstract class MotorWaterVehicles extends MotorVehicle {

    private int numberOfEngine;
    private int width;
    private int height;
    private String registry;
    private String hullMaterial;
    private int numberOfCabin;

    public MotorWaterVehicles(String brand, int year, Engine engine, int numberOfEngine, int width, int height, String registry, String hullMaterial, int numberOfCabin) {
        super(brand, year, engine);
        this.numberOfEngine = numberOfEngine;
        this.width = width;
        this.height = height;
        this.registry = registry;
        this.hullMaterial = hullMaterial;
        this.numberOfCabin = numberOfCabin;
    }

    public int getNumberOfEngine() {
        return numberOfEngine;
    }

    public void setNumberOfEngine(int numberOfEngine) {
        this.numberOfEngine = numberOfEngine;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getRegistry() {
        return registry;
    }

    public void setRegistry(String registry) {
        this.registry = registry;
    }

    public String getHullMaterial() {
        return hullMaterial;
    }

    public void setHullMaterial(String hullMaterial) {
        this.hullMaterial = hullMaterial;
    }

    public int getNumberOfCabin() {
        return numberOfCabin;
    }

    public void setNumberOfCabin(int numberOfCabin) {
        this.numberOfCabin = numberOfCabin;
    }

    @Override
    public String toString() {
        return "MotorWaterVehicles{" +
                "numberOfEngine=" + numberOfEngine +
                ", width=" + width +
                ", height=" + height +
                ", registry='" + registry + '\'' +
                ", hullMaterial='" + hullMaterial + '\'' +
                ", numberOfCabin=" + numberOfCabin +
                '}' + super.toString();
    }
}
