package db_connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        //Bütün productları getir
        //getAllProducts();

        //Product ekle
        //productInsert("Kılıfı", "Elektronik", 80, "Telefon");

        //Product sil
        //productDelete(8);

        //Product update
        //productUpdate(5, 1300);

        //Product id sorgusu
        //productById(8);

        Product product1 = new Product(null, "Kılıfı", "Elektronik", 80, "Telefon");
        Product product2 = new Product(null, "Kılıfı", "Moda", 90, "Telefon");
        Product product3 = new Product(null, "Kılıfı", "Spor&Outdoor", 100, "Telefon");
        Product product4 = new Product(null, "Kılıfı", "Elektronik", 110, "Telefon");
        List<Product> productList = new ArrayList<>();
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);
        insertAll(productList);
    }

    public static void getAllProducts() {
        DB db = new DB();
        List<Product> ls = new ArrayList<>();
        Product product = null;
        try {
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
    public static void productInsert(String productName, String productCategory, int price, String description) {
        DB db = new DB();
        try {
            PreparedStatement insertStatement = db.connection.prepareStatement
                    ("insert into product(productName, productCategory, price, description) " +
                            "values(?,?,?,?)");
            insertStatement.setString(1, productName);
            insertStatement.setString(2, productCategory);
            insertStatement.setInt(3, price);
            insertStatement.setString(4, description);
            insertStatement.executeUpdate();
            System.out.println("Product is added");

            insertStatement.close();
            db.connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //Soru --> productDelete() metodunuz yazınız ve veritabanından bir veriyi siliniz.
    public static void productDelete(int productId) {
        DB db = new DB();
        List<Integer> ls = new ArrayList<>();
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
    public static void productUpdate(int productId, int price) {
        DB db = new DB();
        List<Integer> ls = new ArrayList();
        try {
            PreparedStatement list = db.connection.prepareStatement("select productId from product");
            ResultSet rsList = list.executeQuery();
            while (rsList.next()) {
                ls.add(rsList.getInt("productId"));
            }
            if (ls.contains(productId)) {
                PreparedStatement updateStatement = db.connection.prepareStatement("update product set price= ? where productId = ?");

                updateStatement.setInt(1, price);
                updateStatement.setInt(2, productId);
                updateStatement.executeUpdate();
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
    public static void productById(int productID){
        DB db = new DB();
        List<Integer> ls = new ArrayList<>();
        Product product = null;
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
    public static void insertAll(List<Product> products){
        DB db = new DB();
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

    //veritabanı adı --> jdbc_join
    //tabloların ismi products, categories
    //products --> productId, categoryId, name, price, description
    //categories --> categoryId, name
}

