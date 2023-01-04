package com.bilgeadam.utility;

import com.bilgeadam.entity.Car;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    public static List<String> readFile(String path){
        List<String> list = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(path))){
            String line;
            while((line = reader.readLine()) != null){
                list.add(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    //parseLong vs valueOf araştır
    public static Car convertToCar(String[] array){
        Car car = new Car(Long.parseLong(array[0]), array[1], array[2], Long.parseLong(array[3]), Long.parseLong(array[4]));
        return car;
    }

    public static List<Car> getCarList(List<String> list){
        List<Car> carList = new ArrayList<>();
        for(String stringList : list){
            carList.add(convertToCar(stringList.split(",")));
        }
        //string --> 1,Lincoln,Continental,1992,9
        //converToCar --> {1},{Lincoln},{Continental}, {1992}, {9}
        return carList;
    }
}
