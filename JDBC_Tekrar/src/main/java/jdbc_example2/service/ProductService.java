package jdbc_example2.service;

import jdbc_example2.entity.Category;
import jdbc_example2.entity.Product;
import utils.DB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductService implements ICrud<Product>{

    DB db = new DB();
    List<Object> list = new ArrayList<>();
    Product product;


    @Override
    public void read() {
        try{
            String sql = "select p.name, p.price, p.unitInStock, p.description, c.name from products as p inner join categories as c on p.cid=c.id";
            PreparedStatement preparedStatement = db.connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                int unitInStock = rs.getInt("unitInStock");
                String description = rs.getString("description");
                String categoryName = rs.getString("name");

                product = new Product(new Category(categoryName), name, price, unitInStock, description);
                list.add(product);
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
    public void save(Product product) {
        try {
            String sql = "insert into products(cid, name, price, unitInStock, description)  values(?,?,?,?,?)";
            PreparedStatement preparedStatement = db.connection.prepareStatement(sql);
            preparedStatement.setInt(1, product.getCategory().getId());
            preparedStatement.setString(2, product.getName());
            preparedStatement.setDouble(3, product.getPrice());
            preparedStatement.setInt(4, product.getUnitInStock());
            preparedStatement.setString(5, product.getDescription());

            preparedStatement.executeUpdate();
            System.out.println("Product added");
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void update(Product product) {

    }

    @Override
    public void delete(int id) {

    }
}
