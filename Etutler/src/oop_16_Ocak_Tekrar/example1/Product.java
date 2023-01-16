package oop_16_Ocak_Tekrar.example1;

public class Product {

    //sınıfların içerisinde özellikler tanımlarız(property, field, attribute, entity)
    //bu özellikler sınıftan oluşturulan nesne sayesinde her yerde kullanılabilir
    //bu özellikleri erişime açık veya kapalı olarak belirleyebiliyoruz (private, public)
    //bu özellikleri sınıftan bir nesne üretildiğinde default olarak çalıştırabiliriz(constructor)

    private Integer productId;
    private String name;
    private double unitPrice;
    private int unitInStock;

    //Encapsulation --> Kapsülleme, değişkenlerin ve metotların dışarıdan erişime açık veya kapalı olması durumunu kontrol eden bir yaklaşımdır.
    //Bu yaklaşımı 'access modifier' denilen bir anahtar kelime ile yönetiriz.
    //access modifier --> public, private, protected, default


    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getUnitInStock() {
        return unitInStock;
    }

    public void setUnitInStock(int unitInStock) {
        this.unitInStock = unitInStock;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", unitPrice=" + unitPrice +
                ", unitInStock=" + unitInStock +
                '}';
    }
}
