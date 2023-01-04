package com.bilgeadam.repository;

import com.bilgeadam.entity.Car;
import com.bilgeadam.utility.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarRepository implements ICrud<Car>{
    DBConnection dbConnection;
    Connection connection;

    @Override
    public List<Car> getAll() {
        String sql = "select * from cars order by \"modelYear\" desc";
        List<Car> carList = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Car car = new Car(resultSet.getInt("id"),
                        resultSet.getString("brand"),
                        resultSet.getString("carModel"),
                        resultSet.getLong("modelYear"),
                        resultSet.getLong("dealerShipId"));
                carList.add(car);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return carList;
    }

    @Override
    public void save(Car car) {
        String sql = "insert into cars(\"id\", \"brand\", \"carModel\",\"dealerShipId\",\"modelYear\") values(?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, car.getId());
            preparedStatement.setString(2, car.getBrand());
            preparedStatement.setString(3, car.getCarModel());
            preparedStatement.setLong(4, car.getDealerShipId());
            preparedStatement.setLong(5, car.getModelYear());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Car car, long id) {
        String sql = "update cars set \"brand\" =?, \"carModel\"=?,\"dealerShipId\"=?,\"modelYear\"=? where id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, car.getBrand());
            preparedStatement.setString(2, car.getCarModel());
            preparedStatement.setLong(3, car.getDealerShipId());
            preparedStatement.setLong(4, car.getModelYear());
            preparedStatement.setLong(5, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(long id) {
        String sql = "delete from cars where id =" +id;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveAll(List<Car> car) {
        String sql = "insert into cars(\"brand\", \"carModel\",\"dealerShipId\",\"modelYear\") values(?,?,?,?)";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            for (Car item : car){
                preparedStatement.setString(1, item.getBrand());
                preparedStatement.setString(2, item.getCarModel());
                preparedStatement.setLong(3, item.getDealerShipId());
                preparedStatement.setLong(4, item.getModelYear());
            }
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
