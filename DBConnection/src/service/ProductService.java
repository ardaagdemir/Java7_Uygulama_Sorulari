package service;

import db_connection.DB;
import entity.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductService {

//    CRUD işlemlerini bu sınıfa taşıyınız
//    Insert ve update metotlarının parametreleri Product sınıfı olsun. Kodlarımızı buna göre 'refactor' edelim.
//    CRUD metotları statik olmamalı
//    Ortak kullanan kodların globale taşınması gerekmektedir.

//    Refactor --> var olan kodun düzenlenmesi, yeniden oluşturulması, kontrol edilmesi, okunurluğunu ve anlaşılırlığını arttırmaya çalışmak için yapılan bütün işlemler

    DB db = new DB();
    Product product = null;
    List<Object> ls = new ArrayList<>();
    public void getAllProducts() {
        try {
            //BU örnek güvenli değildir
            /*String sqlLogin = "select * from user where email='' +email+ and password = '' +userPassword+";

            Statement sınıfını, sql sorguları sırasında 'sql injection' tipindeki zafiyetleri önleyebilmek için kullanıyoruz.
            Bu önlem statement sınıfı ile tam olarak alınamamaktadır. Bunun yerine 'PreparedStatement' sınıfı kullanılmalıdır.
            Değerler boş geçilirse veya '+userEmail+' formatında tanımlanırsa(yukarıdaki sqlLogin gibi) yapılacak injection atağında true döner
            ve hacker sisteme giriş yapmış olur.
            Bu durumlarda PreparedStatement sınıfı ile beraber '+userEmail+' kullanmak yerine '?' formatı kullanılır. Ve gönderilecek veriler arka planda kontrol edilir.
            Bu sayede database' de kayıtlı olmayan bir kullanıcının 'sql injection' ile erişmesi engellenebilir.*/

            PreparedStatement stProduct = db.connection.prepareStatement("Select * from product");
            ResultSet rsProduct = stProduct.executeQuery();

            while (rsProduct.next()) {
                Integer productId = rsProduct.getInt("productId");
                String productName = rsProduct.getString("productName");
                String productCategory = rsProduct.getString("productCategory");
                Integer price = rsProduct.getInt("price");
                String description = rsProduct.getString("description");

                product = new Product(productId, productName, productCategory, price, description);
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

    //Soru --> productInsert() metodu yazınız ve verileri veritabanına kaydediniz.
    //productInsert metodu içerisinde değişkenleri tek tek tanımlamak yerine Product sınıfından bir değişken tanımlayarak o değişken sayesinde
    //ilgili property'lerin getter metotlarına ulaşarak bu işlemi gerçekleştirebiliriz. (productInsert(Product product))
    public void productInsert(Product product) {
        DB db = new DB();
        try {
            PreparedStatement insertStatement = db.connection.prepareStatement
                    ("insert into product(productName, productCategory, price, description) " +
                            "values(?,?,?,?)");
            insertStatement.setString(1, product.getProductName());
            insertStatement.setString(2, product.getProductCategory());
            insertStatement.setInt(3, product.getPrice());
            insertStatement.setString(4, product.getDescription());
            insertStatement.executeUpdate();
            System.out.println("Product is added");
            getAllProducts();

            insertStatement.close();
            db.connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //Soru --> productDelete() metodunuz yazınız ve veritabanından bir veriyi siliniz.
    public void productDelete(int productId) {
        try {
            PreparedStatement list = db.connection.prepareStatement("select productId from product");
            ResultSet rsList = list.executeQuery();
            while (rsList.next()) {
                ls.add(rsList.getInt("productId"));
            }
            if (ls.contains(productId)) {
                PreparedStatement deleteStatement = db.connection.prepareStatement("delete from product where productId = ?");
                deleteStatement.setInt(1, productId);
                deleteStatement.executeUpdate();
                deleteStatement.close();
            } else {
                System.out.println("Product is not found");
            }
            db.connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    //Soru --> productUpdate() metodunu yazınız ve veritabanından bir veriyi güncelleyiniz.
    public void productUpdate(Product product) {
        try {
            PreparedStatement list = db.connection.prepareStatement("select productId from product");
            ResultSet rsList = list.executeQuery();
            while (rsList.next()) {
                ls.add(rsList.getInt("productId"));
            }
            if (ls.contains(product.getProductId())) {
                //veritabanında değişiklik yapılacağı zaman önemli olan 'gönderilen sorgudaki column name' lerdir.(örn; productName, productCategory gibi)
                //değiştirilmek istenen değerler aşağıdaki gibi 'set' anahtar kelimesinden sonra belirtilerek main de oluşturulacak product nesnesi buna göre tanımlanmalıdır.
                PreparedStatement updateStatement = db.connection.prepareStatement("update product set productName=?, productCategory=?, price= ?, description=? where productId = ?");

                updateStatement.setString(1, product.getProductName());
                updateStatement.setString(2, product.getProductCategory());
                updateStatement.setInt(3, product.getPrice());
                updateStatement.setString(4, product.getDescription());
                updateStatement.setInt(5, product.getProductId());
                updateStatement.executeUpdate();
                getAllProducts();

                updateStatement.close();
                db.connection.close();
            }
            else{
                System.out.println("Product is not found");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //Soru --> productById() metodunu yazınız ve ilgili id'ye sahip productın bütün özelliklerini gösteriniz.
    public void productById(int productID){
        try {
            PreparedStatement list = db.connection.prepareStatement("select productId from product");
            ResultSet rsList = list.executeQuery();
            while (rsList.next()) {
                ls.add(rsList.getInt("productId"));
            }
            ls.forEach(item -> System.out.println(item));
            if(ls.contains(productID)){
                PreparedStatement productIdStatement = db.connection.prepareStatement("select * from product where productId=?");
                productIdStatement.setInt(1, productID);

                ResultSet productIdRs = productIdStatement.executeQuery();
                while(productIdRs.next()){
                    Integer productId = productIdRs.getInt("productId");
                    String productName = productIdRs.getString("productName");
                    String productCategory = productIdRs.getString("productCategory");
                    Integer price = productIdRs.getInt("price");
                    String description = productIdRs.getString("description");

                    product = new Product(productId,productName,productCategory,price,description);
                    System.out.println(product);
                }
                productIdRs.close();
                db.connection.close();
            }else {
                System.out.println("Product is not found");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage() + " -->Error");
        }
    }

    //Soru --> insertAll() metodunu yazınız. Birden çok kayıt yapabilen bir metot olacak.
    //Üretilen birden çok nesneyi tek seferde yazdırabilmeli
    public void insertAll(List<Product> products){
        if (products.isEmpty()){
            System.out.println("List is empty");
        }else {
            try{
                PreparedStatement preparedStatement = db.connection.prepareStatement(
                        "insert into product(productName, productCategory, price, description) "
                                +"values(?,?,?,?)");
                //products.forEach(item -> item.);
                for(Product item : products) {
                    preparedStatement.setString(1, item.getProductName());
                    preparedStatement.setString(2, item.getProductCategory());
                    preparedStatement.setInt(3, item.getPrice());
                    preparedStatement.setString(4, item.getDescription());
                    preparedStatement.executeUpdate();
                }
                getAllProducts();
                preparedStatement.close();
                db.connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
