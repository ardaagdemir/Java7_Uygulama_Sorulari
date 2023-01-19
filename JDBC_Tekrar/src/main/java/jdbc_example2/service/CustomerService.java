
package jdbc_example2.service;


import jdbc_example2.entity.Category;
import jdbc_example2.entity.Customer;
import jdbc_example2.entity.Product;
import utils.DB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerService implements ICrud<Customer> {

    DB db = new DB();
    List<Customer> list = new ArrayList<>();
    Customer customer;

    @Override
    public void read() {
        try{
            String sql = "select cu.id, cu.name as CustomerName, cu.identityNumber, p.name as ProductName, p.price, p.unitInStock, p.description, c.name as CategoryName from products as p\n" +
                    "inner join categories as c on p.cid=c.id\n" +
                    "inner join customers as cu on cu.pid=p.id";
            PreparedStatement preparedStatement = db.connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                Integer customerId = rs.getInt("id");
                String customerName = rs. getString("CustomerName");
                String identityNumber = rs.getString("identityNumber");
                String productName = rs.getString("ProductName");
                double price = rs.getDouble("price");
                int unitInStock = rs.getInt("unitInStock");
                String description = rs.getString("description");
                String categoryName = rs.getString("CategoryName");

                customer = new Customer(customerId, customerName, identityNumber, new Product(new Category(categoryName), productName, price, unitInStock, description));
                list.add(customer);
            }
            if (list.isEmpty()){
                System.out.println("Boş");
            }else {
                list.forEach(System.out::println);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void save(Customer customer) {
        try {
            String sql = "insert into customers(pid, name, identityNumber)  values(?,?,?)";
            PreparedStatement preparedStatement = db.connection.prepareStatement(sql);
            preparedStatement.setInt(1, customer.getProduct().getId());
            preparedStatement.setString(2, customer.getName());
            preparedStatement.setString(3, customer.getIdentityNumber());

            preparedStatement.executeUpdate();
            System.out.println("Customer added");
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void update(Customer customer) {

    }

    @Override
    public void delete(int id) {
        String sql = "select id from customers";

        String sql1 = "delete from customers where id = ?";
    }

    public void likeByCustomerName(String name){
        String sql = "select cu.name as customerName, cu.identityNumber, p.name as productName, c.name as categoryName from customers as cu \n" +
                "inner join products as p on p.id = cu.pid\n" +
                "inner join categories as c on p.cid = c.id where cu.name like ?";
        try {
            PreparedStatement preparedStatement = db.connection.prepareStatement(sql);
            preparedStatement.setString(1, "%" + name + "%");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String customerName = rs.getString("customerName");
                Integer identityNumber = rs.getInt("identityNumber");
                String productName = rs.getString("productName");
                String categoryName = rs.getString("categoryName");

                System.out.println(customerName + ", " + identityNumber + ", " + productName + ", " + categoryName);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void whereByPrice(int price, String name){
        String sql = "select cu.name as customerName, p.name as productName, p.price, c.name as categoryName from customers as cu \n" +
                "inner join products as p on p.id = cu.pid\n" +
                "inner join categories as c on p.cid = c.id where p.price < ? and cu.name like ?";
        try {
            PreparedStatement preparedStatement = db.connection.prepareStatement(sql);
            preparedStatement.setInt(1, price);
            preparedStatement.setString(2, "%" + name + "%");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String customerName = rs.getString("customerName");
                String productName = rs.getString("productName");
                Integer productPrice = rs.getInt("price");
                String categoryName = rs.getString("categoryName");
                customer = new Customer(customerName, new Product(new Category(categoryName), productName, productPrice));
                list.add(customer);
            }
            list.forEach(System.out::println);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
