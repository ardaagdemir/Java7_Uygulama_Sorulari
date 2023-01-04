package com.bilgeadam.service;

import com.bilgeadam.controller.Manager;
import com.bilgeadam.entity.Car;
import com.bilgeadam.repository.CarRepository;
import com.bilgeadam.utility.Constant;
import com.bilgeadam.utility.FileUtils;

public class CarService {

    //dependency injection --> dependency inversion principle(DIP)
    CarRepository carRepository;

    public CarService(){
        carRepository = new CarRepository();
    }

    public void downloadFileToDatabase(){
        if(carRepository.databaseControl())
            System.out.println("Already Exist");
        else
            carRepository.saveAll(FileUtils.getCarList(FileUtils.readFile(Constant.carFile)));
            System.out.println("Success");
    }

    public void save(){
        carRepository.save(Manager.getCarInformation());
    }
}
