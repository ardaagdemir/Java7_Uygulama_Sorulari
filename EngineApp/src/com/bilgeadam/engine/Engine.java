package com.bilgeadam.engine;

public class Engine {

    private static final int DEFAULT_ENGINEPOWER = 70;
    private static final double DEFAULT_ENGINEVOLUME = 1.0;

    private int enginePower;
    private double engineVolume;
    private EFuelType fuelType;

    public Engine(int enginePower, double engineVolume, EFuelType fuelType) {
        this.enginePower = enginePower;
        this.engineVolume = engineVolume;
        this.fuelType = fuelType;
    }

    public Engine(){
        this(DEFAULT_ENGINEPOWER, DEFAULT_ENGINEVOLUME, EFuelType.Hybrid);
    }


    public double getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(double engineVolume) {
        this.engineVolume = engineVolume;
    }

    public EFuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(EFuelType fuelType) {
        this.fuelType = fuelType;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "enginePower=" + enginePower +
                ", engineVolume=" + engineVolume +
                ", fuelType=" + fuelType +
                '}';
    }
}
