package com.bilgeadam.engine_app.engine;

public class MotorVehicle {

    private String brand;
    private int year;
    private Engine engine;

    public MotorVehicle(String brand, int year, Engine engine) {
        this.brand = brand;
        this.year = year;
        this.engine = engine;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "MotorVehicle{" +
                "brand='" + brand + '\'' +
                ", year=" + year +
                ", engine=" + engine +
                '}';
    }
}
