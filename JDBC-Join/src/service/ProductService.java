package service;

import entity.Category;
import entity.DB;
import entity.Product;
import repository.ICrud;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//getAll, save, saveAll, update, getById, delete

public class ProductService implements ICrud<Product> {

    DB db = new DB();
    Product product;
    List<Object> ls = new ArrayList<>();

    @Override
    public void getAll() {

        try {
            PreparedStatement stProduct = db.connection.prepareStatement(
                    "SELECT P.\"productId\",P.\"productName\",C.\"categoryId\",C.\"categoryName\",P.price,P.\"description\" FROM products as P\n" +
                            "INNER JOIN categories as C\n" +
                            "ON P.\"categoryId\" = C.\"categoryId\" order by p.\"productId\"");
            ResultSet rs = stProduct.executeQuery();
            while (rs.next()) {
                Integer productId = rs.getInt("productId");
                String productName = rs.getString("productName");
                Integer categoryId = rs.getInt("categoryId");
                String categoryName = rs.getString("categoryName");
                int price = rs.getInt("price");
                String description = rs.getString("description");

                product = new Product(productId, new Category(categoryId, categoryName), productName, price, description);
                ls.add(product);
            }
            if (ls.isEmpty()) {
                System.out.println("Product is empty");
            } else {
                ls.forEach(item -> System.out.println(item));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void save(Product product) {
        try {

            PreparedStatement insertStatement = db.connection.prepareStatement(
                    "insert into public.products(\"categoryId\", \"productName\",\"price\",\"description\")" +
                            "values(?,?,?,?)");

            insertStatement.setInt(1, product.getCategory().getCategoryId());
            insertStatement.setString(2, product.getProductName());
            insertStatement.setInt(3, product.getPrice());
            insertStatement.setString(4, product.getDescription());
            insertStatement.executeUpdate();
            System.out.println("Product is added");
            getAll();

            insertStatement.close();
            db.connection.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void update(Product product) {
        try {
            PreparedStatement list = db.connection.prepareStatement("select \"productId\" from products");
            ResultSet rsList = list.executeQuery();
            while (rsList.next()) {
                ls.add(rsList.getInt("productId"));
            }
            if (ls.contains(product.getProductId())) {

                PreparedStatement updateStatement = db.connection.prepareStatement(
                        "update products set \"categoryId\"=?, \"productName\"=?, \"price\"= ?, \"description\"= ?" +
                                "where \"productId\" = ?");

                updateStatement.setInt(1, product.getCategory().getCategoryId());
                updateStatement.setString(2, product.getProductName());
                updateStatement.setInt(3, product.getPrice());
                updateStatement.setString(4, product.getDescription());
                updateStatement.setInt(5, product.getProductId());
                updateStatement.executeUpdate();

                System.out.println("Product is updated");
                getAll();
                updateStatement.close();
            }else {
                System.out.println("Product is not found");
            }
            db.connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
    }
    @Override
    public void saveAll(List<Product> products){
        if (products.isEmpty()){
            System.out.println("List is empty");
        }else {
            try {
                PreparedStatement insertStatement = db.connection.prepareStatement
                        ("insert into products(\"categoryId\", \"productName\", \"price\", \"description\") " +
                                "values(?,?,?,?)");

                for(Product product : products){
                    insertStatement.setInt(1, product.getCategory().getCategoryId());
                    insertStatement.setString(2, product.getProductName());
                    insertStatement.setInt(3, product.getPrice());
                    insertStatement.setString(4, product.getDescription());
                    insertStatement.executeUpdate();
                }
            }catch (SQLException e){
                throw new RuntimeException(e);
            }
        }
    }
    @Override
    public void delete(int productId) {
        try {
            PreparedStatement list = db.connection.prepareStatement("SELECT \"productId\" FROM products");
            ResultSet rsList = list.executeQuery();
            while (rsList.next()) {
                ls.add(rsList.getInt("productId"));
            }
            if (ls.contains(productId)) {
                PreparedStatement deleteStatement = db.connection.prepareStatement("DELETE FROM products WHERE \"productId\"=?");
                deleteStatement.setInt(1, productId);
                deleteStatement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void getById(int productID) {
        try {
            PreparedStatement list = db.connection.prepareStatement("select \"productId\" from products");
            ResultSet rsList = list.executeQuery();
            while (rsList.next()) {
                ls.add(rsList.getInt("productId"));
            }

            if (ls.contains(productID)){
                PreparedStatement st = db.connection.prepareStatement(
                        "SELECT P.\"productId\",P.\"productName\",C.\"categoryId\",C.\"categoryName\",P.price,P.\"description\" " +
                        "FROM products as P\n" +
                        "INNER JOIN categories as C\n" +
                        "ON P.\"categoryId\" = C.\"categoryId\" where p.\"productId\"=?");
                st.setInt(1, productID);
                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    Integer productId = rs.getInt("productId");
                    Integer categoryId = rs.getInt("categoryId");
                    String categoryName = rs.getString("categoryName");
                    String productName = rs.getString("productName");
                    Integer price = rs.getInt("price");
                    String description = rs.getString("description");

                    product = new Product(productId, new Category(categoryId, categoryName), productName, price, description);
                    System.out.println(product);
                }
                st.close();
            }
            else {
                System.out.println("Product is not found");
            }
            db.connection.close();
        } catch (Exception ex) {
            System.err.println("Product Error: " + ex);
        }
    }
}