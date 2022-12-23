package db_connection;

import entity.Product;
import service.ProductService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        DB db = new DB();
        System.out.println(db);
        //Bütün productları getir
        ProductService productService = new ProductService();
        //productService.getAllProducts();

        //Product ekle
//        Product product1 = new Product(null, "Kitaplık", "Mobilya", 2000, "Cam kapaklı kitaplık");
//        productService.productInsert(product1);

        //Product sil
        //productService.productDelete(8);

        //Product update
        /*Product product1 = new Product(39, "Kütüphane", "Mobilya", 3000, "Cam kapaklı kütüphane");
        productService.productUpdate(product1);*/

        //Product id sorgusu
        //productService.productById(8);

        /*Product product1 = new Product(null, "Kılıfı", "Elektronik", 80, "Telefon");
        Product product2 = new Product(null, "Kılıfı", "Moda", 90, "Telefon");
        Product product3 = new Product(null, "Kılıfı", "Spor&Outdoor", 100, "Telefon");
        Product product4 = new Product(null, "Kılıfı", "Elektronik", 110, "Telefon");
        List<Product> productList = new ArrayList<>();
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);
        productService.insertAll(productList);*/
    }
}
