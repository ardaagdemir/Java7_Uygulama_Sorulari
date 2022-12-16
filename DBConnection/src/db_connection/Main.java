package db_connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class Main {

    public static void main(String[] args) {
        /*Bütün productları getir
        getAllProducts();
        */

        /*Product ekle
        Product product1 = new Product(null, "Kılıfı", "Elektronik", 80, "Telefon");
        productInsert(product1);*/
        productInsert("Telefon Kılıfı", "Elektronik", 70, "Telefon");

    }
    public static void getAllProducts(){
        DB db = new DB();
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

            while(rsProduct.next()){
                Integer productId = rsProduct.getInt("productId");
                String productName = rsProduct.getString("productName");
                String productCategory = rsProduct.getString("productCategory");
                Integer price = rsProduct.getInt("price");
                String description = rsProduct.getString("description");

                Product product = new Product(productId,productName,productCategory,price,description);
                System.out.println(product);
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









}
