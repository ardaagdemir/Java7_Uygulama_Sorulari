package com.bilgeadam.controller;

import com.bilgeadam.entity.Car;
import com.bilgeadam.repository.CarRepository;
import com.bilgeadam.service.CarService;

import java.util.Scanner;

public class Manager {

    static Scanner scanner = new Scanner(System.in);
    CarRepository carRepository;
    CarService carService;

    public Manager(){
        carRepository = new CarRepository();
        carService = new CarService();
    }

    public static void main(String[] args) {
        Manager manager = new Manager();
        manager.menu();
    }

    public static Car getCarInformation() {
        System.out.println("Lütfen araba markasını giriniz: ");
        String brand = scanner.nextLine();

        System.out.println("Lütfen araba modelini giriniz: ");
        String carModel = scanner.nextLine();

        System.out.println("Lütfen model yılını yazınız: ");
        long modelYear = Long.parseLong(scanner.nextLine());

        System.out.println("Lütfen bayi no yazınız: ");
        long dealerShipId = Long.parseLong(scanner.nextLine());

        return new Car(brand, carModel, modelYear, dealerShipId);
    }

    public void menu(){
        int input = 0;
        do {
            System.out.println("0-Çıkış");
            System.out.println("1-Dosyadan Databaseye Verileri Aktarma");
            System.out.println("2-Araba Ekle");
            System.out.println("3-Araba Güncelle");
            System.out.println("4-Araba Sil");
            System.out.println("5-Arabaları Listele");

            input = Integer.parseInt(scanner.nextLine());
            switch (input) {
                case 1:
                    carService.downloadFileToDatabase();
                    break;
                case 2:
                    carService.save();
                    break;
                case 3:
                    System.out.print("ID: ");
                    long updateId = scanner.nextLong();
                    scanner.nextLine();
                    Car updateCar = getCarInformation();
                    carRepository.update(updateCar, updateId);
                    System.out.println("Car is updated --> " + updateCar.getBrand());
                    break;
                case 4:
                    System.out.print("ID: ");
                    long deleteId = scanner.nextLong();
                    scanner.nextLine();
                    carRepository.delete(deleteId);
                    System.out.println("Deleted");
                    break;
                case 5:
                    carRepository.getAll().forEach(System.out::println);
                    break;
            }
            if (input == 0){
                break;
            }
        }while(true);
    }
}
